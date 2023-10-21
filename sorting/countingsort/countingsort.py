def counting_sort(arr, k):
    n = len(arr)
    B = [0] * n
    C = [0] * (k + 1)

    for i in range(n):
        C[arr[i]] += 1

    for i in range(1, k + 1):
        C[i] += C[i - 1]

    for i in range(n - 1, -1, -1):
        B[C[arr[i]] - 1] = arr[i]
        C[arr[i]] -= 1

    return B

if __name__ == "__main__":
    arr = [4, 7, 8, 1, 25]
    k = max(arr)
    sorted_arr = counting_sort(arr, k)

    print(", ".join(map(str, sorted_arr)))