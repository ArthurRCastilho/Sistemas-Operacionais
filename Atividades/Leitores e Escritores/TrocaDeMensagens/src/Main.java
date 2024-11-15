public class Main {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();

        // Inicia thread para processar mensagens
        new Thread(gerenciador::processarMensagens, "Gerenciador").start();

        // Cria e inicia leitores
        for (int i = 1; i <= 3; i++) {
            new Thread(new Leitor(gerenciador, "Leitor " + i)).start();
        }

        // Cria e inicia escritores
        for (int i = 1; i <= 2; i++) {
            new Thread(new Escritor(gerenciador, "Escritor " + i)).start();
        }
    }
}
