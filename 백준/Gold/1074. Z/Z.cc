#include <iostream>
using namespace std;

int n, r, c;
int visit;

void z(int row, int col, int size) {
	if (row == r && col == c) {
		cout << visit << '\n';
		return;
	}

	if (r < row + size && r >= row && c < col + size && c >= col) {
		z(row, col, size / 2);  // 1
		z(row, col + size / 2, size / 2);  // 2
		z(row + size / 2, col, size / 2);  // 3
		z(row + size / 2, col + size / 2, size / 2);  //4
	}
	else {
		visit += size * size;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	cin >> n >> r >> c;
	z(0, 0, (1 << n));
	return 0;
}