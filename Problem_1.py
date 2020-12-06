"""
Time Complexity : O(1)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We make 3 global arrays for the strings that we need to insert and process over the word in triplets.
"""


class Solution:
    def numberToWords(self, num: int) -> str:
        if not num:
            return "Zero"
        triplets = ["", " Thousand", " Million", " Billion"]
        self.underTwenty = ["", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
                            " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"]
        self.tens = ["", " Ten", " Twenty", " Thirty", " Forty",
                     " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"]
        string = ""
        i = 0
        while num:
            remainder = num % 1000
            num //= 1000
            if remainder:
                words = self.convert(remainder, "")
                string = words + triplets[i] + string
            i += 1
        return string.strip()

    def convert(self, number, word):
        hundred = number//100
        remainder = number % 100
        if hundred:
            word += self.underTwenty[hundred]+" Hundred"
            return self.convert(remainder, word)
        elif number < 20:
            word += self.underTwenty[number]
        else:
            tens = number//10
            ones = number % 10
            word += self.tens[tens]+self.underTwenty[ones]
        return word
