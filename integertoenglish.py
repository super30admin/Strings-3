#// Time Complexity : O(1) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.
class Solution:
    def numberToWords(self, num: int) -> str:
        below_twenty = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" , "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]

        if num == 0:
            return 'Zero'
        
        def helper(nums): 
            if nums < 20:
                return below_twenty[nums]
            elif nums < 100:
                return tens[nums//10] + " " + helper(nums%10)
            else:
                return below_twenty[nums//100] + " Hundred " + helper(nums%100)

        i = 0
        result = ''
        while num > 0:
            triplet = num % 1000
            print(triplet,num)
    
            if triplet != 0:
                result = helper(triplet).strip() + " " + thousands[i] + " " + result
            num = num // 1000
            i += 1

        return result.strip()

# Approach:
# The problem can be solved by breaking down the number into groups of three digits (thousands, millions
# and billions) and then converting each group into words. We can use a helper function to convert each
# group into words. The helper function can use another helper function to convert numbers less than 20 into
# words.



        