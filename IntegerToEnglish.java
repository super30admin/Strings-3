// tc : o(logn)
// sc : o(1)

class Solution {
    String[] three = {"","Thousand","Million","Billion","Trillion"};
    String[] tens= {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", 
    "Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    StringBuilder ans = new StringBuilder("");

    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i =0 ; 
        while(num!=0){
            if(num%1000 != 0 ) ans.insert(0,helper(num%1000)+three[i]+" ");
            num/=1000;
            i++;
        }
        return ans.toString().trim();
    }

    private String helper(int num ){
        if(num==0) return "";
        else if(num<20) return ones[num] + " ";
        else if (num<100) return tens[num/10]+" "+helper(num%10);
        else return ones[num/100]+" Hundred "+helper(num%100);
    }
}
