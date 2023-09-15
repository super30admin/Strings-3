# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : Yes
# White space irregularity

# Your code here along with comments explaining your approach


class Solution:
    below_20=["","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

    tens=["","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    suffixe_1000=["", "Thousand", "Million", "Billion"]

    def helper(self, trip, result, c):
        if(trip==0):
            return 
        if(trip<20 ):
            result+=[self.below_20[trip]]
        elif(trip<100):
            result+=[self.tens[trip//10]]
            self.helper(trip%10, result, c)
        elif(trip>=100):
            self.helper(trip//100, result, c)
            result+=["Hundred"]
            trip=trip%100
            self.helper(trip, result, c)

    def numberToWords(self, num: int) -> str:
        if(num==0):
            return "Zero"
        q=collections.deque()
        result=[]
        c=0
        temp=num
        final_num=''
        while(temp>0):
            triplet=temp%1000
            self.helper(triplet, result, c)
            if(triplet):
                result+=[self.suffixe_1000[c]]
            q.append(" ".join(result))
            result=[]
            temp=temp//1000
            c+=1
        while(len(q)):
            curr=q.pop()
            if(len(curr)):
                final_num=final_num+curr.rstrip()+" "
        return final_num.rstrip()

