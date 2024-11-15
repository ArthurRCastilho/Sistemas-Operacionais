class Escritor implements Runnable {
    private final LeitoresEscritoresMonitor monitor;

    public Escritor(LeitoresEscritoresMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                monitor.iniciarEscrita();
                Thread.sleep((int) (Math.random() * 1000)); // Simula escrita
                monitor.finalizarEscrita();
                Thread.sleep((int) (Math.random() * 1000)); // Tempo entre escritas
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}