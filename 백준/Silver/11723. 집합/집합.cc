#include <iostream>
#include <string>
using namespace std;

int m, x, bit;
string cal;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> m;

	while (m--) {
		cin >> cal;
		if (cal == "add") {
			cin >> x;
			bit |= (1 << x);
		}
		else if (cal == "remove") {
			cin >> x;
			bit &= ~(1 << x);
		}
		else if (cal == "check") {
			cin >> x;
			if (bit & (1 << x)) cout << 1 << '\n';
			else cout << 0 << '\n';
		}
		else if (cal == "toggle") {
			cin >> x;
			bit ^= (1 << x);
		}
		else if (cal == "all") bit = (1 << 21) - 1;
		else if (cal == "empty") bit = 0;
	}
	return 0;
}