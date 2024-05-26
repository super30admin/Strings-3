// Tc: O(1)
// SC: O(1)
public class Problem1 {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
    String[] tens = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] below20 = new String[]{"","One", "Two", "Three", "Four", "Five", 
                                    "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
                                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        int i=0;
        if(num==0) return "Zero";
        String result="";
        while(num>0){
          int triplet = num%1000;
          if(triplet!=0){
            result = helper(triplet).trim() + thousands[i] + result;
          }  
          num = num / 1000;
          i++;
        }
        return result.trim();
    }

    private String helper(int num){
      if(num<20){
        return below20[num];
      }
      else if(num<100){
        return tens[num/10] + " " + below20[num%10];
      }else{
        return below20[num/100] + " Hundred "+helper(num%100);
      }
    }
}
