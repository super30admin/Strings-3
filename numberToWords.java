//TC - O(n) n-number of digits;
//SC - O
//LC - 273

class Solution {
    public String[] v1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String[] v2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String[] v3 = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num<0) return "";
        if(num==0) return "Zero";
        
        StringBuilder result = new StringBuilder();
        
        
        for(int i=0;i<4;i++){
            int th = num%1000;
            if(th>0){
                String curr = helper(th);
                result.insert(0,curr+" "+v3[i]+" ");
            }
            num=num/1000;
        }
        
        
        return result.toString().trim();
    }
    
    public String helper(int num){
        
        StringBuilder sb = new StringBuilder();
        
        if(num>=100){
            int hund = num/100;
            sb.append(v1[hund] + " Hundred ");
            num=num%100;
        }
        
        if(num<20){
            sb.append(v1[num]);
        }
        else{
            int tens = num/10;
            sb.append(v2[tens]+" ");
            num=num%10;
            sb.append(v1[num]);
        }
        
        return sb.toString().trim();
        

    }
}