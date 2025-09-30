#include <iostream>
using namespace std;

int main() {
	int arr[9], sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> arr[i];
		sum += arr[i];
	}
	for (int i = 0; i < 8; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (sum - arr[i] - arr[j] == 100) {
				for (int r = 0; r < 9; r++) {
					if (r != i && r != j) cout << arr[r] << endl;
				}
				return 0;
			}
		}
	}
}