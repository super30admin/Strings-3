// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    String[] tens={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] twenty = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
     String[] thousand = {"","Thousand","Million","Billion"};
        String s="";
        int i=0;
        while(num>0){
            if(num%1000!=0){
                s=hundred(num%1000)+thousand[i]+" "+s;
            }
            i++;
            num=num/1000;
        }
        return s.trim();
    }
    private String hundred(int num){
        String r="";
        
        if(num==0){
            return "";   
        }else if(num<20){
            return tens[num]+" ";
        }else if(num<100){
            return twenty[num/10]+" "+hundred(num%10);
        }else{
            return tens[num/100]+" Hundred "+hundred(num%100);
        }
        
        
        
    }
}