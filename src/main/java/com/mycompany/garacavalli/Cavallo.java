/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.garacavalli;

class Cavallo extends Thread {
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
