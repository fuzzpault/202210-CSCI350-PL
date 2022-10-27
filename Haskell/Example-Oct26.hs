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

merge :: (Ord a) => [a] -> [a] -> [a]
merge [] [] = []
merge [] xs = xs
merge xs [] = xs
merge (x:xs) (y:ys) | x < y = [x] ++ (merge xs (y:ys))
            | otherwise = [y] ++ (merge (x:xs) (ys))

mergesort :: (Ord a) => [a] -> [a]
mergesort [] = []
mergesort (x:xs) = merge [x] (mergesort xs)

-----------------------------
makeLine3 :: Int -> String -> String -> String
makeLine3 0 s1 s2 = s2
makeLine3 n s1 s2 = s1 ++ (makeLine3 (n-1) s1 s2)

makeLine4 :: Int -> String
makeLine4 n = makeLine3 n "-" ">"

repeat2 :: Int -> a -> [a]
repeat2 0 _ = []
repeat2 n thing = thing:(repeat2 (n-1) thing)

--------------
data Node a = Null | N a (Node a) (Node a) deriving (Eq)

numNodes :: Node a -> Int 
numNodes Null = 0
numNodes (N _ left right) = (numNodes left) + (numNodes right) + 1

addValue :: (Ord a) => a -> Node a -> Node a
addValue v Null = N v Null Null
addValue v (N v2 left right) | v < v2 = (N v2 (addValue v left) right) 
                             | otherwise = (N v2 left (addValue v right))

toTree :: (Ord a) => [a] -> Node a
toTree [] = Null
toTree (x:xs) = addValue x (toTree xs)

prettyTree :: (Show a) => Node a -> IO()
prettyTree a = putStrLn (prettyTreeHelp a 0)

prettyTreeHelp :: (Show a) => Node a -> Int -> String
prettyTreeHelp Null _ = ""
prettyTreeHelp (N v l r) n = (prettyTreeHelp r (n+4)) ++ (repeat2 n ' ') ++ (show v) ++ "\n" ++ (prettyTreeHelp l (n+4))

instance Show (Node a) where
  show (N a b c) = prettyTree (N a b c)

