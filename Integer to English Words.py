# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    suffixes = ("", "Thousand ", "Million ", "Billion ", "Trillion ")
    tens = ("","Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety " )
    below_20s = ("", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
                "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
                "Eighteen ", "Nineteen ")
    def numberToWords(self, num: int) -> str:
        if num == 0: return "Zero"
        result = []
        i = 0
        while num > 0:
            curr = num % 1000
            if curr != 0: # handle 000 triplet
                result.insert(0, self.helper(curr) + self.suffixes[i])
            num = num // 1000
            i += 1
        
        return (''.join(result)).strip()

    def helper(self, curr):
        if curr == 0: return ""
        elif curr < 20: return self.below_20s[curr]
        elif curr >= 20 and curr < 100: return self.tens[curr//10] + self.helper(curr%10)
        elif curr >= 100: return self.below_20s[curr//100] + "Hundred " + self.helper(curr%100)