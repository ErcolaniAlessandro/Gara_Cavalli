import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

pubblic class Cavallo extends Thread {
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
