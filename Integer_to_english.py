#Time:O(n)
#space:O(1) output list not considered
class Solution:
    def numberToWords(self, num: int) -> str:
        dict_val = {1:"One",2:"Two",3:"Three",4:"Four",5:"Five",6:"Six",
         7:"Seven",8:"Eight",9:"Nine",10:"Ten",11:"Eleven",12:"Twelve",
         13:"Thirteen",14:"Fourteen",15:"Fifteen",16:"Sixteen",
         17:"Seventeen",18:"Eighteen",19:"Nineteen",
         20:"Twenty",30:"Thirty",40:"Forty",50:"Fifty",
         60:"Sixty",70:"Seventy",80:"Eighty",90:"Ninety"}
        dict_val_powers = ["Thousand","Million","Billion"]
        
        def helper(num):
            hundred_val = (num//100)
            ten_val = 0
            one_val = 0
            if 10<=num%100<21:
                ten_val=num%100
            else:
                ten_val = ((num%100)//10)*10
                one_val =  (num%10)
            hundred_string = ""
            ten_string = ""
            one_string = ""
            if hundred_val in dict_val:
                hundred_string = dict_val[hundred_val] + " Hundred"
            if ten_val in dict_val:
                ten_string=dict_val[ten_val]
            if one_val in dict_val:
                one_string=dict_val[one_val]
            final_string=""
            if hundred_string:
                final_string+=hundred_string 
            if ten_string:
                final_string+= " " + ten_string
            if one_string:
                final_string+= " " + one_string
                
            return final_string.strip()
        if num == 0:
            return "Zero"
        billion = num // 1000000000
        million = (num - billion * 1000000000) // 1000000
        thousand = (num - billion * 1000000000 - million * 1000000) // 1000
        rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000
        result = ''
        if billion:        
            result = helper(billion) + ' Billion'
        if million:
            result += ' ' if result else ''    
            result += helper(million) + ' Million'
        if thousand:
            result += ' ' if result else ''
            result += helper(thousand) + ' Thousand'
        if rest:
            result += ' ' if result else ''
            result += helper(rest)
        return result
        
        