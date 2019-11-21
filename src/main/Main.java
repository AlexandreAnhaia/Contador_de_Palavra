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

//        //Funcionando sequencial
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
//        Task task = new Task(textoCompleto, "Deus");
//        task.contaPalavras(textoCompleto, "Deus", false);
//        System.out.println(task.getQuantidadePalavras());
//        //####################################################
//        //Funcionando sequencial

        Controller controller = new Controller(4);
        ArrayList<Task> threads = controller.getThreads();
        controller.contadorPalavras();
        controller.instaciarArrays();
        controller.newThreads(controller.getNumeroThreads());
        controller.setArrays(controller.getTextoCompleto(), controller.getNumeroThreads());

        for (Task task : threads) {
            task.run();
        }

        try {
            for (Task task : threads) {
                task.join();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        int somatorio = 0;
        for (Task task : threads) {
            somatorio = somatorio + task.getQuantidadePalavras();
            System.out.println(task.getTexto().size());
        }
        System.out.println(somatorio);

//
//        Controller controller = new Controller(4);
//        controller.contadorPalavras();
//        //controller.splitArray(textoCompleto, controller.getNumeroThreads());
//        controller.criaArrays(textoCompleto, controller.getContador());
////        controller.splitArray((String[]) textoCompleto.toArray(), controller.getContador());
////        System.out.println(controller.getArrays().get(0).size());
////        System.out.println(controller.getArrays().get(1).size());
////        System.out.println(controller.getArrays().get(2).size());
////        System.out.println(controller.getArrays().get(3).size());
    }

}
