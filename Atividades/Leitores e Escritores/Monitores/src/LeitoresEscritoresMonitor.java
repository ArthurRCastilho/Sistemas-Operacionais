class LeitoresEscritoresMonitor {

    private int leitoresAtivos = 0; // Número de leitores ativos
    private int escritoresAtivos = 0; // Número de escritores ativos
    private int escritoresEsperando = 0; // Número de escritores esperando

    public synchronized void iniciarLeitura() throws InterruptedException {
        while (escritoresAtivos > 0 || escritoresEsperando > 0) {
            wait(); // Leitores esperam se há escritores ativos ou esperando
        }
        leitoresAtivos++;
        System.out.println(Thread.currentThread().getName() + " começou a ler.");
    }

    public synchronized void finalizarLeitura() {
        leitoresAtivos--;
        System.out.println(Thread.currentThread().getName() + " terminou de ler.");
        if (leitoresAtivos == 0) {
            notifyAll(); // Acorda escritores esperando
        }
    }

    public synchronized void iniciarEscrita() throws InterruptedException {
        escritoresEsperando++;
        while (escritoresAtivos > 0 || leitoresAtivos > 0) {
            wait(); // Escritores esperam se há leitores ou escritores ativos
        }
        escritoresEsperando--;
        escritoresAtivos++;
        System.out.println(Thread.currentThread().getName() + " começou a escrever.");
    }

    public synchronized void finalizarEscrita() {
        escritoresAtivos--;
        System.out.println(Thread.currentThread().getName() + " terminou de escrever.");
        notifyAll(); // Acorda leitores e escritores esperando
    }
}
