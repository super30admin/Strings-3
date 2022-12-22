class Solution:
    def numberToWords(self, num: int) -> str:
        
        ## T.C = O(1)
        ## S.C = O(1)
    
        if num == 0:
            return 'Zero'

        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["",  "Thousand", "Million", "Billion"]

        
        def helper(num):
            if num == 0:
                return ''
            tmp_str = ''
            if num <= 19:
                tmp_str += below_20[num] + " "
                return tmp_str
            elif num >= 20 and num<= 99:
                tmp_str += tens[num//10] + " "+  helper(num%10)
                return tmp_str
            elif num >= 100:
                tmp_str += below_20[num//100] + " Hundred " + helper(num%100)
                return tmp_str
        
        i = 0
        result = ''
        while num > 0:
            if num % 1000 != 0:
                result = helper(num % 1000) + thousands[i] + " " + result
            i += 1
            num = num // 1000
        
        print(result)
        return result.strip()