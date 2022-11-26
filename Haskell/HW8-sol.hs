-- HW 8 Solution
-- Nov 2022
-- Paul Talaga


import HW8test

-- Setup
--data Node a = Null | N a (Node a) (Node a) deriving (Eq)

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

repeat2 :: Int -> a -> [a]
repeat2 0 _ = []
repeat2 n thing = thing:(repeat2 (n-1) thing)

prettyTreeHelp :: (Show a) => Node a -> Int -> String
prettyTreeHelp Null _ = ""
prettyTreeHelp (N v l r) n = (prettyTreeHelp r (n+4)) ++ (repeat2 n ' ') ++ (show v) ++ "\n" ++ (prettyTreeHelp l (n+4))


-------------------------------------------------------------------
-- 1
height:: Node a -> Int
height Null = -1
height (N _ l r) = (max (height l) (height r)) + 1

-- 2
numLeaves :: Node a -> Int
numLeaves Null = 0
numLeaves (N _ Null Null) = 1
numLeaves (N _ l r ) = (numLeaves l) + (numLeaves r)

-- 3
inOrder :: Node a -> [a]
inOrder Null = []
inOrder ( N value left right ) = inOrder( left ) ++ [value] ++ inOrder( right )

-- 4
prefix :: Node a -> [a]
prefix Null = []
prefix ( N value left right ) = [value] ++ prefix(left) ++ prefix(right)

-- 5
isBST :: (Ord a) => Node a -> Bool
isBST Null = True
isBST (N v Null Null) = True
isBST (N v (N l a b) Null) = l <= v && (isBST (N l a b))
isBST (N v Null (N r a b) ) = v <= r && (isBST (N r a b))
isBST (N v (N l la lb) (N r ra rb) ) = v <= r && l <= v && (isBST (N r ra rb)) && (isBST (N l la lb))

-- 6
isBalanced :: Node a -> Bool
isBalanced Null = True
isBalanced (N _ l r) = ((abs ((height l) - (height r))) <= 1) && (isBalanced l) && (isBalanced r)

-- 7
myRange :: [Int] -> Int
myRange v = foldr (\a b-> a + b ) 0 (map (rangeValid) v)  

rangeValid :: Int -> Int
rangeValid v | v > 90 && v < 100 = 1
             | otherwise = 0

-- 8
numPerfectSquares :: [Int] -> Int
numPerfectSquares x = foldl (+) 0 (map isPerfect x)

isPerfect :: Int -> Int
isPerfect x | (floor (sqrt (fromIntegral x))) ^ 2 == x = 1
            | otherwise = 0



heighttest = [T 0 (height (mytoTree [1])), 
              T 1 (height (mytoTree [1,2])),
              T 2 (height (mytoTree [1,2,3])),
              T 1 (height (mytoTree [1,3,2]))]

leaftest = [T 1 (numLeaves (mytoTree [1])), 
              T 1 (numLeaves (mytoTree [1,2])),
              T 1 (numLeaves (mytoTree [1,2,3])),
              T 2 (numLeaves (mytoTree [1,3,2])),
              T 2 (numLeaves (mytoTree [1,2,4,3]))]