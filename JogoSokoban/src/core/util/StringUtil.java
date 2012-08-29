
package core.util;

import java.util.Vector;

/**
 *
 * @author jaspion
 */
public class StringUtil {
/**
 * from //www.devmedia.com.br/metodo-split-em-linguagem-j2me/6289#ixzz24skV6YP3
 * @param texto
 * @param separador
 * @return 
 */
    public final static String[] split(String texto, char separador) {
        if (texto == null) {
            return null;
        }

        // verifica se existe alguma informação na string texto

        int tamanhoTexto = texto.length();

        if (tamanhoTexto == 0) {
            return null;
        }

        Vector lista = new Vector();
        int i = 0;
        int start = 0;
        boolean permite = false;
        while (i < tamanhoTexto) {
            // percorre caracter a caracter tentando encontrar o separador
            // se encontrar o separador no primeiro carcater ele ignora

            if (texto.charAt(i) == separador) {
                if (permite) {
                    // pegando o pedaço da string entre os separadores
                    lista.addElement(texto.substring(start, i).trim());
                    permite = false;
                }
                // recebo a posição de onde posso começar a pegar os caracteres,
                // até a próxima vez que encontrar o separador ou terminar os caracteres
                start = ++i;
                continue;

            }
            permite = true;

            i++;

        }

        if (permite) {
            // guardando a informação em uma posição da lista
            lista.addElement(texto.substring(start, i).trim());
        }

        // convertendo o vetor em arrray
        String[] listaElementos = new String[lista.size()];
        lista.copyInto(listaElementos);
        return listaElementos;

    }
}