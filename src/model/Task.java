package model;

/**
 *
 * @author Alexandre
 */
public class Task extends Thread {

    private String texto;
    private String palavra;
    private String name;
    private int quantidadePalavras;

    public Task(String texto, String palavra) {
        this.texto = texto;
        this.palavra = palavra;
    }

    @Override
    public void run() {
        this.quantidadePalavras = contaPalavras(this.texto, this.palavra, false);
    }

    public int contaPalavras(String texto, String palavra, boolean caseSensitive) {

        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer textoBuffer = new StringBuffer();

        char[] chars = palavra.toCharArray();
        for (char c : chars) {
            stringBuffer.append("[");
            if (caseSensitive) {
                stringBuffer.append(Character.toString(c));
            } else {
                if (Character.isLetter(c)) {
                    stringBuffer.append(Character.toString(c).toLowerCase());
                    stringBuffer.append(Character.toString(c).toUpperCase());
                } else {
                    stringBuffer.append(Character.toString(c));
                }
            }
            stringBuffer.append("]");
        }
        textoBuffer.append(texto);
        /*
         * se o ultimo item do texto nao eh a palavra que estamos contando, subtrair 1
         * para nao dar errado
         */
        int lenght = textoBuffer.toString().split(stringBuffer.toString()).length;
        if (!texto.substring(texto.length() - palavra.length(), texto.length()).equals(palavra)) {
            lenght--;
        }
        return lenght;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
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
