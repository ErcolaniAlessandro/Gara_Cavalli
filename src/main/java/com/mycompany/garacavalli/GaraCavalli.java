/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.garacavalli;

/**
 *
 * @author Utente
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Cavallo extends Thread {
    private final String nome;
    private final int lunghezzaPercorso;
    private int metriPercorsi = 0;
    private final Random random = new Random();

    public Cavallo(String nome, int lunghezzaPercorso) {
        this.nome = nome;
        this.lunghezzaPercorso = lunghezzaPercorso;
    }

    @Override
    public void run() {
        while (metriPercorsi < lunghezzaPercorso) {
            metriPercorsi += random.nextInt(5) + 1; // Passo casuale da 1 a 5 metri
            if (metriPercorsi > lunghezzaPercorso) {
                metriPercorsi = lunghezzaPercorso; // Non superare la lunghezza del percorso
            }
            System.out.printf("%s ha percorso %d metri.%n", nome, metriPercorsi);
            try {
                Thread.sleep(random.nextInt(1000) + 500); // Pausa tra 500 e 1500 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%s ha completato la gara!%n", nome);
    }
}

public class GaraCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lunghezza del percorso in metri: ");
        int lunghezzaPercorso = scanner.nextInt();

        System.out.print("Numero di cavalli: ");
        int numCavalli = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline rimasto

        List<Cavallo> cavalli = new ArrayList<>();

        // Creazione e avvio dei cavalli
        for (int i = 0; i < numCavalli; i++) {
            System.out.print("Nome del cavallo: ");
            String nome = scanner.nextLine();
            cavalli.add(new Cavallo(nome, lunghezzaPercorso));
        }

        // Avvio dei thread
        cavalli.forEach(Thread::start);

        // Attesa del completamento di tutti i cavalli
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("La gara è finita!");
        scanner.close();
    }
}
