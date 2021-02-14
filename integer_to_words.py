# -*- coding: utf-8 -*-
"""
TC :O(1) constant time as biggest triplet can be processed in 4 steps only
SC :O(1) as no extra space used
"""

class Solution:
    def numberToWords(self, num: int):
        under_twenty = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten',
                        'Eleven','Twelve','Thirteen','Fourteen','Fiveteen','Sixteen','Seventeen',
                        'Eighteen','Nineteen']
        tens = ['','','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        chunks = ['Thousand','Million','Billion']
        
        # above thousand, process in chunks of three. 

        # Under thousand
        # 1.under twenty
        # 2.tens + under twenty(case1)
        # 3.digit + hundred + case2 
        def to_words(num):
            if num == 0: return []
            if num < 20 : return [under_twenty[num]]
            if num < 100: return [tens[num // 10]] + to_words(num % 10)
            if num < 1000: 
                quotient = num // 100
                remainder = num % 100
                return [under_twenty[quotient],'Hundred'] + to_words(remainder)
            for power, chunk in enumerate(chunks, 1):
                if num < 1000 ** (power + 1):
                    quotient = num //1000 ** power
                    remainder = num % 1000 ** power
                    return to_words(quotient) + [chunk] + to_words(remainder)
        return ' '.join(to_words(num)) or 'Zero'
    

S = Solution()
print(S.numberToWords(100))                   