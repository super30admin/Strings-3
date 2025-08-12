# Time Complexity: O(logn)
# Space Complexity: O(1)
class Solution:
    thousands = ['', ' Thousand ', ' Million ', ' Billion ']
    tens = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
    below_twenty = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven',
                    'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return 'Zero'
        i = 0
        result = []

        while num > 0:
            triplet = num % 1000
            if triplet > 0:
                result.insert(0, self.helper(triplet).strip() + self.thousands[i])
                print(result)
            num = num // 1000
            i += 1

        return ''.join(result).strip()

    def helper(self, num):
        result = []
        if num < 20:
            result.append(self.below_twenty[num])
        elif num < 100:
            result.append(self.tens[num // 10])
            result.append(" ")
            result.append(self.below_twenty[num % 10])

        else:
            result.append(self.below_twenty[num // 100])
            result.append(" Hundred ")
            result.append(self.helper(num % 100))

        return ''.join(result)
