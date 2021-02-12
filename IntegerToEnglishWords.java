// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Keep dividing the number by 1000 and process the rightmost 3 digits first. Edge cases would be processing 0, numbers between 1 to 20 and numbers like 30,40,50. 

public class IntegerToEnglishWords {
    String result = "";
    String partWord = "";

    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};

    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    String[] numStr = {"", "Thousand", "Million", "Billion", "Trillion"};
        
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        int i = 0;
        while(num != 0){
            int part = num % 1000;

            if(part != 0){
                partWord = getWord(part).trim();  
                result = partWord + " "  + numStr[i] + " " + result + " ";
            }

            num = num / 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String getWord(int part){
        if(part <= 20){
            return below20[part];
        } else if(part<100){
            return tens[part/10] + " " + getWord(part % 10);
        } else {
            return below20[part/100] + " " + "Hundred" +" " + getWord(part % 100);
        }
    }
}
