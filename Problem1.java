
// Time Complexity: O(n) where n is the number of digits in the input number
// Space Complexity: O(1) since the space used does not depend on the input size

//We break the number into triplets (groups of three digits) from the least significant side.
//Each triplet is converted to words using a helper function that handles numbers below 1000
//We use arrays to map numbers to their word equivalents for units, teens, tens, and thousands.
//The final result is built by prepending each triplet's word representation along with its scale (Thousand, Million, Billion).

class Solution {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
    "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        int i=0;
        StringBuilder res=new StringBuilder();
        while(num>0){
            int triplet=num%1000;
            if(triplet>0){
                res.insert(0,helper(triplet).trim()+thousands[i]);
            }
            num=num/1000;
            i++;
        }
        return res.toString().trim();
    }
    private String helper(int num){
        StringBuilder sb=new StringBuilder();
        if(num<20){
            sb.append(below_20[num]);
        }else if(num<100){ 
            sb.append(tens[num/10]).append(" ").append(below_20[num%10]);
        }else{
            sb.append(below_20[num/100]).append(" Hundred ").append(helper(num%100));
        }
        return sb.toString();
    }
}