class Mensagem {
    enum Tipo { LEITURA, ESCRITA, FINALIZAR }

    private final Tipo tipo;
    private final String conteudo;

    public Mensagem(Tipo tipo, String conteudo) {
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getConteudo() {
        return conteudo;
    }
}
