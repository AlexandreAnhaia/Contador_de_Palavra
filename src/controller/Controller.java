package controller;

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
public class Controller {

    private int numeroThreads;
    private String arquivoTxt = "./biblia-em-txt.txt";
    private String linha;
    private int contador = 0;
    private BufferedReader bufferedReader;
    private ArrayList<String> textoCompleto = new ArrayList<String>();
    private ArrayList<ArrayList<String>> arrays = new ArrayList<ArrayList<String>>();
    private ArrayList<Task> threads = new ArrayList<Task>();

    public Controller(int numeroThreads) {
        this.numeroThreads = numeroThreads;
//        splitPalavras();
//        setArrays(textoCompleto, numeroThreads);
//        this.threads = newThreads(numeroThreads);
//        setaArrays(numeroThreads);
    }

    public void splitPalavras() {
        try {
            bufferedReader = new BufferedReader(new FileReader(arquivoTxt));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            while ((linha = bufferedReader.readLine()) != null) {
                String[] palavras = linha.split(" ");
                for (int i = 0; i < palavras.length; i++) {
                    this.contador = contador + 1;
                    textoCompleto.add(palavras[i]);
                }
            }
            System.out.println("Contador de palavras do controlle: " + contador);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int returnNumPalavrasPorThread() {
        int contador = getContador();
        int retorno = contador / numeroThreads;
        return retorno;
    }

    public void setArrays(ArrayList<String> textoCompleto, int numeroThreads) {
        int numeroPalavrasPorThread = returnNumPalavrasPorThread();
        instaciarArrays();
        newThreads(numeroThreads);

        for (int a = 0; a < textoCompleto.size() - 1; a++) {
            int thread = a % numeroThreads;
            this.arrays.get(thread).add(textoCompleto.get(a));
        }
        System.out.println("sucesso ao dividir as palavras para cada thread");
    }

    public void instaciarArrays() {
        for (int i = 0; i < numeroThreads; i++) {
            ArrayList<String> array = new ArrayList<String>();
            arrays.add(array);
        }
    }

    public ArrayList<Task> newThreads(int numeroThreads) {
//        setaArrays(numeroThreads);
        for (int i = 0; i < numeroThreads; i++) {
            Task task = new Task();
            task.setName("task " + i);
            task.setTexto(arrays.get(i));
            task.setPalavra("Deus");
            this.threads.add(task);
        }
        System.out.println("sucesso new Threads");
        return threads;
    }

    //    public void setaArrays(int numeroThreads) {
//        for (int i = 0; i < numeroThreads; i++) {
//            threads.get(i).setTexto(arrays.get(i));
//        }
//    }
    public int getNumeroThreads() {
        return numeroThreads;
    }

    public int getContador() {
        return contador;
    }

    public ArrayList<ArrayList<String>> getArrays() {
        return arrays;
    }

    public ArrayList<Task> getThreads() {
        return threads;
    }

    public String getArquivoTxt() {
        return arquivoTxt;
    }

    public String getLinha() {
        return linha;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public ArrayList<String> getTextoCompleto() {
        return textoCompleto;
    }

}
