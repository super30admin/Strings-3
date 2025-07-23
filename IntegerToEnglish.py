#TC: O(n)
#SC: O(1)
class Solution:
    def numberToWords(self, num: int) -> str:
        hierarchy = ["", "Thousand", "Million", "Billion", "Trillion"]
        lessthan20 = ["","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        greaterthan20 = ["","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        i = 0
        output = ""
        if num == 0:
            return "Zero"
        while(num):
            rem = num%1000
            result = ""
            while(rem):
                if rem>=100:
                    result=lessthan20[rem//100]+" Hundred"
                    rem = rem %100
                else:
                    if rem >=20:
                        result +=" "+greaterthan20[rem//10]
                        rem = rem%10
                    else:
                        result +=" "+lessthan20[rem]
                        rem = 0
            if (num%1000 > 0):
                output=result.strip() + " " + hierarchy[i]+" "+output
            i+=1
            num = num//1000
        return output.strip()
