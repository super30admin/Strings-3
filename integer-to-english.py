# Time Complexity: O(n) depends on size of input, for given problem constraints - O(1) - max 9 calls to helper for 2^31-1
# Space Complexity: O(1) - excluding recursive stack space
# Approach: Divide and conquer. Split the number into triplets and process each triplet separately. Save english equivalent of numbers and use these for conversion to text while recursively processing triplets.
class Solution(object):
    def __init__(self):
        self.less_than_twenty = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        # Edge Case
        if num == 0:
            return "Zero"
        
        i = 0 # Keep track of triplets
        words = ''
        
        while num > 0:
            if num % 1000 != 0:
                words = self.helper(num % 1000) + self.thousands[i] + " " + words
            num /= 1000
            i += 1
        return words.strip()
    
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.less_than_twenty[num] + " "
        elif num < 100:
            return self.tens[num//10] + " " + self.helper(num % 10)
        else:
            return self.less_than_twenty[num//100] + " Hundred " + self.helper(num % 100)