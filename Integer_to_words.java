// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
                 
       String[] below_20={"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        
        String[] below_100={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
        String[] above_100={"","Thousand ","Million ","Billion "};
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
       List<String> list=new ArrayList<>();
        String result="";
        int level=0;
        while(num!=0){
          if(num%1000!=0){
            result=getString(num%1000)+(above_100[level])+result;
          }
            num=num/1000;
              level++;
        }
        
        return result.trim();
    }
    
    private String getString(int num){
        int level=0;
        if(num==0){
            return "";
        }
        if(num>=100){
            return below_20[num/100]+" Hundred "+getString(num%100);
        }else if(num>=20){
            return below_100[num/10]+" "+getString(num%10);
        }else{
            return below_20[num]+" ";
        }
        
    }
}