package B2929;

public class FilaEnc {

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
