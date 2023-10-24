def quicksort(arr)
    if arr.length <= 1
      return arr
    else
      pivot = arr.sample
      less = []
      equal = []
      greater = []
      
      arr.each do |element|
        if element < pivot
          less << element
        elsif element == pivot
          equal << element
        else
          greater << element
        end
      end
      
      return quicksort(less) + equal + quicksort(greater)
    end
  end
  
  # Example usage:
  arr = [12, 4, 5, 6, 7, 3, 1, 15, 14]
  sorted_arr = quicksort(arr)
  puts "Sorted Array: #{sorted_arr}"
  