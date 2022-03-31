class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    String[] suffix = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String res = "";
        int i = 0;
        while(num > 0){
            int h = num % 1000;
            String curr = toWord(h).trim();
            if(h!=0){
                if(suffix[i]==null){
                    res = curr + res;
                }else{
                    res = curr + " " + suffix[i] + " "+ res;
                }
            }
            
            ++i;
            num /= 1000;
            
        }
        
        return res.trim();
    }
    
    private String toWord(int num){  
        if(num <= 19){
            return below_20[num].trim();
        }
        
        if(num <= 99){
            return tens[num / 10].trim() + " " + toWord(num % 10).trim();
        }
        
        return toWord(num/100).trim() + " Hundred " + toWord(num%100).trim();  
    }
}
