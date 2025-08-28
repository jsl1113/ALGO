#include <iostream>
using namespace std;

int main() {
	int n;
	int cnt = 2;
	cin >> n;
	while (n != 1) {
		if (n%cnt == 0) {
			n /= cnt;
			cout << cnt << endl;
		}
		else cnt++;
	}
}