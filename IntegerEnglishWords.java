//Time Complexity: O(n)
//Space Complexity: O(1)

public class IntegerEnglishWords {
    String[] thousands = {"","Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven",    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
    String result = "";
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int i=0;
        while(num >0){
            if(num%1000 != 0){
                int val = num % 1000;
                result = magic(val) +thousands[i] +" "+ result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }

    public String magic(int num){
        if(num == 0){
            return "";
        }else if(num < 20){
            return below_20[num] +" ";
        }else if(num < 100){
            return tens[num/10]+" "+magic(num%10);
        }else{
            return below_20[num/100] + " Hundred "+ magic(num%100);
        }
    }
}
