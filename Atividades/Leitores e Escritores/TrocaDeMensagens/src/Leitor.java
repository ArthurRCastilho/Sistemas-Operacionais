class Leitor implements Runnable {
    private final Gerenciador gerenciador;
    private final String nome;

    public Leitor(Gerenciador gerenciador, String nome) {
        this.gerenciador = gerenciador;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                gerenciador.enviarMensagem(new Mensagem(Mensagem.Tipo.LEITURA, nome));
                Thread.sleep((int) (Math.random() * 2000)); // Tempo entre leituras
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}