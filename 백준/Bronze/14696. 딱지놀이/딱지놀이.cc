#include <iostream>
#include <algorithm>	
using namespace std;

int main() {
	int round, tmp, x, cnt=0;
	cin >> round;
	int *result = new int[round];
	for (int i = 1; i <= round; i++) {
		int a[5] = { 0, };
		int b[5] = { 0, };
		for (int j = 1; j <= 2; j++) {
			cin >> tmp;
			for (int r = 1; r <= tmp; r++) {
				cin >> x;
				if (j == 1) a[x] += 1;
				else b[x] += 1;
			}
		}
		for (int j = 4; j > 0; j--) {
			if (a[j] > b[j]) {
				result[cnt] = 1;
				break;
			}
			else if (a[j] < b[j]) {
				result[cnt] = 2;
				break;
			}
			else if (j == 1 && a[j] == b[j]) {
				result[cnt] = 0;
				break;
			}
		}
		cnt++;
	}
	for (int i = 0; i < round; i++) {
		if (result[i] == 1) cout << "A\n";
		else if (result[i] == 2) cout << "B\n";
		else cout << "D\n";
	}
}