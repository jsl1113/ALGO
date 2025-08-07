#include <iostream>
using namespace std;

int main() {
	int a, b, c;
	int num = 1;
	cin >> a >> b >> c;
	if (c > b) 
		cout << (a / (c - b)) + 1 << endl;
	else 
		cout << -1 << endl;
}