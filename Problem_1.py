# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return 'Zero'
        self.words1to19 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        self.words10to90 = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        self.scales = ['', 'Thousand', 'Million', 'Billion']
        words = ''
        scaleIndex = 0
        while num > 0:
            if ((num % 1000) != 0):
                words = (self.convert(num % 1000) + self.scales[scaleIndex] + ' ' + words)
            num //= 1000
            scaleIndex += 1
        return words.strip()
    def convert(self, num):
        if num == 0:
            return ''
        elif num < 20:
            return (self.words1to19[num] + ' ')
        elif num < 100:
            return (self.words10to90[num // 10] + ' ' + self.convert(num % 10))
        else:
            return (self.words1to19[num // 100] + ' Hundred ' + self.convert(num % 100))