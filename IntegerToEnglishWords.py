'''
    Time Complexity:
        O(1) ('cause we know that the given number is going to be at most 10 digits long)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Patience Test
'''

BELOW_TEN = [
    '', 'One', 'Two', 'Three', 'Four',
    'Five', 'Six', 'Seven', 'Eight', 'Nine'
]

BELOW_TWENTY = [
    'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
    'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'
]

BELOW_HUNDRED = [
    '', 'Ten', 'Twenty', 'Thirty', 'Forty',
    'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety'
]

ZERO = 'Zero'
HUNDRED = 'Hundred'
THOUSAND = 'Thousand'
MN = 'Million'
BN = 'Billion'

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return ZERO

        return self.build_number(num)

    def build_number(self, num):
        words = []

        if num < 10:
            words.append(BELOW_TEN[num])

        elif num < 20:
            words.append(BELOW_TWENTY[num - 10])

        elif num < 100:
            words.append(BELOW_HUNDRED[num // 10])
            words.append(self.build_number(num % 10))

        elif num < 1_000:
            words.append(self.build_number(num // 100))
            words.append(HUNDRED)
            words.append(self.build_number(num % 100))

        elif num < 1_000_000:
            words.append(self.build_number(num // 1_000))
            words.append(THOUSAND)
            words.append(self.build_number(num % 1_000))

        elif num < 1_000_000_000:
            words.append(self.build_number(num // 1_000_000))
            words.append(MN)
            words.append(self.build_number(num % 1_000_000))

        else:
            words.append(self.build_number(num // 1_000_000_000))
            words.append(BN)
            words.append(self.build_number(num % 1_000_000_000))

        return ' '.join(words).strip()
