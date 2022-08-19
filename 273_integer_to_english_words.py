'''
## Problem 273: Integer to english words

## Author: Neha Doiphode
## Date:   08-16-2022

## Description:
    Convert a non-negative integer num to its English words representation.

## Examples:
    Example 1:
        Input: num = 123
        Output: "One Hundred Twenty Three"

    Example 2:
        Input: num = 12345
        Output: "Twelve Thousand Three Hundred Forty Five"

    Example 3:
        Input: num = 1234567
        Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

## Constraints:
    0 <= num <= 231 - 1

## Time complexity: O(1), since we are processing in the group of triplets and we are only going to have
                          maximum until billions.

## Space complexity: O(1), Even if we are using recursion, we are always going to have fixed stack length
                           as we are only calling it over 3 digits.

'''
def get_input():
    print("Enter the number: ", end = "")
    number = int(input())
    print()
    return number

class Solution:
    def helper(self, number: int) -> str:
        below_20 = [" ", "One", "Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                    "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]

        tens = [" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"]

        if number == 0:
            return ""
        elif number >= 1 and number < 20:
            return below_20[number] + " "
        elif number < 100:
            return tens[int(number / 10)] + " " + self.helper(number % 10)
        else:
            return below_20[int(number / 100)] + " Hundred " + self.helper(number % 100)

    def numberToWords(self, num: int) -> str:
        extensions = [" ", "Thousand", "Million", "Billion"]
        if num == 0:
            return "Zero"

        result = ""
        i = 0
        while num > 0:
            if num % 1000 > 0:
                result = self.helper(num % 1000) + extensions[i] + " " + result

            num = int(num / 1000)
            i += 1

        return result.strip()

# Driver code
solution = Solution()
number = get_input()
print(f"Input number: {number}")
print(f"Integer to words conversion: {solution.numberToWords(number)}")
