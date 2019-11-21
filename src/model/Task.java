package model;

import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Task extends Thread {

    private ArrayList<String> texto;
    private String palavra;
    private String name;
    private int quantidadePalavras;

    public Task(ArrayList<String> texto, String palavra) {
        this.texto = texto;
        this.palavra = palavra;
    }

    public Task() {
    }

    public void run() {
        int quantidade = this.quantidadePalavras = contaPalavras(this.texto, this.palavra);
        this.quantidadePalavras = quantidade;
    }

    public int contaPalavras(ArrayList<String> texto, String palavra) {
        for (int i = 0; i < texto.size(); i++) {
            if (texto.get(i).equals(palavra)) {
                this.quantidadePalavras++;
            }
        }
        return quantidadePalavras;
    }

    public ArrayList<String> getTexto() {
        return texto;
    }

    public void setTexto(ArrayList<String> texto) {
        this.texto = texto;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getQuantidadePalavras() {
        return quantidadePalavras;
    }

}
