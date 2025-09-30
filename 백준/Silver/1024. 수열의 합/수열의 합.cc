#include <iostream>
using namespace std;

int main(void)
{
	int n, s; 
	cin >> n >> s;
	int t, x = -1, y = -1;
	for (int i = s; i <= 100; i++) {
		t = (i - 1)*i / 2;
		if ((n - t) % i == 0 && (n - t) / i >= 0) {
			x = (n - t) / i;
			y = i;
			break;
		}
	}
	if (x == -1) cout << -1;
	else
		for (int i = 0; i < y; i++) cout << x + i << ' ';
	cout << endl;
}
