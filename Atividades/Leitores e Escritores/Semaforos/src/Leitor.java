static class Leitor implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                // Região crítica para modificar o contador de leitores
                mutex.acquire();
                leitoresAtivos++;
                if (leitoresAtivos == 1) {
                    recurso.acquire(); // Primeiro leitor bloqueia o recurso para escritores
                }
                mutex.release();

                // Leitura do recurso
                System.out.println(Thread.currentThread().getName() + " está lendo.");
                Thread.sleep((int) (Math.random() * 1000));

                // Região crítica para modificar o contador de leitores
                mutex.acquire();
                leitoresAtivos--;
                if (leitoresAtivos == 0) {
                    recurso.release(); // Último leitor libera o recurso
                }
                mutex.release();

                Thread.sleep((int) (Math.random() * 1000)); // Simula tempo entre leituras
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}