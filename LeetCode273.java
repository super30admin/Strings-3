// Time Complexity : O(1) -->at max 9 numbers in  given Integer
// Space Complexity : O(1) -->  just limited strings in 3 arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    String[] below_20 = new String[] {"", "One", "Two", "Three", "Four","Five","Six","Seven",
      "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
      "Seventeen", "Eighteen", "Nineteen"};  // possible string values for last 2 or 1 number in any triplet 

      String[] below_100 = new String[]{ "", "Ten", "Twenty", "Thirty", "Forty",
       "Fifty", "Sixty","Seventy","Eighty", "Ninety"}; // possible strings for 2 number in any triplet

       String[] words = new String[] {"","Thousand", "Million", "Billion" }; // possible strings for triplet position in given number num
   public String numberToWords(int num) {

     if(num ==0) return "Zero";
     String result = "";
       int i =0;
       while(num>0){
           if( num %1000 >0){  // process from end
               result = helper(num%1000)+ words[i]+" "+result;   // append to start as we are processing from end
               
           }
           i++;// this makes sure of triplet value associated with it in words array
           num = num/1000;   // now remove processed triplet at end
       }
       return result.trim();
   }

   public String helper(int num)
   {
       if (num==0) return "";   // not to add extra space
       else if(num< 20) return below_20[num] +" ";  // 0-19 return that name from below_20 array at that num
        // 20-100 get from below_100 for starting number i.e. num/10 and then proceeed to get for last element num%10
       else if(num<100) return below_100[num/10]+ " " +helper(num%10); 
      // else return below_20[num/100]+" Hundred " +helper(num%100);
   // 100-999 get from below_20 for starting number i.e. num/100 and then proceeed to get for last 2 elements num%100
      else return helper(num/100)+"Hundred " +helper(num%100);
   
   }
}