#include<stdio.h>

int main(){
    int N, r, c, res = 0;
    
    scanf("%d", &N);
    scanf("%d", &r);
    scanf("%d", &c);
    
    while (N-- > 0){
        if (r >= (1 << N)) {
            r -= (1 << N);
            res += (1 << 2 * N + 1);
        }
        if (c >= (1 << N)) {
            c -= (1 << N);
            res += (1 << 2 * N);
        }
    }
    
    printf("%d\n", res);
}