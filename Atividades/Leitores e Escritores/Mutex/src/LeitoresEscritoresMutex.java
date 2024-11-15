import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeitoresEscritoresMutex {

    private static int leitoresAtivos = 0; // Número de leitores ativos
    private static final Lock mutex = new ReentrantLock(); // Lock para proteger o contador de leitores
    private static final Lock recurso = new ReentrantLock(); // Lock para proteger o recurso compartilhado

    static class Leitor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // Região crítica para modificar o contador de leitores
                    LeitoresEscritoresMutex.mutex.lock();
                    leitoresAtivos++;
                    if (leitoresAtivos == 1) {
                        recurso.lock(); // Primeiro leitor bloqueia o recurso para escritores
                    }
                    mutex.unlock();

                    // Leitura do recurso
                    System.out.println(Thread.currentThread().getName() + " está lendo.");
                    Thread.sleep((int) (Math.random() * 1000));

                    // Região crítica para modificar o contador de leitores
                    mutex.lock();
                    leitoresAtivos--;
                    if (leitoresAtivos == 0) {
                        recurso.unlock(); // Último leitor libera o recurso
                    }
                    mutex.unlock();

                    Thread.sleep((int) (Math.random() * 1000)); // Simula tempo entre leituras
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Escritor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // Escritor tenta acessar o recurso
                    recurso.lock();
                    System.out.println(Thread.currentThread().getName() + " está escrevendo.");
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println(Thread.currentThread().getName() + " terminou de escrever.");
                    recurso.unlock();

                    Thread.sleep((int) (Math.random() * 1000)); // Simula tempo entre escritas
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
