//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
            String below_20[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String tens[]={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String thousand[]={"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String ans="";
        int i=0;
        while(num>0){
            if(num%1000!=0){
                ans= recur(num%1000)+thousand[i]+" "+ans;
            }        
            num=num/1000;
            i++;
        }
        return ans.trim();
        
    }
    
    public String recur(int n){//Recursice function to find words of hundredth numbers
        if(n==0)
            return "";
        else if(n<20){
            return below_20[n%20]+" ";
        }
        else if(n<100){
            return tens[n/10]+" "+ recur(n%10);
        }
        else{
            return recur(n/100)+"Hundred "+ recur(n%100);
        }
    }
}
