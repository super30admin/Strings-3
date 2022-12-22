//TC: O(n) 
//SC: O(1) small 
class Solution {
    
    String[] ones = {"" , "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
    int billion = 1000000000;
    int million = 1000000;
    int thousand = 1000;
    int hundred = 100;
    
    
    private String solve(int num){
        
        String ans = "";
        
        if(num >= billion){
            ans = solve(num / billion) + " Billion " + solve(num % billion);
        }
        else if(num >= million){
            ans = solve(num / million) + " Million " + solve(num % million);
        }
        else if(num >= thousand){
            ans = solve(num / thousand) + " Thousand " + solve(num % thousand);
        }
        else if(num >= hundred){
            ans = solve(num / hundred) + " Hundred " + solve(num % hundred);
        }
        else if(num <= 19){
            ans = ones[num]; 
        }
        else{
            ans = tens[num / 10] + " " + solve(num % 10);
        }
        
        return ans.trim();
    }
    
    
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        
        return solve(num).trim();
    }
}