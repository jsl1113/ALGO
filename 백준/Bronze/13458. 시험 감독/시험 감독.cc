#include <iostream>
using namespace std;

int main() {
	int n, b, c;
	long long candidate = 0;
	cin >> n;
	int *a = new int[1000001];
	for (int i = 0; i < n; i++) cin >> a[i];
	cin >> b >> c;
	for (int i = 0; i < n; i++) {
		candidate++;
		a[i] -= b;
		if (a[i] <= 0) continue;
		if (a[i] % c == 0) candidate += a[i] / c;
		else candidate += a[i] / c+1;
	}
	cout << candidate << endl;
	delete[] a;
}