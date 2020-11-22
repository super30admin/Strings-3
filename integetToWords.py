"""
Time : 0(N)
Space : 0(1) -> Constant sized dictionary
Leetcode: yes
Explanation : Followed Komal's solution
"""
class Solution:
    def numberToWords(self, num):
        if num == 0:
            return 'Zero'
        
        ddict = {1: 'One', 2: 'Two', 3: "Three", 4: 'Four', 5: 'Five', 6: 'Six', 7: 'Seven', 8: 'Eight', 9: 'Nine',
                 10: 'Ten', 11: 'Eleven', 12: 'Twelve', 13: 'Thirteen', 14: 'Fourteen', 15:'Fifteen', 16: 'Sixteen',
                 17: 'Seventeen', 18: 'Eighteen', 19: 'Nineteen', 20: 'Twenty', 30: 'Thirty', 40: 'Forty', 50: 'Fifty',
                 60: 'Sixty', 70: 'Seventy', 80: 'Eighty', 90: 'Ninety'}
        base = ['', 'Thousand', 'Million', 'Billion']
        result, exp = '', 1000
        i, chunk = 0, 0
        while num:
            chunk = num % exp
            if chunk:
                result = base[i] + ' ' + result
                one = chunk % 10
                two = (chunk % 100) - one
                three = chunk // 100
                if two == 10:
                    result = ddict[two+one] + ' ' + result
                else:
                    if one:
                        result = ddict[one] + ' ' + result
                    if two:
                        result = ddict[two] + ' ' +result
                if three:
                    result = ddict[three] + ' Hundred ' + result
            num //= exp
            i += 1
        return result.rstrip()
