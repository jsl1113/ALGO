#include <stdio.h>
int main(void) {
	int x;
	int sum = 0;
	scanf("%d", &x);
	x = 1000 - x;
	while (x!=0) {
		while (x >= 500) {
				sum += 1;
				x = x - 500;
			}
			while (x >= 100) {
				sum += 1;
				x = x - 100;
			}
			while (x >= 50) {
				sum += 1;
				x = x - 50;
			}
			while (x >= 10) {
				sum += 1;
				x = x - 10;
			}
			while (x >= 5) {
				sum += 1;
				x = x - 5;
			}
			while (x >= 1) {
				sum += 1;
				x = x - 1;
			}
	}
	printf("%d", sum);
}