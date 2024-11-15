import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_THREADS = 5; // Total de threads (leitores + escritores)
        RecursoCompartilhado recurso = new RecursoCompartilhado();

        // Cria a barreira com o número total de threads e uma ação ao final
        CyclicBarrier barreira = new CyclicBarrier(TOTAL_THREADS, () ->
                System.out.println("Todos os threads alcançaram a barreira. Sincronização concluída.\n")
        );

        // Cria e inicia threads leitoras
        for (int i = 1; i <= 3; i++) {
            new Thread(new Leitor(recurso, barreira, "Leitor " + i)).start();
        }

        // Cria e inicia threads escritoras
        for (int i = 1; i <= 2; i++) {
            new Thread(new Escritor(recurso, barreira, "Escritor " + i)).start();
        }
    }
}