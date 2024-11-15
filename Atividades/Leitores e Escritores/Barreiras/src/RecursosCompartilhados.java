class RecursoCompartilhado {
    public void ler(String leitor) {
        System.out.println(leitor + " está lendo...");
        try {
            Thread.sleep((int) (Math.random() * 1000)); // Simula o tempo de leitura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(leitor + " terminou de ler.");
    }

    public void escrever(String escritor) {
        System.out.println(escritor + " está escrevendo...");
        try {
            Thread.sleep((int) (Math.random() * 1000)); // Simula o tempo de escrita
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(escritor + " terminou de escrever.");
    }
}




