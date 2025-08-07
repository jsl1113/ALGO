#include <iostream>
using namespace std;

int main() {
	long long x, y, day = 0;
	cin >> x >> y;
	long long n = y - x;
	if (n < 1) {
		cout << day << endl;
		return 0;
	}
	while (day*day < n) ++day;
	if (day*day - day < n) cout << 2 * day - 1 << endl;
	else cout << 2 * day - 2;
	return 0;
}