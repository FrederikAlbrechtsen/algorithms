def counting_sort(arr)
    # Find the maximum and minimum values in the array
    max = arr.max
    min = arr.min
  
    # Create a counting array to store the count of each element
    count_array = Array.new(max - min + 1, 0)
  
    # Count the occurrences of each element
    arr.each { |num| count_array[num - min] += 1 }
  
    # Reconstruct the sorted array
    sorted_array = []
    count_array.each_with_index do |count, index|
      count.times { sorted_array << index + min }
    end
  
    return sorted_array
  end
  
  # Example usage:
  arr = [4, 2, 2, 8, 3, 3, 1]
  sorted_arr = counting_sort(arr)
  puts "Sorted Array: #{sorted_arr}"