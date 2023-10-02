#include <bits/stdc++.h>

using namespace std;

int main () {

    int N;
    int valor;
    stack<int> pilhaMenor;
    queue<string> outputs;

    cin >> N;

    while (N--) {

        string textos;
        char c;

        cin >> textos;
        c = textos.at(1);

        if (c == 'U') {  
            cin >> valor;
            if (pilhaMenor.empty())
                pilhaMenor.push(valor);
            else
                pilhaMenor.push(min(pilhaMenor.top(), valor));
        } else if (pilhaMenor.empty()) 
            outputs.push("EMPTY");
          else if (c == 'O') 
            pilhaMenor.pop();                 
          else
            outputs.push(to_string(pilhaMenor.top()));

    }

    N = outputs.size();

    while (N--) {
        cout << outputs.front() << endl;
        outputs.pop();
    }

    return 0;
}