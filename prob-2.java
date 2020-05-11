//TC:O(N)
//SC:o(1)
class Solution {
    String tens[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    String hundreds[]={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    String thousands[]={"","Thousand","Million","Billion"};
    
    public String numberToWords(int num) 
    {
      if(num==0) return "Zero"; 
      int i=0;
      String res="";
       while(num>0)
       {
         if(num%1000!=0) 
             res=helper(num%1000)+thousands[i]+" "+res;
          
         num=num/1000;
          i++; 
       }
        
       return res.trim();    
    }  
    
    
    public String helper(int num)
    {
      if(num==0)
          return "";
      else if(num<20)
           return tens[num%20]+" ";
      else if(num<100)
           return hundreds[num/10]+" "+helper(num%10);
      else 
            return tens[num/100]+" Hundred "+helper(num%100);
        
        
        
        
    }
    
    
    
    
    
}