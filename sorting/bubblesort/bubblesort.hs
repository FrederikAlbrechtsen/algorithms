bubbleSort :: (Ord a) => [a] -> [a]
bubbleSort list = bubbleSort' list (length list)

bubbleSort' :: (Ord a) => [a] -> Int -> [a]
bubbleSort' list 0 = list
bubbleSort' list n = bubbleSort' (onePass list) (n - 1)

onePass :: (Ord a) => [a] -> [a]
onePass [x] = [x]
onePass (x:y:rest)
    | x > y     = y : onePass (x : rest)
    | otherwise = x : onePass (y : rest)

main :: IO ()
main = do
    let unsorted = [290, 32, 25, 18, 22, 11, 90]
    let sorted = bubbleSort unsorted
    putStrLn "Unsorted: "
    print unsorted
    putStrLn "Sorted: "
    print sorted