//time- O(1)
//Space- O(1)

public class Solution {
    private final String[] below_10= {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
 private final String[] below_20 = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
 private final String[] below_hundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
 public String numberToWords(int num) { 
     if(num==0) return "Zero";
     else return helper(num);
 }
 
 public String helper(int n){
     String result= new String();
     
     if(n<10) result= below_10[n];
     
     else if(n<20) result= below_20[n-10];
     
     else if(n<100) result= below_hundred[n/10]+" "+ helper(n%10);
     
     else if(n<1000) result= helper(n/100)+ " Hundred"+" "+helper(n%100);
     
     else if(n<1000000) result= helper(n/1000)+ " Thousand"+ " "+helper(n%1000);
     
     else if(n<1000000000) result= helper(n/1000000)+" Million"+" "+helper(n%1000000);
     
     else result= helper(n/1000000000)+" Billion"+" "+helper(n%1000000000);
     return result.trim();
   
 }
}