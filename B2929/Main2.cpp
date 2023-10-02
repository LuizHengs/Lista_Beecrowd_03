#include <bits/stdc++.h>

using namespace std;

class tipoNo {
  public:
        int numero;
        tipoNo *proximo;

        ~tipoNo () {
            this->numero = 0;
            this->proximo = NULL;
        }

        int getNumero () {
            return this->numero;
        }

        void setNumero (int numero) {
            this->numero = numero;
        }

        tipoNo *getProximo () {
            return proximo;
        }

        void setProximo (tipoNo *proximo) {
            this->proximo = proximo;
        }

};

class tipoPilha {
    public:
        tipoNo *topo;
        int nElementos;

         ~tipoPilha () {
            this->topo = NULL;
            this->nElementos = 0;
        }

        bool vazia() {
            return (nElementos == 0);
        }

        int tamanho () {
            return nElementos;
        }

        int topoC (){
            if (vazia())
                return -1;
            return topo->getNumero();
        }
        bool push (int numero) {
            tipoNo *novoNo = new tipoNo;
            novoNo->setNumero(numero);
            novoNo->setProximo(this->topo);
            this->topo = novoNo;
            nElementos++;
            return true;
        }

        int pop () {
            if (vazia())
                return -1;
            
            tipoNo *p = topo;
            int valor = p->getNumero();

            topo = topo->getProximo();

            nElementos--;

            delete p;

            return valor;
        }


}; 

int main () {

    int N;
    int valor;
    tipoPilha pilhaMenor;
    queue<string> outputs;

    cin >> N;

    while (N--) {

        string textos;
        char c;

        cin >> textos;
        c = textos.at(1);

        if (c == 'U') {  
            cin >> valor;
            if (pilhaMenor.vazia()) {
                pilhaMenor.push(valor);
            } else {
                pilhaMenor.push(min(pilhaMenor.topoC(), valor));
        } else {if (pilhaMenor.vazia()) { 
            outputs.push("vazia");
        }} else if (c == 'O') 
            pilhaMenor.pop();                 
          else
            outputs.push(to_string(pilhaMenor.topoC()));

    }

    N = outputs.size();

    while (N--) {
        cout << outputs.front() << endl;
        outputs.pop();
    }

    return 0;
}

