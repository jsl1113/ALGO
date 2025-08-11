#include<stdio.h>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;
#include<queue>
int a[20001];
int main(){
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; scanf("%d", a + i++));
    sort(a, a + n);
    printf("%d", a[(n-1)>>1]);
}