#Time Complexity: O(n)
#Space complexity: O(n) , since we're copying res everytime (then deleted)

'''
Not really an algorithm question, rather a coding question. the only key is to 
divide by groups of 3 digits, and define a function to take care of these 3 digits
number.
'''

class Solution:
    def numberToWords(self, num: int) -> str:
        less_than_20=["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens=["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands=["","Thousand", "Million","Billion"]
        if num==0: return "Zero"
        def print_hundreds(h):
            if h==0: return ""
            if h<20: return less_than_20[h]+" "
            elif (h<100): return tens[h//10]+" "+print_hundreds(h%10) 
            else:  return less_than_20[h//100]+" Hundred "+print_hundreds(h%100)
        
        i,res=0,""
        while (num>0):
            if (num%1000!=0):
                res=print_hundreds(num%1000)+thousands[i]+" "+res
            i+=1
            num=num//1000
        return res.strip()
