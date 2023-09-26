package B1068;

import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws outException {

        PilhaEnc pilha = new PilhaEnc();
        Scanner sc = new Scanner(System.in);
        StringBuilder expression = new StringBuilder();
        char teste;
        //ArrayList<StringBuilder> lista = new ArrayList<>();
        int indexEsq = 0;
        int indexDir = 0;

        try {
            do {
                if (!expression.isEmpty())
                    expression.delete(0, expression.length() + 1);
                while (!pilha.vazia())
                    pilha.pop();

                expression.append(sc.nextLine());

                while (indexEsq != -1 || indexDir != -1) {
                    indexEsq = expression.indexOf("(", indexEsq);
                    indexDir = expression.indexOf(")", indexDir);
                    if (indexEsq < indexDir) {
                        indexEsq = pegarEsq(pilha, expression, indexEsq);
                        indexDir = pegarDir(pilha, expression, indexDir);
                    } else {
                        indexDir = pegarDir(pilha, expression, indexDir);
                        indexEsq = pegarEsq(pilha, expression, indexEsq);
                    }
                }

                indexEsq = 0;
                indexDir = 0;

                if (pilha.vazia())
                    System.out.println("correct");
                else
                    System.out.println("incorrect");
            } while (sc.hasNextLine());
        } catch (Exception erro) {
            System.out.println("correct");
        }



    }

    public static int pegarDir (PilhaEnc pilha, StringBuilder expression, int indexDir) throws outException {
        char teste;
        if (indexDir != -1) {
            teste = expression.charAt(indexDir++);
            //System.out.println(teste);
            if (pilha.vazia() || !(pilha.top() == '('))
                pilha.push(teste);
            else {
                pilha.pop();
            }
        }

        return indexDir;
    }

    public static int pegarEsq (PilhaEnc pilha, StringBuilder expression, int indexEsq) throws outException {
        char teste;
        if (indexEsq != -1) {
            teste = expression.charAt(indexEsq++);
            //System.out.println(teste);
            pilha.push(teste);
        }

        return indexEsq;
    }
}