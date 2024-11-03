import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaraCavalli {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Inserisci la lunghezza del percorso di gara (in metri): ");
        int lunghezzaGara = scanner.nextInt();
        scanner.nextLine();

       
        System.out.print("Inserisci i nomi dei cavalli separati da virgola: ");
        String[] nomiCavalli = scanner.nextLine().split(",");

       
        ArrayList<Cavallo> cavalli = new ArrayList<Cavallo>();
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
