// Time: O(N) | Space: O(1)


class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen", "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] triplets = {"", "Thousand", "Million","Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String result = "";
        int i=0;
        while(num > 0) { //315 743
            // every trip will go through this,
            // i will be incremented accordingly,
            // when i == 0, there's no suffix to add,
            if(num%1000 != 0) {
                result = helper(num%1000)+triplets[i]+" "+result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    private String helper(int num) {
        // when number == 0, don't add anything to the result
        if(num == 0) return "";
        // if number is less than 20, then add the value from the below_20 array
        else if(num <20) return below_20[num]+" ";
        // if number is less than 100, add the prefix from tens array, call recursively the same helper for the remaining below 20 numbers
        else if(num <100) return tens[num/10]+" "+helper(num%10);
        else {
            return helper(num/100)+"Hundred "+helper(num%100);
        }
    }
}