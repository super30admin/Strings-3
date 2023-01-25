// Time O(1) because we are finding triplet and each triplet running max 3 time. Number of triplet in 2^31 -1 is limited. 
// Space O(1)
public class IntegerToWord {

    String[] below20 ={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine", "Ten","Eleven","Twelve","Thirteen","Fourteen",
                       "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
  String[] tens ={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
  
  String[] Thousands = {"","Thousand","Million","Billion"};
  
  String result;
  
  public String numberToWords(int num) {
      result ="";
      if(num==0)
          return "Zero";
     int i=0; 
      while(num > 0)    
      {
          int triplet = num %1000;
          if(triplet!=0)
               result = helper(triplet).trim()+" "+ Thousands[i]+" "+result;
          i++;
          num=num/1000;
      }
      
      return result.trim();
  }
  
  public String helper(int num){
    if(num==0)
        return "";
     else if(num<20){
         return below20[num]+" ";
     }
     else if(num < 100){
         return tens[num/10]+" "+helper(num%10);
     }
     else{
        return below20[num/100]+" Hundred "+helper(num%100);
      }    
        
     }  
  
}
