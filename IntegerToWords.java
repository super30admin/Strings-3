// Time Complexity : 0(n) where n is length of the number
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class IntegerToWords {
    //define words for number below 20
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",  "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    //define words for tens
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    //define words for thousands
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String result = "";
        //if num = 0, return zero
        if(num == 0)
            return "Zero";
        int i = 0;
        //start with last 3 digits and then move forward
        //process words for 3 digits at a time
        while(num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num/1000;
            i++;
        }

        return result.trim();

    }

    //get words from array depending upon index
    private String helper(int num){
        if(num == 0){
            return "";
        }else if(num < 20){
            return below20[num] + " ";
        }else if(num < 100){
            return tens[num/10] + " " + helper(num % 10);
        }else{
            return below20[num/100] + " " + "Hundred" + " " + helper(num%100);
        }
    }
}