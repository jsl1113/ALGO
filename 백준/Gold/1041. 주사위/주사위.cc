#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int arr[6];
	long long n, up = 0, down = 0;
	cin >> n;
	for (int i = 0; i < 6; i++) cin >> arr[i];
	if (n == 1) {
		sort(arr, arr + 6);
		for (int i = 0; i < 5; i++) up += arr[i];
		cout << up << endl;
	}
	else {
		arr[0] = arr[0] < arr[5] ? arr[0] : arr[5];
		arr[1] = arr[1] < arr[4] ? arr[1] : arr[4];
		arr[2] = arr[2] < arr[3] ? arr[2] : arr[3];
		sort(arr, arr + 3);
		up = 4 * ((arr[0] + arr[1] + arr[2]) + (n - 2)*(arr[0] + arr[1])) + (n - 2)*(n - 2)*arr[0];
		down = (n - 1) * 4 * ((arr[0] + arr[1]) + (n - 2)*arr[0]);
		cout << up + down << endl;
	}
}