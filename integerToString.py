"""
# Approach : Recursion
# this problem needs a lot of breaking down and handling edge cases, its not a deep data
# structures problem but really ability to solve problems relies on how we break it down

E.g. 1,123,456,789
Intuition: If we get such a number, we can process it 3 digits at a time.
To process triplets, we can start from right to left. Use %1000 to get the triplet, decipher it
then use Int(//) division to drop those that triplet out of the input. Recursively do this
Until the number is > 0.

Each triplet will be suffixed by one of these (right to left) : 
["", "Thousand ", "Million ", "Billion ", "Trillion "]
so after each triplet add one of these in increasing order

Each of the three digits in the triplet need to be carefully handled. This we can do
by going left to right on a triplet.E.g. 419 - 419//100 - > 4 and 419 % 400 -> 19
For all numbers between 1 and 19 we use a below_20s array to signify number word association.
For all values of 10s we use another constants array
If a triplet number is 0, we skip processing it.

TC: O(n) as the number will only be finite length - so its close to a constant time algorithm
SC: O(1) As we don't even recurse more than a handful of times - its constant space except result list - which will still be very small
"""
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
        