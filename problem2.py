'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Create arrays for <20, 10's and thousands. If number is a billion then find the digits for billion
else if number is a million find digits for million and if number is a thousand then find digits for thousand.
Create a helper function which will give the values of the billion,million or trillion ie one two, eleven etc.
'''

class Solution(object):
    def __init__(self):
        self.below_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten',
                         'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen',
                         'Nineteen']
        self.tens = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        self.thousands = ['', 'Thousand', 'Million', 'Billion']

    def helper(self, num):
        if num == 0:
            return ''
        if num < 20:
            return self.below_20[num]
        if num < 100:  # 33
            # 30 + 3
            return self.tens[num / 10] + " " + self.below_20[num % 10]

        # 667
        # Six                              Hundred   call recursively sixty seven and get this part
        return self.below_20[num / 100] + " " + "Hundred" + " " + self.helper(num % 100)

    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        word = ''
        if num == 0:
            return "Zero"
        while num > 0:
            # / gives 1 and % gives 000
            if num / 1000000000 > 0:
                word = self.helper(num / 1000000000).strip() + " " + "Billion"

            num = num % 1000000000

            if num / 1000000 > 0:
                word = word + " " + self.helper(num / 1000000).strip() + " " + "Million"

            num = num % 1000000

            if num / 1000 > 0:
                word = word + " " + self.helper(num / 1000).strip() + " " + "Thousand"

            num = num % 1000

            word = word + " " + (self.helper(num).strip())

            return word.strip()
