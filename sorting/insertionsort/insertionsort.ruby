def insertion_sort(arr)
    n = arr.length
  
    for i in 1..n-1
      key = arr[i]
      j = i - 1
  
      # Move elements of arr[0..i-1] that are greater than key
      # to one position ahead of their current position
      while j >= 0 && arr[j] > key
        arr[j + 1] = arr[j]
        j = j - 1
      end
      arr[j + 1] = key
    end
  end
  
  # Example usage:
  arr = [12, 11, 13, 5, 6]
  insertion_sort(arr)
  puts "Sorted Array: #{arr}"