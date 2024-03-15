//TC: O(1)
//SC:O(1)
class Solution {
     String [] array_1=  {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
        };
        String [] array_2={
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String [] array_3={"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0)
        return "Zero";
        String result="";
        int i=0;
       while(num!=0)
       {
        if(num%1000!=0)
         result= helper(num%1000)+" "+array_3[i]+" "+result;
        num=num/1000;
        i++;
        }
        return result.trim();
       

        
    }
    private String helper(int num)
    {
        if(num<20)
        {
           return array_1[num].trim();
        }
        else if(num<100)
        {
           return (array_2[num/10]+ " "+helper(num%10)).trim();
        }
        else
        {
            return (array_1[num/100]+" Hundred "+helper(num%100)).trim();
        }
    }
} 