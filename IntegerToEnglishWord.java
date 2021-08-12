//Space Complexity: O(1);
//Time Complexity: O(1);

class Solution {
    String[] thousands = {"","Thousand","Million","Billion"};

    String[] lessThanTwenty = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        String result="";
        int index = 0;
        if(num == 0){
            return "Zero";
        }
        while(num > 0) {
            if(num%1000 !=0) {
                result = helper(num%1000) + thousands[index] + " "+ result;
            }
            num = num / 1000;
            index++;
        }
        return result.trim();
    }

    public String helper(int num) {
        if(num == 0) {
            return "";
        } else if (num < 20) {
            return lessThanTwenty[num] + " ";
        } else if( num < 100) {
            return tens[num/10] + " " + helper(num%10);
        } else {
            return lessThanTwenty[num/100] + " Hundred " + helper(num%100);
        }
    }
}