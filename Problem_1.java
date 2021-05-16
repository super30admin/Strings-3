//Time Complexity:O(1)
//Space Complexity:O(1)
class Solution {
    
        String[] first = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",                                 "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens= {"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] bigs={"", "Thousand", "Million", "Billion" };
        
        
    public String numberToWords(int num) {
        if(num==0) return first[0];
        String result="";
        int i =0;
        while(num>0){
            if(num%1000!=0){
                result =helper(num%1000)+ bigs[i] + " "+ result;
            }
            i++;
            num=num/1000;
        }
        return result.trim();
        
    }
    
    public String helper(int num){
        if(num==0) return "";
        else if (num<20){
            return first[num] +" ";
        }
        else if(num<100){
            return tens[num/10] +" "+helper(num%10);
        }
        else{
            return first[num/100] +" Hundred "+ helper(num%100);
        }
    }
}