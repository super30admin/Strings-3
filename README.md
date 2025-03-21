# Strings-3

## Problem1 
 Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
 
# Initialize boiler plate arrays for below 20 numbers, tens number and higher order numbers
# Calculate the mod and using the reminder we determine the corresponding english word for the integer
# The helper function determines if the number is below 20 we get the english word from the list, if 
# the number is greater than 20 then we concatenate it with the Ten's or Thousand's list element.
# Return the string as a whole removing the "" from each word.

## Problem2 

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

# Parse the string and check whether the character is a digit or an operator
# If the character is a digit then calculate the ASCII value
# If the character is a operator - initialize the initial sign as '+' to push the first number in the 
# stack, if the operator is '+' push the value in the stack or if it is '-' then push a -ve value.
# The operators '*' and '/' take precedence of operations, perform the operation with the most recent
# element and current element and push the result into the stack.
# Sum all the elements from the stack and return the result

