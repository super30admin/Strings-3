// Time: O(1) limited number
// Space: O(1)
// Idea here is to identify the tiplets and get their values from corresponding arrays using helper fucntion
// reduce array length each time by dividing it by 1000
// in helper function, identify if remaining value is in range of 20/ 100 or above,
// in that case recurse on helper to find number of hundreds and then number of tens and units and creating
// string to return.
class Solution {
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
        String[] underTwenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0; String result="";
        while(num>0){
            if(num%1000!=0){
                result = helper(num%1000)+thousands[i] + " " + result;
            }
            num = num/1000;
            i++;
        } 
        return result.trim();
    }
    
    public String helper(int num) {
        if(num==0) return "";
        else if(num<20) return underTwenty[num]+" ";
        else if(num<100) return tens[num/10]+ " " + helper(num%10);
        else return underTwenty[num/100] + " Hundred " + helper(num%100);
    }
}