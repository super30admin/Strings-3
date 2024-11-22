class Solution {
    String[] below20 = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] suffix = {"","Thousand","Million","Billion" };
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String res="";
        int i=0;
        while(num!=0){
            int triplet = num%1000;
            if(triplet!=0){
                String temp = helper(triplet);
                res = temp+suffix[i]+" "+res;
            }
            num=num/1000;
            i++;            
        }
        return res.trim();
    }
    private String helper(int num){
        String res="";
        if(num/100>0){
            res+=below20[num/100]+" Hundred";
        }         
        if(num%100<20){
            res+=" "+below20[num%100];
        }
        else{
            res+=" "+tens[num%100/10];
            if(num%10>0)
            res+=" "+ below20[num%10];
        }
        
        return res.trim()+" ";
    }
}
