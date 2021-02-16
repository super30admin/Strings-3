#Time Complexity :O(n) m is len of string
#Space Complexity :o(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    below_20=['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
    Double=['','','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
    Triplet=['','Thousand','Million','Billion']
    
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if(num==0):
            return 'Zero'
        
        res=""
        i=0

        #work in triplet
        while(num>0): #123,543
            if(num%1000!=0):
                ans=self.helper(num%1000).strip()+' '+self.Triplet[i]
                res=ans +' '+ res
            i+=1
            num=num//1000
        res=res.strip()
        return res
    
    #process the triplets
    def helper(self,num):
        if(num<20):
            return self.below_20[num]
        elif(num<100):
            return self.Double[num//10] + ' '+ self.helper(num%10)
        else:
            return self.below_20[num/100] + ' Hundred ' + self.helper(num%100)