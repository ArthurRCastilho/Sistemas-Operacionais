import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Escritor implements Runnable {
    private final RecursoCompartilhado recurso;
    private final CyclicBarrier barreira;
    private final String nome;

    public Escritor(RecursoCompartilhado recurso, CyclicBarrier barreira, String nome) {
        this.recurso = recurso;
        this.barreira = barreira;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Fase 1: Escrita
                recurso.escrever(nome);

                // Ponto de sincronização
                System.out.println(nome + " aguardando na barreira.");
                barreira.await();

                // Simula tempo antes de próxima escrita
                Thread.sleep((int) (Math.random() * 3000));
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}