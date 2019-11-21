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

    public static void main(String[] args) throws FileNotFoundException, IOException {

//         //Funcionando sequencial
//        //####################################################
//        String arquivoTxt = "./biblia-em-txt.txt";
//        String linha;
//        int contador = 0;
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivoTxt));
//
//        ArrayList<String> textoCompleto = new ArrayList<String>();
//
//        while ((linha = bufferedReader.readLine()) != null) {
//            String[] palavras = linha.split(" ");
//            for (int i = 0; i < palavras.length; i++) {
//                textoCompleto.add(palavras[i]);
//                contador++;
//            }
//        }
//        System.out.println(contador);
//
//        Task taskSequencial = new Task(textoCompleto, "Deus");
//        taskSequencial.contaPalavras(textoCompleto, "Deus");
//        System.out.println("Somatorio em sequencial " + taskSequencial.getQuantidadePalavras());
//         //####################################################
//        //Funcionando sequencial
        Controller controller = new Controller(4);
        controller.splitPalavras();
        controller.setArrays(controller.getTextoCompleto(), controller.getNumeroThreads());
//        controller.newThreads(controller.getNumeroThreads());
        ArrayList<Task> threads = controller.getThreads();

        for (Task task : threads) {
            task.run();
        }

        //ESPERA TODAS AS THREADS FINALIZAR AS TAREFAS
        try {
            for (Task task : threads) {
                task.join();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //PERCORRE TODAS AS THREADS PARA FAZER A SOMA TOTAL
        int somatorio = 0;
        for (Task task : threads) {
            somatorio = somatorio + task.getQuantidadePalavras();
        }

        //PRINTA SOMATORIO
        System.out.println("soma total feito em paralelo " + somatorio);

    }
}
