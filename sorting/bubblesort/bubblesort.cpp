#include <iostream>
#include <vector>

std::vector<int> bubble_sort(std::vector<int> arr) {
    auto one_pass = [](std::vector<int> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                std::swap(arr[i], arr[i + 1]);
            }
        }
        return arr;
    };

    int n = arr.size();
    while (n > 0) {
        arr = one_pass(arr);
        n--;
    }
    return arr;
}

int main() {
    std::vector<int> unsorted_arr = {290, 32, 25, 18, 22, 11, 90};
    std::vector<int> sorted_arr = bubble_sort(unsorted_arr);

    std::cout << "Unsorted_arr:" << std::endl;
    for (int num : unsorted_arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    std::cout << "Sorted:" << std::endl;
    for (int num : sorted_arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}