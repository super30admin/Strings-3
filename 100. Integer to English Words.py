class Solution:
    below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

    def numberToWords(self, num: int) -> str:
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        if num == 0:
            return "Zero"
        i = 0
        result = ""
        thousands = [" ", "Thousand ", "Million ", "Billion "]
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + thousands[i] + result
            num = num // 1000
            i += 1
        return print(result.strip())

    def helper(self, num):
        if num == 0:
            return ""
        if num < 20:
            # print(self.below_20[num])
            return self.below_20[num] + " "
        elif num < 100:
            # print(self.tens[num // 10],self.helper(num % 10))
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below_20[num // 100] + " Hundred " + self.helper(num % 100)

if __name__ == "__main__":
    obj = Solution()
    obj.numberToWords(77842536)
# Output :Seventy Seven Million Eight Hundred Forty Two Thousand Five Hundred Thirty Six
# Time Complexity = O(1)
# Space Complexity = O(1).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
