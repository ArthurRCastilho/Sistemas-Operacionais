public void main(String[] args) {
    // Criando threads de leitores e escritores
    for (int i = 0; i < 3; i++) {
        new Thread(new Leitor(), "Leitor " + (i + 1)).start();
    }
    for (int i = 0; i < 2; i++) {
        new Thread(new Escritor(), "Escritor " + (i + 1)).start();
    }
}