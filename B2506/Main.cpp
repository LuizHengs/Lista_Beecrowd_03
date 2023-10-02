#include <bits/stdc++.h>

using namespace std;

int main () {

    int N;
    int H;
    int M;
    int quantCritico;

    while (cin >> N) {

        priority_queue<int, vector<int>, greater<int>> filaSUS;
        queue<int> filaConfia;
        quantCritico = 0;
        int mCritico[N];

        for (int i = 0; i < N; i++) {

            cin >> H;
            cin >> M;
            cin >> mCritico[i];

            filaConfia.push(H * 60 + M);

        }

        int comeco = filaConfia.front();
        int entrarFila = 0;
        //int quantidade = sizeof(m)/sizeof(m[0]);
        for (int tempo = comeco; !(filaConfia.empty()) || !(filaSUS.empty()); tempo += 30) {
            
            while (!(filaConfia.empty())) {
                if (filaConfia.front() <= tempo + 30) {
                    filaSUS.push(mCritico[entrarFila++] + filaConfia.front());  
                    filaConfia.pop();               
                } else
                    break;
            }

            if (filaSUS.top() < tempo)
                quantCritico++;
            
            //cout << "Primeiro: " << filaSUS.top() << endl << "Tempo: " << tempo << endl << "QuantCritico: " << quantCritico << endl;
            
            filaSUS.pop();

            //cout << "Último: " << filaSUS.top() << endl;
        }

        cout << quantCritico << endl;

    }


    return 0;
}