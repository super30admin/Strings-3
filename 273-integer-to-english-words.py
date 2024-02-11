
"""
273. Integer to English Words
Hard
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Convert a non-negative integer num to its English words representation.
 
Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 
Constraints:

0 <= num <= 231 - 1


"""

class Solution:
    """
    Accepted
    Time Complexity: O(len(str(num))) -> O(1) ->
        Because the input is a 32 bit integer, the maximum number of digits is 10
        The number of digits is a constant and the number of iterations is constant
        Hence, the time complexity is O(1)
    Space Complexity: O(1)
        The words are constant and the space complexity is O(1)
    
    Approach: The intuition is to break down into subproblems. -> 1,000,000,000 -> we now that first 3 digits are "One Billion" and the rest is "Million" and so on
    - We can break the number into triplets and solve the subproblem of converting the triplet into words
    - Now, we need to handle 0-999 and convert it into words.
    - We identify the common keywords and lgoically separate the problem into subproblems and solve them recursively
    - hash ones, tens teens - build the words for the triplet and append the suffixes
    - In this case we really need 4 suffixes based on the input
    """
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        ones = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        teens = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        suffixes = ["", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion", "Sextillion", "Septillion", "Octillion", "Nonillion", "Decillion"]
        
        def helper(num):
            if num == 0:
                return ""
            elif num <10:
                return ones[num]
            elif num <20:
                return teens[num%10]
            elif num < 100:
                return tens[num//10] + " " + helper(num % 10).strip()
            elif num < 1000:
                return ones[num // 100] + " Hundred " + helper(num % 100).strip()
        i = 0
        res = []
        while num >0:
            triplet = num % 1000
            if triplet != 0: 
                temp = helper(triplet).strip()
                res.append((temp + " " + suffixes[i]).strip())
            i += 1
            num = num // 1000
        return " ".join(res[::-1])

LeetCode(PROBLEM, Solution).check()
