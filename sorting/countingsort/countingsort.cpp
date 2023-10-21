#include <iostream>

void CountingSort(int arr[], int B[], int n, int k) {
    int C[k + 1] = {0};

    for (int i = 0; i < n; i++) {
        C[arr[i]]++;
    }

    for (int i = 1; i <= k; i++) {
        C[i] += C[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        B[C[arr[i]] - 1] = arr[i];
        C[arr[i]]--;
    }
}

int main() {
    int arr[] = {4, 7, 8, 1, 25};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 25;
    int B[n];

    CountingSort(arr, B, n, k);

    for (int i = 0; i < n; ++i) {
        std::cout << B[i];
        if (i < n - 1) {
            std::cout << ", ";
        }
    }

    std::cout << std::endl;

    return 0;
}