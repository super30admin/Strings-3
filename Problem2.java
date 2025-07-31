//Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//diving number in grp of 3 numbers, for for each grp using the helper to find its english
//and adding the english value associated with the grp's index.

class Problem2 {
  String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  String[] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String result = new String();
        int i=0;
        while(num>0){
            int tripplet = num%1000;
            if(tripplet!=0) {
                result = helper(tripplet).trim() + " " + thousands[i] + " " + result;
            }
            i++;
            num=num/1000;
        }
        return result.trim();
    }
    private String helper(int num){
        if(num<20) return below_20[num];
        else if(num<100) return tens[num/10] + " " +  helper(num%10);
        else return below_20[num/100] + " Hundred " + helper(num%100);
    }
}
