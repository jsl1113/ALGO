#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	int t;
	cin >> t;
	int arr[80001] = { 0 };
	for (int i = 1; i <= 80000; i++) {
		if (i % 3 == 0 || i % 7 == 0) {
			arr[i] = arr[i - 1] + i;
		}
		else arr[i] = arr[i - 1];
	}
	while (t!=0) {
		int n;
		cin >> n;
		cout << arr[n] << '\n';
        t--;
	}
}