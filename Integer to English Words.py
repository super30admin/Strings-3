class Solution:
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    global thousands, U20, tens
    thousands = ['', 'Thousand', 'Million', 'Billion']
    U20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve',
           'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']

    tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

    def helper(self, num):
        if num < 20:
            return U20[num]
        elif num < 100:
            return tens[num // 10] + ' ' + self.helper(num % 10)
        else:
            return U20[num // 100] + ' Hundred ' + self.helper(num % 100)

    def numberToWords(self, num: int) -> str:

        if num == 0: return 'Zero'
        result = ''
        i = 0  # Pointer for suffix name (Thousand, million, or billion)

        while num > 0:  # 123456
            triplet = num % 1000  # 456
            if (triplet) != 0:
                result = self.helper(triplet).strip() + ' ' + thousands[i] + ' ' + result
            num = num // 1000  # 123
            i += 1

        return result.strip()