# Time complexity = O(N)
# Space complexity = O(1)
class Solution:
    below_20 = ['', 'One ', 'Two ', 'Three ', 'Four ', 'Five ', 'Six ', 'Seven ', 'Eight ', 'Nine ', 'Ten ', 'Eleven ', 'Twelve ', 'Thirteen ', 'Fourteen ', 'Fifteen ', 'Sixteen ', 'Seventeen ', 'Eighteen ', 'Nineteen ']
    tens = ['', '', 'Twenty ', 'Thirty ', 'Forty ', 'Fifty ', 'Sixty ', 'Seventy ', 'Eighty ', 'Ninety ']
    thousands = ['', 'Thousand ', 'Million ', 'Billion ']

    def numberToWords(self, num: int) -> str:
        result = ''
        i = 0
        if num == 0:
            return 'Zero'
        while num > 0:
            triplet = num % 1000  # Extract the last three digits of the number
            if triplet != 0:
                result = self.helper(triplet) + self.thousands[i] + result  # Convert the triplet and append it to the result
            i += 1
            num = num // 1000  # Remove the last three digits from the number
        return result.strip()  # Remove leading and trailing whitespace

    def helper(self, num):
        if num < 20:
            return self.below_20[num]  # Convert numbers below 20 directly to words
        elif num < 100:
            return self.tens[num // 10] + self.below_20[num % 10]  # Convert numbers between 20 and 99 to words
        else:
            return self.below_20[num // 100] + "Hundred " + self.helper(num % 100)  # Convert numbers greater than 99 to words

