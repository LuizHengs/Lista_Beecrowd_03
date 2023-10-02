#include <bits/stdc++.h>
#include <iostream>

using namespace std;

int main () {

    
    int n, comando, valor;
    bool f = true;
    bool fp = true;
    bool p = true;
    bool fFinal = true;
    bool fpFinal = true;
    bool pFinal = true;
    
    while (cin >> n) {
        queue<int> fila;
        priority_queue<int> filaPri;
        stack<int> pilha;

        f = true;
        fp = true;
        p = true;
        fFinal = true;
        fpFinal = true;
        pFinal = true;

        while (n--) {

            

            cin >> comando;
            cin >> valor;

            if (comando == 1) {
                fila.push(valor);
                filaPri.push(valor);
                pilha.push(valor);
            } else {
                f = (valor == fila.front());
                fp = (valor == filaPri.top());
                p = (valor == pilha.top());
                fila.pop();
                filaPri.pop();
                pilha.pop();
            }
            
            if (f == false)
                fFinal = false;
            if (fp == false)
                fpFinal = false;
            if (p == false)
                pFinal = false;

        }

        if (!(fFinal || fpFinal || pFinal))
            cout << "impossible" << endl;
        else if ((!fFinal && (fpFinal && pFinal)) || (!fpFinal && (fFinal && pFinal)) || (!pFinal && (fFinal && fpFinal)) || (fFinal && fpFinal && pFinal))
            cout << "not sure" << endl;
        else if (fFinal)
            cout << "queue" << endl;
        else if (fpFinal)
            cout << "priority queue" << endl;
        else
            cout << "stack" << endl;
    }



    return 0;
}