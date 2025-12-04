#include <iostream>
using namespace std;

int main() {
	int n;
	int finger;
	cin >> n;
	if (n % 8 == 1) finger = 1;
	else if (n % 8 == 0 || n % 8 == 2) finger = 2;
	else if (n % 8 == 3 || n % 8 == 7) finger = 3;
	else if (n % 8 == 4 || n % 8 == 6) finger = 4;
	else finger = 5;
	cout << finger << endl;
}