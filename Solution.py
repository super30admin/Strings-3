'''
// Time Complexity :
# Problem 1 - O(1) no. of digits are stored in boiler plate
# Problem 2 - O(n) 
// Space Complexity :
# Problem 1 - O(1)
# Problem 2 - O(n)
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :
# Problem 2 - Gives error for "14-3/2", please suggest

// Your code here along with comments explaining your approach
'''
## Problem 1 - Integer to English Words
# Initialize boiler plate arrays for below 20 numbers, tens number and higher order numbers
# Calculate the mod and using the reminder we determine the corresponding english word for the integer
# The helper function determines if the number is below 20 we get the english word from the list, if 
# the number is greater than 20 then we concatenate it with the Ten's or Thousand's list element.
# Return the string as a whole removing the "" from each word.

class Solution(object):
    below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"]
    tens = ["", "Ten","Twenty","Thirty", "Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    thousand = ["","Thousand","Million","Billion"]    
    
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "Zero"
        word = ""
        i = 0
        while num > 0:
            if num % 1000 != 0:
                word = self.helper(num % 1000) + self.thousand[i] + " " + word
            i += 1
            num = num // 1000
        return word.strip()
    
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below_20[num // 100] + " Hundred " + self.helper(num % 100)

## Problem 2 - Basic Calculator ||
# Parse the string and check whether the character is a digit or an operator
# If the character is a digit then calculate the ASCII value
# If the character is a operator - initialize the initial sign as '+' to push the first number in the 
# stack, if the operator is '+' push the value in the stack or if it is '-' then push a -ve value.
# The operators '*' and '/' take precedence of operations, perform the operation with the most recent
# element and current element and push the result into the stack.
# Sum all the elements from the stack and return the result

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        currNum = 0
        lastsign = '+'
        digits = '0123456789'
        operators = '+-*/'

        for i in range(len(s)):
            ch = s[i]
            
            # If it's a digit, we build the current number
            if ch in digits:
                currNum = currNum * 10 + int(ch)

            # If it's an operator or we are at the last character
            if ch in operators or i == len(s) - 1:
                if lastsign == '+':
                    stack.append(currNum)
                elif lastsign == '-':
                    stack.append(-currNum)
                elif lastsign == '*':
                    popped = stack.pop()
                    stack.append(popped * currNum)
                elif lastsign == '/':
                    popped = stack.pop()
                    stack.append(int(popped / currNum))
                
                # Reset the current number and update the last sign
                currNum = 0
                lastsign = ch

        # Sum up the values in the stack to get the final result
        result = 0
        while stack:
            result += stack.pop()
        
        return result