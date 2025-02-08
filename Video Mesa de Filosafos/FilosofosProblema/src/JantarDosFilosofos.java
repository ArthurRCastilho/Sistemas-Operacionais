public class JantarDosFilosofos {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Garfo[] garfos = new Garfo[numFilosofos];
        Filosofo[] filosofos = new Filosofo[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            garfos[i] = new Garfo();
        }

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, garfos[i], garfos[(i + 1) % numFilosofos]);
            filosofos[i].start();
        }
    }
}