#include <iostream>
#include <string.h>
using namespace std;

int main() {
	int n, m, a, b;
	cin >> n >> m;
	int **arr = new int *[n+1]; 
	for (int i = 1; i <= n+1; i++) {
		arr[i] = new int[n+1];
		memset(arr[i], 0, sizeof(int)*(n+1));
	}
	for (int i = 1; i <= m; i++) {
		cin >> a >> b;
		arr[a][b] = 1;
	}
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][k] == 1 && arr[k][j] == 1)
					arr[i][j] = 1;
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		int cnt = 0;
		for (int j = 1; j <= n; j++) {
			if (i != j) {
				if (!arr[i][j] && !arr[j][i]) 
					cnt++;
			}
		}
		cout << cnt << '\n';
	}
}