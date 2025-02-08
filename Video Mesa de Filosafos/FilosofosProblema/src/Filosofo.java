class Filosofo extends Thread {
    private final int id;
    private final Garfo garfoEsquerdo;
    private final Garfo garfoDireito;

    public Filosofo(int id, Garfo garfoEsquerdo, Garfo garfoDireito) {
        this.id = id;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + (id+1) + " está pensando.");
        Thread.sleep((int) (Math.random() * 1000));
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + (id+1) + " está comendo.");
        Thread.sleep((int) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                pensar();
                if (garfoEsquerdo.pegar()) {
                    try {
                        if (garfoDireito.pegar()) {
                            try {
                                comer();
                            } finally {
                                garfoDireito.soltar();
                            }
                        }
                    } finally {
                        garfoEsquerdo.soltar();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}