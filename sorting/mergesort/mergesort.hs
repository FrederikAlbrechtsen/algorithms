mergeSort :: (Ord a) => [a] -> [a]
mergeSort [] = []
mergeSort [x] = [x]
mergeSort xs = merge (mergeSort left) (mergeSort right)
  where
    (left, right) = splitAt (length xs `div` 2) xs

merge :: (Ord a) => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
    | x <= y    = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys

main :: IO ()
main = do
    let unsortedList = [290, 32, 25, 18, 22, 11, 90]
    let sortedList = mergeSort unsortedList
    putStrLn "Unsorted List: "
    print unsortedList
    putStrLn "Sorted List: "
    print sortedList
