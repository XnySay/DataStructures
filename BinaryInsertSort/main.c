#include <stdio.h>



void InsertSort (int* a, int n) {
    int low, high, mid, i, j;

    for (i=1;i<n;i++) {
        low=0;high=i-1;
        while(low<=high) {
            mid = (low + high)/2;
            if(a[mid]>a[i])
                high = mid - 1;
            else
                low = mid + 1;
        }

        int temp =a[i];
        for(j=i-1;j>=high+1;j--){

            a[j+1] = a[j];

        }
        a[high+1] = temp;


    }


}


int main(void) {


    int arr[] = {5,5,8,8,100,99,1,2,3};
    int* a = arr;
    int n = sizeof(arr) / sizeof(arr[0]);
    InsertSort(a,n);

    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
