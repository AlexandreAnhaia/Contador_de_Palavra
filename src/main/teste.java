/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class teste {

    public static int contador = 0;

    public static void main(String[] args) throws IOException {
        contadorPalavras();
        System.out.println(contador);
        System.out.println(divideArray());

    }

    public static void contadorPalavras() throws FileNotFoundException, IOException {
        String arquivoTxt = "./Alexandre.txt";
        String linha;
        BufferedReader bufferedReader;
        ArrayList<String> textoCompleto = new ArrayList<String>();

        bufferedReader = new BufferedReader(new FileReader(arquivoTxt));
        while ((linha = bufferedReader.readLine()) != null) {
            String[] palavras = linha.split(" ");
            for (int i = 0; i < palavras.length; i++) {

                teste.contador = contador + 1;
                textoCompleto.add(palavras[i]);
            }
        }
    }

    public static int divideArray() {
        int retorno = teste.contador / 4;
        System.out.println(retorno);
        return retorno;
    }
}
