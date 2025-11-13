class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        # looking at the words and ghe numbers they are partitioned into 3 positions 
        # example 1234567
        # 1- > One {Million}
        # 234-> Two hundered Thirty Four {Thousand}
        # 567 -> Five Hunderend Sixty Seven 
        # approach break them to triplets and convert them into words and as the triplets increase we keep adding thousnads, millions and so on as required 
        # tc : as the max iterations possible are 4 triplets its O(1) if it is not bounded then O(logn)
        # sc : O(1)

        # unique words possible for numbersn
        thousands = ["", " Thousand ", " Million ", " Billion "]
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        # helper function to convert the triplet to words
        def helper(num):
            result = []
            if num < 20:
                result.append(below_20[num])
            elif num < 100:
                result.append(tens[num // 10])
                result.append(" ")
                result.append(below_20[num % 10])
            else:
                result.append(below_20[num // 100])
                result.append(" Hundred ")
                result.append(helper(num % 100))
            return "".join(result)

        #lets break them to triplets 
        if num == 0:
            return "Zero"

        i = 0
        result = []

        while num > 0:
            triplet = num % 1000
            if triplet > 0:
                result.insert(0, helper(triplet).strip() + thousands[i])
            num //= 1000
            i += 1 # one partition is done then for the next partion we move to thousnad, then million and so on

        return "".join(result).strip() # strip to avoid the empty spaces 

    

