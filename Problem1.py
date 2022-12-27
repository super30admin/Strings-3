#Time complexity: O(1) or O(n)  (The string can have a max len(12))
#Space complexity: O(1)

#Accepted on Leetcode

#Approach
#We separate num into partitions of three
#For each 3 chars we have a helper function to compute it's string rep, each 3 numbered string rep will have a suffix attached to it (eg. one twenty three MILLION) -> Keep computing string repr of partition length three from right to left and attaching it to final result
#Handle corner cases such as ignore zeroes


from collections import deque

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return 'Zero'
        suffix = ["", "Thousand", "Million", "Billion"]
        partitionIndex = 0
        solnList = deque()
        while num > 0:
            curNum = num%1000
            num = num//1000
            if curNum != 0:
                solnList.appendleft(suffix[partitionIndex])
                solnList.appendleft(self.helper(curNum))
            partitionIndex += 1

        return ' '.join(solnList).rstrip()
    
    def helper(self, num):
        belowTwenty = ["","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]

        aboveTwenty = ["","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        if num < 20:
            return belowTwenty[num]
        elif num < 100:
            suffix = self.helper(num%10)
            return ''.join([aboveTwenty[num//10], " ", suffix]) if suffix != "" else aboveTwenty[num//10]
        else: #greater than 100
            prefix = [belowTwenty[num//100]," ", "Hundred"]
            suffix = self.helper(num%100)
            if suffix != "":
                prefix.append(" ")
                prefix.append(suffix)
            stringVal = ''.join(prefix)
            return stringVal
            



