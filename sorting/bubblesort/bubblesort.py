def bubble_sort(arr):
    def one_pass(arr):
        for i in range(len(arr) - 1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
        return arr

    n = len(arr)
    while n > 0:
        arr = one_pass(arr)
        n -= 1
    return arr

unsorted_arr = [290, 32, 25, 18, 22, 11, 90]
sorted_arr = bubble_sort(unsorted_arr)

print("Unsorted_arr:")
print(unsorted_arr)
print("Sorted:")
print(sorted_arr)