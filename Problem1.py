# Problem1:Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
# Time Complexity: O(1), A 32-bit number has at most 4 groups of 3 digits (billions, millions, thousands, ones).
# So the while loop runs at most 4 times and helper runs at most 4 recursive calls (hundred, then tens/below_20). This does not grow with input size, so it is constant time.

# Space Complexity: O(1), The lookup lists (below_20, tens, thousands) are fixed size and do not grow with input.
# The result list holds at most 4 chunks and the recursion depth of helper is at most 2. So space used stays constant.
# Approach:
# We break the number into groups of 3 digits, starting from the rightmost group, using num % 1000.
# Each group is converted into words separately using the helper function, which handles the hundreds, tens and ones parts.
# We attach the correct label (Thousand, Million, Billion) to each group based on its position, then join all groups together in the correct left to right order.

class Solution:
    # labels for each group of 3 digits, based on position (index 0 is ones group, so it stays empty)
    thousands = ["", " Thousand ", " Million ", " Billion "]
    # words for numbers 0 to 19, these are irregular so we look them up directly instead of building them
    below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    # words for tens digit, index 0 and 1 are empty placeholders since they are not used directly
    tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

    def numberToWords(self, num: int) -> str:
        # special case, since the loop below never runs for 0 and would return an empty string otherwise
        if num == 0:
            return "Zero"
        
        i = 0          # tracks which group we are on, used to pick the correct label from thousands
        result = []    # will hold the word chunk for each non zero group

        while num > 0:
            triplet = num % 1000   # pulls out the last 3 digits of num, this is the current group to convert
            
            if triplet > 0:
                # only add a chunk if this group actually has a value, skips groups that are fully zero
                # helper converts the 3 digit number to words, then we attach the label for this group
                # insert at position 0 because we are processing right to left but need left to right order in the final sentence
                result.insert(0, self.helper(triplet).strip() + self.thousands[i])
            
            num //= 1000    # removes the group we just processed, moves to the next group to the left
            i += 1           # moves to the next label position (ones to thousand to million to billion)
        
        # joins all the chunks into one string, strip removes any extra leading or trailing space
        return "".join(result).strip()
    
    def helper(self, num: int) -> str:
        # converts any number from 1 to 999 into words
        result = []

        if num < 20:
            # numbers under 20 are irregular in English, so look them up directly
            result.append(self.below_20[num])
        
        elif num < 100:
            # numbers 20 to 99 follow a regular pattern, tens word plus ones word
            result.append(self.tens[num // 10])   # num // 10 gives the tens digit
            result.append(" ")                     # space to separate tens word and ones word
            result.append(self.below_20[num % 10]) # num % 10 gives the ones digit
        
        else:
            # numbers 100 to 999, hundreds digit plus the word Hundred plus whatever remains
            result.append(self.below_20[num // 100])  # num // 100 gives the hundreds digit
            result.append(" Hundred ")                  # literal word, only one such word needed at this scale
            result.append(self.helper(num % 100))       # recursive call, num % 100 is always under 100 so it hits an earlier case
        
        return "".join(result)