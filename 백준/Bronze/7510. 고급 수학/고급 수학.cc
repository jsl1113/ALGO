#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {
	int testcase;
	cin >> testcase;
	int *arr = new int[3];
	string *ans = new string[testcase];
	for (int i = 0; i < testcase; i++) {
		cin >> arr[0] >> arr[1] >> arr[2];
		sort(arr, arr + 3);
		if (arr[2] * arr[2] == arr[0] * arr[0] + arr[1] * arr[1]) 
			ans[i] = "yes";
		else ans[i] = "no";
	}
	for (int i = 0; i < testcase; i++) {
		cout << "Scenario #" << i + 1 << ":" << '\n';
		cout << ans[i] << "\n\n";
	}
}