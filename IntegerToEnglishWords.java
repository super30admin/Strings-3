class Solution {
    private final String[] thousands= {"","Thousand","Million","Billion"};
    private final String[] less_than_twenty= 
    {"","One","Two","Three","Four","Five","Six","Seven",
                                             "Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
                                             "Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] tens= {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        StringBuilder ans= new StringBuilder();
        int index=0;
        while(num>0){
            if(num%1000!=0){
                StringBuilder tmp= new StringBuilder();
                helper(tmp,num%1000);
                ans.insert(0,tmp.append(thousands[index]).append(" "));
            }
            index++;
            num/=1000;
        }
        return ans.toString().trim();
    }
    private void helper(StringBuilder sb, int num){
        if(num==0) return;
        if(num<20){
            sb.append(less_than_twenty[num]).append(" ");
            return;
        } else if(num<100){
            sb.append(tens[num/10]).append(" ");
            helper(sb,num%10);
        } else{
            sb.append(less_than_twenty[num/100]).append(" Hundred ");
            helper(sb,num%100);
        }
    }
}

//time complexity : O(1)
//space complexity : O(1)
