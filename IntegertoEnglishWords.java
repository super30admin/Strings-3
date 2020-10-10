//Time Complexity=O(Length of num)
//Space Complexity-O(n)
class Solution {
    String[] below20={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    String[] thousands={"","Thousand","Million","Billion"};
    String[] hundred={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if(num==0)
        {
            return "Zero";
        }
        String word="";
        int i=0;
        while(num>0)
        {
            if(num%1000!=0)
            {
                word=Recur(num%1000)+thousands[i]+" "+word;
                
            }
            num=num/1000;
            i=i+1;
        }
        return word.trim();
        }
 String Recur(int num)
 {
     if(num==0)
     {
         return "";
     }
     else if(num<20)
     {
         return below20[num] + " ";
     }
     else if(num<100)
     {
         return hundred[num/10] +" "+Recur(num%10);
     }
     else if(num>=100)
     {
         return below20[num/100]+ " Hundred " +Recur(num%100);
     }
     return "";
 }
}