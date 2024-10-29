import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaraCavalli {

    
    static class Cavallo extends Thread {
        private final String nome;
        private final int lunghezzaGara;
        private int distanzaPercorsa = 0;

        public Cavallo(String nome, int lunghezzaGara) {
            this.nome = nome;
            this.lunghezzaGara = lunghezzaGara;
        }

        @Override
        public void run() {
            while (distanzaPercorsa < lunghezzaGara) {
                distanzaPercorsa += 10; 
                System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri");

                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(nome + " ha terminato la gara!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Inserisci la lunghezza del percorso di gara (in metri): ");
        int lunghezzaGara = scanner.nextInt();
        scanner.nextLine();

       
        System.out.print("Inserisci i nomi dei cavalli separati da virgola: ");
        String[] nomiCavalli = scanner.nextLine().split(",");

       
        List<Cavallo> cavalli = new ArrayList<>();
        for (String nome : nomiCavalli) {
            Cavallo cavallo = new Cavallo(nome.trim(), lunghezzaGara);
            cavalli.add(cavallo);
            cavallo.start();
        }

       
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La gara è terminata!");
        scanner.close();
    }
}
