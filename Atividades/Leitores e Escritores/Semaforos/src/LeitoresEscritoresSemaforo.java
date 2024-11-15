import java.util.concurrent.Semaphore;

public class LeitoresEscritoresSemaforo {

    private static int leitoresAtivos = 0; // Número de leitores ativos
    private static final Semaphore mutex = new Semaphore(1); // Controla acesso à contagem de leitores
    private static final Semaphore recurso = new Semaphore(1); // Controla acesso ao recurso compartilhado

}
