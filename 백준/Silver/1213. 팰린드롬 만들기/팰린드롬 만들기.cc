#include <iostream>
#include <algorithm>
using namespace std;

string s, str;
string x, y;  // 홀 짝
int cnt[100];

int main() {
	cin >> s;
	for (char c : s) {
		cnt[c]++;
	}

	for (char i = 'A'; i <= 'Z'; i++) {
		if (cnt[i] % 2) 
			x += i;

		for (int j = 0; j < cnt[i] / 2; j++) 
			y += i;
	}
	if (x.size() > 1) 
		cout << "I'm Sorry Hansoo";
	else {
		cout << y << x;
		reverse(y.begin(), y.end());
		cout << y;
	}
}