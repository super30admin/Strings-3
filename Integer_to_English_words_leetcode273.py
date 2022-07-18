class Solution:
    def numberToWords(self, num: int) -> str:
        # TC  = O(1) because num will have max length like 12-13 (billions) ie O(N = 12) so constant
        # SC = O(1)

        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        thousands = ["", "Thousand", "Million", "Billion"]

        def helper(num):
            if num == 0:
                return " "
            elif num < 20:
                return below_20[num] + " "

            elif num < 100:
                return tens[num // 10] + " " + helper(num % 10)

            else:
                return below_20[num // 100] + " " + "Hundred" + " " + helper(num % 100)

        if num == 0:
            return "Zero"
        result = ""
        i = 0
        while num > 0:
            curr = num % 1000
            if curr != 0:
                result = helper(curr) + thousands[i] + " " + result

            i += 1
            num = num // 1000

        return " ".join(result.split())


'''
def numberToWords(self, num):
    to19 = 'One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve ' \
           'Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
    tens = 'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()
    def words(n):
        if n < 20:
            return to19[n-1:n]
        if n < 100:
            return [tens[n/10-2]] + words(n%10)
        if n < 1000:
            return [to19[n/100-1]] + ['Hundred'] + words(n%100)
        for p, w in enumerate(('Thousand', 'Million', 'Billion'), 1):
            if n < 1000**(p+1):
                return words(n/1000**p) + [w] + words(n%1000**p)
    return ' '.join(words(num)) or 'Zero'
'''




    