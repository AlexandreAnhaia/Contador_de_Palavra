package main;

import java.util.Scanner;
import model.Task;

/**
 *
 * @author Alexandre
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o texto desejado para contar as palavras: ");
        //String texto = "ESTOU TESTANDO O CODIGO, ESTOU TESTANDO O CODIGO, ESTOU TESTANDO O CODIGO ESTOU TESTANDO O CODIGO, ESTOU TESTANDO O CODIGO o";
        String texto = scanner.nextLine();

        String[] textoArray = texto.split(" ");
        int contador = textoArray.length;

        int valor = contador / 2;

        String texto1 = "";
        String texto2 = "";
        for (int i = 0; i < textoArray.length; i++) {
            if (i < valor) {
                texto1 = texto1 + " " + textoArray[i];
            } else {
                texto2 = texto2 + " " + textoArray[i];
            }
        }
        System.out.println("texto 1" + texto1);
        System.out.println("texto 2" + texto2);

        System.out.println("Digite a palavra a ser contada");
        String palavra = scanner.nextLine();

        Task task1 = new Task(texto1, palavra);
        task1.setName("Tarefa 1");
        Task task2 = new Task(texto2, palavra);
        task2.setName("Tarefa 2");

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int resultadoTarefa1 = task1.getQuantidadePalavras();
        int resultadoTarefa2 = task2.getQuantidadePalavras();
        int somatorio = resultadoTarefa1 + resultadoTarefa2;
        System.out.println("Total de Palavras da " + task1.getName() + " e id " + task1.getId() + ": " + task1.getQuantidadePalavras());
        System.out.println("Total de Palavras da " + task2.getName() + " e id " + task2.getId() + ": " + task2.getQuantidadePalavras());
        System.out.println("Total de Palavras: " + somatorio);

//Task taskTesteUnitario = new Task("feel seila seila feel", "feel");
        Task taskTesteUnitario = new Task(texto, palavra);
        int contadorUnitario = taskTesteUnitario.contaPalavras(taskTesteUnitario.getTexto(), taskTesteUnitario.getPalavra(), false);
        System.out.println("Contador de Palavras Não multi thread. total= " + contadorUnitario);
    }

}
