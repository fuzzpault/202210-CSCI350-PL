-- Paul Talaga
-- CSCI 355 Class Demo - Oct 24, 2022
--
-- Load this like: $ ghci demo.hs
-- Then do :r to reload demo.hs if you change it.
-- Or 



-- Send a picture to pretty and it will print it out with new lines.
pretty :: [String] -> IO ()
pretty x = putStrLn (prettyHelp x)

prettyHelp :: [String] -> String
prettyHelp [] = ""
prettyHelp (x:xs) = x ++ "\n" ++ prettyHelp xs