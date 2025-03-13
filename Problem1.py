# Problem 1 : Integer to English Words
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class Solution:
    def numberToWords(self, num: int) -> str:
        # defining the below_20, tens, thousand arrays
        # these arrays contains data for unique numbers in words
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousand = ["", "Thousand", "Million", "Billion"]

        # helper function for converting grou of 3 number in original number to word
        def helper(num: int) -> str:
            # if the num is 0 then return ""
            if num == 0:
                return ""
            # if the num is less than 20 then get the value from below_20 array
            elif num < 20:
                return below_20[num] + " "
            # if the number is less than 100
            elif num < 100:
                # return get the value of number in tens place in tens array +  space + call helper for the rest of the number
                return tens[num // 10] + " " + helper(num % 10)
            # else ie number greater than 100
            else:
                # return get the value of number in hundred place in below_20 array +  word hundred + call helper for the rest of the number
                return below_20[num // 100] + " Hundred " + helper(num % 100)

        # define the variable which will store the number in word
        word = ""
        # pointer for thousands array
        i = 0
        # if the number is 0 then return word is zero
        if num == 0:
            return "Zero"
        # loop until number is greater than 0
        while num > 0:
            # check if the group of 3 numbers in original number is not zero if it is zero then avoid it
            if (num % 1000 != 0):
                # call helper function for group of 3 numbers in original number + word from thousand array at ith pointer + previous word
                word = helper(num % 1000) + thousand[i] + " " + word
            # increment i value
            i += 1
            # get the remaining number from the original number
            num = num // 1000
        # return the word after triming the leading and trailing space
        return word.strip()

        