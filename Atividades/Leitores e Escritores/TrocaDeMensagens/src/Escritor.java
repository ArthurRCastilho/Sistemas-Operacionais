class Escritor implements Runnable {
    private final Gerenciador gerenciador;
    private final String nome;

    public Escritor(Gerenciador gerenciador, String nome) {
        this.gerenciador = gerenciador;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                gerenciador.enviarMensagem(new Mensagem(Mensagem.Tipo.ESCRITA, nome));
                Thread.sleep((int) (Math.random() * 3000)); // Tempo entre escritas
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}