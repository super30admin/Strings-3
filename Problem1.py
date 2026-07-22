## Problem1 
#  Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
class Solution:
    def numberToWords(self, num: int) -> str:
        # TIME COMPLEXITY: O(1)
        # The maximum possible value for a 32-bit signed integer is 2,147,483,647 (10 digits).
        # Because the input size is strictly bounded, the while loop runs at most 4 times 
        # (for ones, thousands, millions, and billions). The helper function also performs 
        # a constant number of operations. Therefore, the time complexity is O(1).
        
        # SPACE COMPLEXITY: O(1)
        # The space used by the lookup arrays (siffix, tens, below20) is constant.
        # The recursion stack for the `helper` function is extremely shallow (maximum depth of 3).
        # The length of the resulting string is also bounded. Thus, it requires O(1) extra space.

        # Lookup tables for mapping numbers to their English word equivalents
        siffix = ['', 'Thousand', 'Million', 'Billion']
        tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        below20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']

        # LOGIC: Helper function to convert any number strictly less than 1000 into words.
        def helper(num):
            if num < 20:
                # Base case: Directly fetch words for numbers 1-19
                return below20[num]
            elif num < 100:
                # For 20-99: Fetch the tens word and recursively get the ones digit
                return tens[num // 10] + " " + helper(num % 10)
            else:
                # For 100-999: Fetch the hundreds word and recursively process the remaining two digits
                return below20[num // 100] + " Hundred " + helper(num % 100)

        # Handle the edge case where the input itself is zero
        if num == 0:
            return 'Zero'

        result = ''
        idx = 0

        # LOGIC: Process the number in chunks of 3 digits (triplets) from right to left.
        # E.g., for 1,234,567, it processes 567 first, then 234, then 1.
        while num > 0:
            triplet = num % 1000
            
            # If the current 3-digit chunk is not 000, convert it to words, 
            # attach the appropriate suffix scale (Thousand, Million, etc.), 
            # and prepend it to the front of our ongoing result string.
            if triplet != 0:
                result = helper(triplet).strip() + " " + siffix[idx] + " " + result
            
            # Increment index to step up to the next suffix scale (e.g., from Thousand to Million)
            idx += 1
            # Shift the number to the right by 3 decimal places to process the next triplet
            num = num // 1000

        # Strip any extraneous trailing or leading spaces left over from concatenation
        return result.strip()