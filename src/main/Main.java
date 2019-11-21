package main;

import controller.Controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author Alexandre
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        executaSequencial();
        System.out.println("----------------------------------------------");
        executaParalelo(4);
    }

    public static void executaParalelo(int numeroThreads) throws InterruptedException {
        Controller controller = new Controller(numeroThreads);
        controller.splitPalavras();
        controller.setArrays(controller.getTextoCompleto(), controller.getNumeroThreads());
//        controller.newThreads(controller.getNumeroThreads());
        ArrayList<Task> threads = controller.getThreads();

        long startTime = System.currentTimeMillis();
        for (Task task : threads) {
            task.run();
        }
        for (Task task : threads) {
            task.join();
        }

        long stopTime = System.currentTimeMillis();
        long finalTime = stopTime - startTime;

        int somatorio = 0;
        for (Task task : threads) {
            somatorio = somatorio + task.getQuantidadePalavras();
        }

        //PRINTA SOMATORIO
        System.out.println("soma total feito em paralelo " + somatorio);
        System.out.println("tempo total gasto em parelelo " + (float) finalTime / 1000 + " seconds");
    }

    public static void executaSequencial() throws FileNotFoundException, IOException {
        //Funcionando sequencial
        //####################################################
        String arquivoTxt = "./biblia-em-txt.txt";
        String linha;
        int contador = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivoTxt));

        ArrayList<String> textoCompleto = new ArrayList<String>();

        long startTime = System.currentTimeMillis();
        while ((linha = bufferedReader.readLine()) != null) {
            String[] palavras = linha.split(" ");
            for (int i = 0; i < palavras.length; i++) {
                textoCompleto.add(palavras[i]);
                contador++;
            }
        }

        long stopTime = System.currentTimeMillis();
        long finalTime = stopTime - startTime;
        System.out.println("Contador de palavras do Sequencial " + contador);

        Task taskSequencial = new Task(textoCompleto, "Deus");
        taskSequencial.contaPalavras(textoCompleto, "Deus");
        System.out.println("Somatorio em sequencial " + taskSequencial.getQuantidadePalavras());
        System.out.println("tempo total gasto em sequencial " + (float) finalTime / 1000 + " seconds");
        //####################################################
        //Funcionando sequencial
    }
}
