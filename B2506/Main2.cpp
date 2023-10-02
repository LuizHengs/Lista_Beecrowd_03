#include <bits/stdc++.h>

using namespace std;

int main () {
    int n;

    while (cin >> n) {
        int tempo = 420;
        int H, M, C;
        int contador = 0;

        for (int i = 0; i < n; i++) {
            cin >> H >> M >> C;

            while (tempo < (H * 60 + M))
                tempo += 30;

            if (tempo - (H * 60 + M) > C) {
                contador++;
            }
            tempo += 30;
        }

        cout << contador << endl;
    }

    return 0;
}