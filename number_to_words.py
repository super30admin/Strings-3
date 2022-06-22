# Time Complexity : O(N) where N is numbers of digits in the number
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numberToWords(self, num: int) -> str:
        below_20 = ['Zero', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        tens = ['Zero', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety', 'Hundred']
        
        if num == 0: return "Zero"
        suffix = ['', 'Thousand', 'Million', 'Billion']
        result = []
        count = 0
        while num > 0:
            temp = []
            curr = num % 1000
            
            hundred = curr // 100
            if hundred > 0:
                temp.append(below_20[hundred])
                temp.append("Hundred")
            
            ten = curr % 100
            if ten < 20 and ten != 0:
                temp.append(below_20[ten])
                
            if ten >= 20 and ten != 0:
                temp.append(tens[ten//10])
                last = curr % 10
                if last > 0:
                    temp.append(below_20[last])
                    
            if count > 0 and len(temp):
                temp.append(suffix[count])
            count += 1
            result = temp + result 
            num = num // 1000
        return " ".join(result)