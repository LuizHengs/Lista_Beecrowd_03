package B2929;


import java.util.ArrayList;

class PilhaEnc {

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
    private ArrayList<Integer> menorElemento;
    private int nElementos;

    public PilhaEnc(){
        topo = null;
        nElementos = 0;
        menorElemento = new ArrayList<>();
    }

    /** Verifica se a Pilha está vazia*/
    public boolean vazia () {
        if (nElementos == 0)
            return true;
        else
            return false;
    }

    /** Obtém o tamanho da Pilha*/
    public int tamanho() {
        return nElementos;

	/*  No p = topo;
	    	int i = 0;
	    	while(p != null){
	       p = p.getProx();
	       i++;
	    }
	    return i;
	*/
    }

    /** Consulta o elemento do topo da Pilha
     Joga  Exception se a pilha estiver vazia.*/
    public int top () throws outException {
        if (vazia()){
            throw new outException("VAZIA", "Esta pilha esta vazia!");
        }

        return topo.getConteudo();
    }

    public int getMenorElemento() {
        return menorElemento.get(menorElemento.size() - 1);
    }

    public void removerMenorElemento() {
        while (!menorElemento.isEmpty())
            menorElemento.remove(menorElemento.size() - 1);
    }

    /** Insere um elemento no topo da pilha.
     Retorna true se a insercao funcionar*/
    public boolean push(int valor) {

        // Aloca memoria para novo no e preenche conteudo
        No novoNo = new No();
        novoNo.setConteudo(valor);

        if (menorElemento.isEmpty())
            menorElemento.add(valor);
        else if (menorElemento.get(menorElemento.size() - 1) >= valor)
            menorElemento.add(valor);


        // Faz o novo no apontar pro atual topo da pilha
        novoNo.setProx(topo);

        // Atualiza o topo da pilha que agora sera o novo nó
        topo = novoNo;

        // Atualiza o tamanho da pilha
        nElementos++;
        return true;
    }

    /** Retira o elemento do topo da pilha.
     Retorna -1 se a pilha estiver vazia.
     Caso contrário retorna o valor removido */
    public int pop () throws outException {
        if (vazia()) {
            throw new outException("VAZIA!", "Esta pilha esta vazia!");
        }
        // Guarda o nó que é topo da pilha e o seu conteudo
        No p = topo;
        int valor = p.getConteudo();

        if (!menorElemento.isEmpty() && menorElemento.get(menorElemento.size() - 1) == valor)
            menorElemento.remove(menorElemento.size() - 1);

        /* Modifica o topo da pilha para ser o proximo elemento (2o elemento da pilha) */
        /* Isso equivale a retirar o 1o elemento (topo) da pilha */
        topo = topo.getProx();

        // Decrementa o tamanho da pilha
        nElementos--;

        /* sugere ao garbage collector que libere a memoria
         *  da regiao apontada por p*/
        p= null;

        return valor;
    }

}
