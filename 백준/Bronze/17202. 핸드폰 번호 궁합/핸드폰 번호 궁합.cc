#include <iostream>
#include <string>
using namespace std;

int main() {
	int arr[20];
	string x, y, str;
	cin >> x;
	cin >> y;
	for (int i = 0; i < 8; i++) {
		str += x.substr(i, 1);
		str += y.substr(i, 1);
	}
	for (int i = 0; i < 16; i++) {
		string tmp = str.substr(i, 1);
		int n = atoi(tmp.c_str());
		arr[i] = n;
	}
	int cnt = 16;
	while (cnt != 2) {
		for (int i = 0; i < cnt; i++) {
			if (arr[i] + arr[i + 1] >= 10) arr[i] = (arr[i] + arr[i + 1]) % 10;
			else arr[i] += arr[i + 1];
		}
		cnt--;
	}
	cout << arr[0] << arr[1];
}