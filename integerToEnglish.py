# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# The solution uses a lookup aide for every distinct word required to form the sentence. There
# can only be 4 triplets of numbers at most, every triplet with it's unique suffix. The solutions
# breaks down the number into triplets and further into digits to use the lookup and suffix aide
class Solution(object):
    def __init__(self):
        # 1 - 19
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                        "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        # 10, 20, 30 ....90
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        # Keyword array
        self.thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num):
        if num == 0: return "Zero"
        # can also be done using [] and "".join() to return!
        retVal = ""
        keyWord = 0
        # Breaking down into triplets
        while num > 0:
            if num % 1000 != 0:
                retVal = self.helper(num % 1000) + self.thousands[keyWord] + " " + retVal
            keyWord += 1
            num = num / 1000

        # removing trailing white space
        return retVal.rstrip()

    def helper(self, num):
        # Different actions for different number ranges
        if num == 0: return ""
        elif num < 20: return self.below20[num] + " "
        elif num < 100: return self.tens[num / 10] + " " + self.helper(num % 10)
        else: return self.below20[num / 100] + " Hundred " + self.helper(num % 100)
