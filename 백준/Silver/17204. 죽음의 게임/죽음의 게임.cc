#include <iostream>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	int *point = new int[n];
	for (int i = 0; i < n; i++) cin >> point[i];
	int cnt = 0, tmp = 0;
	while (1) {
		tmp = point[tmp];
		cnt++;
		if (tmp == m) break;
		else if (cnt > n) break;
	}
	if (tmp == m) cout << cnt << endl;
	else cout << -1 << endl;
}