# Integer to English Words

# Time Complexity : O(N) where N is number of digits in a number/input  
# Space Complexity : O(1) as output is String
# Did this code successfully run on Leetcode : Yes, with Runtime: 24 ms and Memory Usage: 14.5 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : 
"""
Number/Input is divided into triplets and than put the triplets under 4 cases 
set as if number/input =0, number/input < 20, number/input < 100 and > 100. The
cases are addressed by suing an array of strinigs representing numbers i.e below20,
tens, thousnads. Using % operator for dividing and conquering single digits and triplets.

"""
class Solution:
    def numberToWords(self, num: int) -> str:
        below20=[" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen",
"Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens=[" ","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousands=[" ","Thousand","Million","Billion"]
        
        def helper(num): # Single Digits-4 Cases
            if num == 0: return ''
            elif num < 20: return below20[num] + ' '
            elif num < 100: return tens[num // 10] + ' ' + helper(num % 10)
            return below20[num // 100] + ' Hundred ' + helper(num % 100)
        if(num==0):  # Base Case
            return 'Zero'
        result=' '
        i=0
        while(num):
            if(num%1000):
                result=helper(num%1000)+thousands[i]+' '+result
            i=i+1
            num=num//1000    
        return result.strip()