# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I divide the number into triplets and find the hunred number to english recursively by referring various arrays. For each triplet I append the appropriate 
# word from tousands array and return the result

class Solution:
    def numberToWords(self, num: int) -> str:
        below_20s = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                    "Eighteen", "Nineteen"]
        
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        thousands = ["", "Thousand", "Million", "Billion"]
        
        def hundo_helper(hundo):
            if hundo == 0: return ""
            if hundo < 20:
                return below_20s[hundo] + " "
            elif hundo < 100:
                return tens[hundo//10] + " " + hundo_helper(hundo%10)
            else:
                return below_20s[hundo//100] + " Hundred " + hundo_helper(hundo%100)
        
        triplet = 0
        result = ""
        if num == 0: return "Zero"
        while num > 0:
            hundreds = num % 1000
            num = num // 1000
            triplet_result = hundo_helper(hundreds)
            if len(triplet_result) > 0:
                result = hundo_helper(hundreds) + thousands[triplet] + " " + result
            triplet += 1
            
        return result.strip()
        
