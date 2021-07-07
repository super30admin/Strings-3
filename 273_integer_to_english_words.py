class Solution:
    def numberToWords(self, num: int) -> str:
        """

        """
        self.LESS_THAN_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten',
                             'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen',
                             'Nineteen']
        self.TENS = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

        if num == 0:
            return 'Zero'
        return self._helper(num)

    def _helper(self, num):
        result = ''
        if num < 20:
            result = self.LESS_THAN_20[num]
        elif num < 100:
            result = f'{self.TENS[num // 10]} {self._helper(num % 10)}'
        elif num < 1_000:
            result = f'{self._helper(num // 100)} Hundred {self._helper(num % 100)}'
        elif num < 1_000_000:
            result = f'{self._helper(num // 1_000)} Thousand {self._helper(num % 1_000)}'
        elif num < 1_000_000_000:
            result = f'{self._helper(num // 1_000_000)} Million {self._helper(num % 1_000_000)}'
        else:
            result = f'{self._helper(num // 1_000_000_000)} Billion {self._helper(num % 1_000_000_000)}'
        return result.strip()


if __name__ == '__main__':
    print(Solution().numberToWords(12345))
