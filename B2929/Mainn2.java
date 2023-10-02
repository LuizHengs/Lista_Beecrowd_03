import java.util.Scanner;

public class Mainn2 {
    public static void main(String[] args)  {

        int N, valor;
        PilhaEnc2 pilha = new PilhaEnc2();
        PilhaEnc2 pilhaMenor = new PilhaEnc2();
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


class PilhaEnc2 {

    public class No {
        private int conteudo;
        private No prox;

        public No(){
            setProx(null);
        }

        public int getConteudo() {
            return conteudo;
        }

        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }

    private No topo;
    private int nElementos;

    public PilhaEnc2(){
        topo = null;
        nElementos = 0;
    }

    public boolean vazia () {
        if (nElementos == 0)
            return true;
        else
            return false;
    }

    public int tamanho() {
        return nElementos;

    }

    public int top () {
        return topo.getConteudo();
    }

    public boolean push(int valor) {

        No novoNo = new No();
        novoNo.setConteudo(valor);

        novoNo.setProx(topo);

        topo = novoNo;

        nElementos++;
        return true;
    }

    public int pop () {
        No p = topo;
        int valor = p.getConteudo();

        topo = topo.getProx();

        nElementos--;


        p= null;

        return valor;
    }

}

class FilaEnc {

    public class NoF {
        private String conteudo;
        private NoF prox;

        public NoF (){
            setProx(null);
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        public NoF getProx() {
            return prox;
        }

        public void setProx(NoF prox) {
            this.prox = prox;
        }
    }

    private NoF inicio;  // aponta para o inicio da fila
    private NoF fim;    	// aponta para o fim da fila
    private int nElementos;

    /** Cria uma Fila  */
    public FilaEnc() {
        inicio = null;
        fim = null;
        nElementos = 0;
    }

    /**Verifica se a Fila está vazia */
    public boolean vazia () {
        if (nElementos == 0)
            return true;
        else
            return false;
    }

    /** Obtém o tamanho da Fila */
    public int tamanho () {
        return nElementos;
    }

    /** Consulta o elemento do início da fila
     Retorna -1 se a fila estiver vazia */
    public String primeiro () {
        if (vazia())
            return null; // Erro: Fila vazia

        return inicio.getConteudo();
    }

    /** Insere um elemento NoF fim de uma fila
     Retorna false se a mem. for insuficiente, true caso contrário*/
    public boolean insere (String valor) {
        NoF novoNo = new NoF();
        novoNo.setConteudo(valor);
        novoNo.setProx(null);

        if (vazia()){    /*Inserção em fila vazia */
            inicio = novoNo;
        }
        else {
            fim.setProx(novoNo); /* liga com a fila */
        }
        fim = novoNo; // atualiza o novo fim
        nElementos++;
        return true;
    }

    /**Retira o elemento do início da fila e retorna o seu valor
     Retorna -1 se a fila estiver vazia. */
    public String remove() {
        if (vazia()) {
            return null; // Erro: Fila vazia
        }

        NoF aux = inicio;
        String valor = inicio.getConteudo();

        //if (inicio == fim){ // Fila com 1 elemento 
        if (tamanho() == 1){ // Fila com 1 elemento 
            fim = null;
        }

        inicio = aux.getProx();

        // sugere ao garbage collector que libere a memoria
        //  da regiao apontada por p
        aux = null;

        nElementos--;
        return valor;
    }

}


