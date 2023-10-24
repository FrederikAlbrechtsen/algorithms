def merge_sort(arr)
    if arr.length <= 1
      return arr
    end
  
    # Divide the array into two halves
    mid = arr.length / 2
    left_half = arr[0...mid]
    right_half = arr[mid..-1]
  
    # Recursively sort both halves
    left_sorted = merge_sort(left_half)
    right_sorted = merge_sort(right_half)
  
    # Merge the sorted halves
    merge(left_sorted, right_sorted)
  end
  
  def merge(left, right)
    result = []
    i, j = 0, 0
  
    while i < left.length && j < right.length
      if left[i] < right[j]
        result << left[i]
        i += 1
      else
        result << right[j]
        j += 1
      end
    end
  
    # Add any remaining elements from both halves
    result += left[i..-1]
    result += right[j..-1]
  
    result
  end
  
  # Example usage:
  arr = [12, 11, 13, 5, 6, 7]
  sorted_arr = merge_sort(arr)
  puts "Sorted Array: #{sorted_arr}"