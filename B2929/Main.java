package B2929;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws outException {

        int N, valor;
        PilhaEnc pilha = new PilhaEnc();
        PilhaEnc pilhaMenor = new PilhaEnc();
        Scanner sc = new Scanner(System.in);
        FilaEnc outputs = new FilaEnc();
        String string;



        N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
          //  if (!string.isEmpty())
          //      string.delete(0, string.length());

            string = (sc.nextLine());

            switch (string.charAt(1)) {
                case 'U':
                    valor = Integer.parseInt(string.substring(5));
                    pilha.push(valor);
                    if (pilhaMenor.vazia())
                        pilhaMenor.push(valor);
                    else if (pilhaMenor.top() >= valor)
                        pilhaMenor.push(valor);
                    break;
                case 'O':
                    if (pilha.vazia())
                        outputs.insere("EMPTY");
                    else {
                        valor = pilha.pop();
                        if (pilhaMenor.top() == valor)
                            pilhaMenor.pop();
                    }
                    break;
                default:
                    if (pilha.vazia())
                        outputs.insere("EMPTY");
                    else
                        outputs.insere(String.valueOf(pilhaMenor.top()));
                    break;


            }



        }


        sc.close();
// bla
        for (int i = 0; i < outputs.tamanho();)
            System.out.println(outputs.remove());

    }

}