def radix_sort(arr)
    max_value = arr.max
    exp = 1
  
    while max_value / exp > 0
      counting_sort(arr, exp)
      exp *= 10
    end
  
    arr
  end
  
  def counting_sort(arr, exp)
    n = arr.length
    output = Array.new(n)
    count = Array.new(10, 0)
  
    # Count the occurrences of each digit
    arr.each { |num| count[(num / exp) % 10] += 1 }
  
    # Calculate the cumulative count
    (1..9).each { |i| count[i] += count[i - 1] }
  
    # Build the output array
    (n - 1).downto(0) do |i|
      digit = (arr[i] / exp) % 10
      output[count[digit] - 1] = arr[i]
      count[digit] -= 1
    end
  
    # Copy the sorted elements back to the original array
    (0...n).each { |i| arr[i] = output[i] }
  end
  
  # Example usage:
  arr = [170, 45, 75, 90, 802, 24, 2, 66]
  radix_sort(arr)
  puts "Sorted Array: #{arr}"
  