class Solution {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        //base case
        if(num == 0){
            return "Zero";
        }
        
        String word = "";
        int i = 0;
        
        //divide the number into 3 digit chunks
        while(num > 0){
            if(num % 1000 != 0){
                word = convert(num % 1000) + thousands[i]+ " "+ word;
            }    
            i++;//too keep track of thousands position
            num = num /1000;// every timr divide number by 1000 to get next 3 digit chunck
        }
        
        //to avoid extra spaces in the end
        return word.trim();
    }
    
    public String convert(int num){
        if(num == 0){
            return "";
        }else if(num < 20){ //the numbers below 20 have specific wordings
            return below20[num] + " ";
        }else if(num < 100){ // example 23 -> Twenyt + convert(23 % 10 => 3) -> Twenty Three
            return tens[num/10] + " "+ convert(num % 10);
        }else{// example 223 => Two Hundred + convert(23) => Two Hundred Twenty Three
            return below20[num/100] + " Hundred " + convert(num %100);
        }
        
    }
}

//Time Complexity: O(n) n -> number of digits
//Space Complexity: O(1)