public class Main {
    public static void main(String[] args) {
        LeitoresEscritoresMonitor monitor = new LeitoresEscritoresMonitor();

        // Cria threads para leitores
        for (int i = 0; i < 3; i++) {
            new Thread(new Leitor(monitor), "Leitor " + (i + 1)).start();
        }

        // Cria threads para escritores
        for (int i = 0; i < 2; i++) {
            new Thread(new Escritor(monitor), "Escritor " + (i + 1)).start();
        }
    }
}
