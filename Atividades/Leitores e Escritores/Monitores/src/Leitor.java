class Leitor implements Runnable {
    private final LeitoresEscritoresMonitor monitor;

    public Leitor(LeitoresEscritoresMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                monitor.iniciarLeitura();
                Thread.sleep((int) (Math.random() * 1000)); // Simula leitura
                monitor.finalizarLeitura();
                Thread.sleep((int) (Math.random() * 1000)); // Tempo entre leituras
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}