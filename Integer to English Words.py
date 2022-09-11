# Time Complexity: No.of digits in num = O(12) which is constant time
# Space Complexity: Constant space for arrays storing below_20, tens and extensions

class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return "Zero"
        
        below_20 = ["", "One", "Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                    "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]
        
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"]
        
        extensions = ["", " Thousand", " Million", " Billion"]
        
        def helper(val):
            temp = []
            if val == 0:
                return ""
            elif val<20:
                temp.append(below_20[val])
                return "".join(temp).strip()
            elif val<100:
                temp.append(tens[val//10])
                temp.append(" ")
                temp.append(helper(val%10))
                return "".join(temp).strip()
            else:
                temp.append(below_20[val//100])
                temp.append(" Hundred ")
                temp.append(helper(val%100))
                return "".join(temp).strip()
            return 
        
        i = 0
        result = deque()
        while(num>0):
            
            helper_val = helper(num%1000)
            
            if helper_val: # Helper val should not be empty string
                result.appendleft(extensions[i])
                result.appendleft(helper_val)
                result.appendleft(" ")
            
            i += 1
            num = num//1000
        
        return "".join(result).strip()
            
            