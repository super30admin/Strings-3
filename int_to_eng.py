# Time Complexity : O(1)
# Space Complexity : O(1)

class Solution:
    def numberToWords(self, num: int) -> str:
        def calculate(number):
            if number == 0:
                return ""
            elif number < 20:
                return pairs[number] + ' '
            elif number < 100:
                return pairs[(number//10)*10] + ' ' + calculate(number % 10)
            else:
                return pairs[(number//100)] + " Hundred " + calculate(number % 100)
#             if number == 0: return ''
#             curr = 100
#             res = ''
#             while number:
#                 numb = number//curr
#                 if numb:
#                     if curr == 100:
#                         res += pairs[numb] + ' ' + pairs[curr] + ' '
#                     elif curr == 10:
#                         if numb > 9 and numb < 20: res += pairs[numb] + ' '
#                         else: res += pairs[curr*numb] + ' '
#                     else: res += pairs[numb] + ' '

#                 number = number%curr
#                 curr = curr//10
#                 if number > 9 and number < 20: numb, curr = number, 1
#             return res + suffix[idx]

        pairs = {0: "", 1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five", 6: "Six", 7: "Seven", 8: "Eight", 9: "Nine", 10: "Ten", 11: "Eleven", 12: "Twelve", 13: "Thirteen", 14: "Fourteen", 15: "Fifteen",
                 16: "Sixteen", 17: "Seventeen", 18: "Eighteen", 19: "Nineteen", 20: "Twenty", 30: "Thirty", 40: "Forty", 50: "Fifty", 60: "Sixty", 70: "Seventy", 80: "Eighty", 90: "Ninety", 100: "Hundred"}
        suffix = ["", "Thousand", "Million", "Billion", "Trillion"]
        idx = 0
        res = ""
        if num == 0:
            return "Zero"
        while num:
            val = calculate(num % 1000)
            res = (val + suffix[idx] + ' ' + res) if val else res

            num = num//1000
            idx += 1

        return res.strip()
