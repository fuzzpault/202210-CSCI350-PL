-- Paul Talaga
-- Oct 24, 2022
-- Example Haskell code from class

add :: Int -> Int -> Int
add a b = a + b

-- myrepeat :: String -> String
myrepeat :: [a] -> [a]
myrepeat a = a ++ a

counter :: Int -> [Int]
counter 0 = []
--counter n = n:(counter (n-1))
counter n = [n] ++ (counter (n-1))

counterBack :: Int -> [Int]
counterBack 0 = []
--counter n = n:(counter (n-1))
counterBack n = (counterBack (n-1)) ++ [n]

nesting :: Int -> [Int]
nesting 0 = [0]
--counter n = n:(counter (n-1))
nesting n = [n] ++ (nesting (n-1)) ++ [n]

makeLine :: Int -> String
makeLine 0 = ">"
makeLine n = "-" ++ (makeLine (n-1))

makeLine1 :: Int -> String
makeLine1 0 = ">"
makeLine1 n = "-" ++ (makeLine2 (n-1))

makeLine2 :: Int -> String
makeLine2 0 = ">"
makeLine2 n = "_" ++ (makeLine1 (n-1))

whatGrade :: Int -> String
whatGrade m | m < 95 && m > 90 = "A"
            | m < 80 = "C"
            | otherwise = "D"

mysum :: [Int] -> Int
mysum [] = 0
mysum (x:xs) = x + (mysum xs)

mylength :: [a] -> Int
mylength [] = 0
--mylength (x:xs) = 1 + (mylength xs)
mylength (_:xs) = 1 + (mylength xs)

addN :: [Int] -> Int -> [Int]
addN [] _ = []
addN (x:xs) a = (x + a):(addN xs a)

pretty :: [String] -> IO()
pretty x = putStrLn (prettyHelp x)

prettyHelp :: [String] -> String
prettyHelp [] = ""
prettyHelp (x:xs) = x ++ "\n" ++ prettyHelp xs

ms :: [Int] -> [Int] -> [Int]
ms [] [] = []
ms [] xs = xs
ms xs [] = xs
ms (x:xs) (y:ys) | x < y = [x] ++ (ms xs (y:ys))
            | otherwise = [y] ++ (ms (x:xs) (ys))