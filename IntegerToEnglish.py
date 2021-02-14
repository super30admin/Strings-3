class Solution:
    def numberToWords(self, num: int) -> str:
        def calculateTriplet(x):
            lt_ten = {
                "1":"One",
                "2":"Two",
                "3":"Three",
                "4":"Four",
                "5":"Five",
                "6":"Six",
                "7":"Seven",
                "8":"Eight",
                "9":"Nine"
            }
            lt_twenty = {
                "10":"Ten",
                "11":"Eleven",
                "12":"Twelve",
                "13":"Thirteen",
                "14":"Fourteen",
                "15":"Fifteen",
                "16":"Sixteen",
                "17":"Seventeen",
                "18":"Eighteen",
                "19":"Nineteen"
            }
            gt_twenty = {
                "2":"Twenty",
                "3":"Thirty",
                "4":"Forty",
                "5":"Fifty",
                "6":"Sixty",
                "7":"Seventy",
                "8":"Eighty",
                "9":"Ninety"
            }
            
            o = ""
            i=0
            if(x[i]!="0"):
                o += lt_ten[x[i]] + " Hundred"
            i+=1
            # 1 index
            if(x[i]=="0"):
                i+=1
            elif(x[i]=="1"):
                if(o!=""):
                    o+= " "
                o += lt_twenty[x[i:]]
                return o
            else:
                if(o!=""):
                    o+= " "
                o += gt_twenty[x[i]]
                i+=1
            
            if(x[i]=="0"):
                return o
            if(o!=""):
                o+=" "
            
            o += lt_ten[x[i]]
            return o.strip()
        
        
        if(num==0):
            return "Zero"
        lt = {
            0:"",
            1:"Thousand",
            2:"Million",
            3:"Billion"
        }
        x = str(num)
        z = len(x)%3
        
        i=0
        while(z>0 and i<3-z):
            x = "0" + x
            i+=1
        y = len(x)//3
        
        i = len(x)-3
        j = len(x)-1
        k = 0
        o = ""
        while(k<y):
            n= calculateTriplet(x[i:j+1])
            if(n.strip()!=""):
                o =  n + " " + lt[k] + " " + o
            k+=1
            
            j = i-1 
            i = j-2
        #print(o)
        return o.strip()
