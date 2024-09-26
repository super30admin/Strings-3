// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we make a array for numbers less than 20 and multiples of tens and place it in arrays.Then we divide the number by billion,million,thousand to see the length of the number.For instance if it is a billion first we divide it with billion then million then thousand.for every divide based on the number we check in their respective arrays and then we concatenate our result.

# Time complexity --> o(n) n is the number of values present in input
# space compexity --> o(1)
class Solution(object):
    def __init__(self):
        self.less_20=["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens=["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    def helper(self,num):
        if num==0:
            return ''
        if num<20:
            return self.less_20[num]
        if num<100:
            return self.tens[num/10]+" "+self.less_20[num%10]
        return self.less_20[num/100]+" "+"Hundred"+" "+self.helper(num%100)
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num==0:
            return "Zero"
        result=''
        if (num/10**9)>0:
            result=(self.helper(num/10**9)).strip()+" "+"Billion"
        num=num%10**9
        if (num/10**6)>0:
            result=result+" "+(self.helper(num/10**6)).strip()+" "+"Million"
        num=num%10**6
        if (num/10**3)>0:
            result=result+" "+(self.helper(num/10**3)).strip()+" "+"Thousand"
        num=num%10**3
        result=result+" "+self.helper(num)
        return result.strip()
        
        
        
        
                
            
        