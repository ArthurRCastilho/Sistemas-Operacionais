static class Escritor implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                // Escritor tenta acessar o recurso
                recurso.acquire();
                System.out.println(Thread.currentThread().getName() + " está escrevendo.");
                Thread.sleep((int) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " terminou de escrever.");
                recurso.release();

                Thread.sleep((int) (Math.random() * 1000)); // Simula tempo entre escritas
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}