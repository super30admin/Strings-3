'''
Time Complexity: O(1)
Space Complexity: O(1)
'''
class Solution:
    def numberToWords(self, num: int) -> str:
        if(num==0): return "Zero"
        denomination = ["", "Thousand", "Million", "Billion"]
        below_20 = ["", "One","Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                    "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens_arr = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
                    "Seventy", "Eighty", "Ninety"]
        def helper(val):
            if(val<20):
                return below_20[val]
            elif(val<100):
                return tens_arr[val//10] + " "+below_20[val%10]
            else:
                return below_20[val//100]+ " Hundred "+ helper(val%100) 
            
        i = 0
        result = ""
        while(num>0):
            if(num%1000>0):
                result = helper(num%1000).strip() + " " + denomination[i]+ " "+result+" "
            num = num//1000
            i += 1
        return result.strip()
        
 
            
            
        