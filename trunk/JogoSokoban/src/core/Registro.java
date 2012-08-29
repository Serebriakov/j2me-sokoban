package core;

import core.util.StringUtil;

/**
 *
 * @author jaspion
 */
public class Registro {

    String nome;
    String data;
    String score;

    public Registro(String nome, String data, String score) {
        this.nome = nome.replace(' ', '#');
        this.data = data;
        this.score = score;
    }

    public Registro(String valor) {
        String[] array = StringUtil.split(valor, ' ');

        if (array.length == 4) {

            nome = array[0].replace('#', ' ');
            data = array[1] + " " + array[2];
            score = array[3];
        } else if (array.length == 3) {
            nome = array[0].replace('#', ' ');
            data = array[1] ;
            score = array[2];
        }


    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getScoreString() {
        return score;
    }

    public String toString() {
        return nome + " " + data + " " + score;
    }

    public int getScore() {
        return Integer.valueOf(score.trim()).intValue();
    }
}