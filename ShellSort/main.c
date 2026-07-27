#include <stdio.h>

void ShellSort(int* a, int n){
    int dk,i,j;
    for(dk=n/2; dk>=1; dk=dk/2){
        for(i=dk+1; i<=n; ++i){

        }
    }
};

int main(void) {
    printf("Hello, World!\n");

    int arr[] = {5,5,8,8,100,99,1,2,3};
    int* a = arr;
    int n = sizeof(arr) / sizeof(arr[0]);
    ShellSort(a,n);

    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
