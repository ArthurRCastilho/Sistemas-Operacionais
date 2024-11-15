import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Gerenciador {
    private final BlockingQueue<Mensagem> filaMensagens = new LinkedBlockingQueue<>();
    private int leitoresAtivos = 0;
    private boolean escritorAtivo = false;

    public void enviarMensagem(Mensagem mensagem) {
        try {
            filaMensagens.put(mensagem);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processarMensagens() {
        while (true) {
            try {
                Mensagem mensagem = filaMensagens.take();
                switch (mensagem.getTipo()) {
                    case LEITURA:
                        iniciarLeitura(mensagem.getConteudo());
                        break;
                    case ESCRITA:
                        iniciarEscrita(mensagem.getConteudo());
                        break;
                    case FINALIZAR:
                        System.out.println("Finalizando sistema...");
                        return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void iniciarLeitura(String leitor) throws InterruptedException {
        while (escritorAtivo) {
            wait();
        }
        leitoresAtivos++;
        System.out.println(leitor + " começou a ler.");
        Thread.sleep((int) (Math.random() * 1000)); // Simula leitura
        finalizarLeitura(leitor);
    }

    private synchronized void finalizarLeitura(String leitor) {
        leitoresAtivos--;
        System.out.println(leitor + " terminou de ler.");
        if (leitoresAtivos == 0) {
            notifyAll(); // Libera escritores esperando
        }
    }

    private synchronized void iniciarEscrita(String escritor) throws InterruptedException {
        while (leitoresAtivos > 0 || escritorAtivo) {
            wait();
        }
        escritorAtivo = true;
        System.out.println(escritor + " começou a escrever.");
        Thread.sleep((int) (Math.random() * 1000)); // Simula escrita
        finalizarEscrita(escritor);
    }

    private synchronized void finalizarEscrita(String escritor) {
        escritorAtivo = false;
        System.out.println(escritor + " terminou de escrever.");
        notifyAll(); // Libera leitores e escritores esperando
    }
}