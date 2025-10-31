# Time Complexity : O(1) as the number is capped at 2^31 - 1
# Space Complexity : O(N) as we are using extra space to store the words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am thinking this as a recursive approach. I will break the number into chunks of thousands and convert each chunk into words.
# I will use helper function to convert each chunk of three digits into words.
# I will maintain lists for below 20 numbers, tens and scales (thousand, million, billion).
# I will iterate through the number, extracting three digit chunks and converting them to words using the helper function.
# Finally, I will combine the words for each chunk with the appropriate scale and return the final result.

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        below20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens = ["","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        scales = ["","Thousand","Million","Billion"]
        
        def three_digit_words(n):
            parts = []
            if n >= 100:
                parts.append(below20[n//100])
                parts.append("Hundred")
                n %= 100
            if n >=20:
                parts.append(tens[n//10])
                if n % 10 != 0:
                    parts.append(below20[n % 10])
            elif n > 0:
                parts.append(below20[n])
            return " ".join([p for p in parts if p])

        words = []
        scale_idx = 0
        while num >0:
            block = num % 1000
            if block != 0:
                chunk_words = three_digit_words(block)
                if scales[scale_idx]:
                    words.append(scales[scale_idx])
                words.append(chunk_words)
            num //= 1000
            scale_idx += 1
        return " ".join(reversed(words))