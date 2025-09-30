#include <iostream>
using namespace std;

int main() {
	int deliver;
	int sum_5=0,sum_3 = 0;
	cin >> deliver;
	while (deliver>0) {
		if (deliver % 5 == 0) {
			deliver -= 5;
			sum_5++;
		}
		else if (deliver % 3 == 0) {
			deliver -= 3;
			sum_3++;
		}
		else if (deliver > 5) {
			deliver -= 5;
			sum_5++;
		}
		else {
			sum_5 = -1;
			sum_3 = -1;
			break;
		}
	}
	if ((sum_3 != -1) && (sum_5 != -1)) {
		cout << sum_5 + sum_3 << endl;
	}
	else cout << -1 << endl;
}
