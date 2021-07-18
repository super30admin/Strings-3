
// Time - O(1)
// Space - O(1)

class Solution {

    String [] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",

            "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen" };

    String [] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    String [] thousands = {"","Thousand","Million","Billion"};


    public String numberToWords(int num) { // 456,100,345

        if(num == 0) return "Zero";

        int i = 0; // index on my thousands array for suffix
        String result = "";

        while(num > 0) {

            if(num%1000 != 0) {
                result = helper(num%1000) + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;

        }

        return result.trim();




    }

    private String helper(int num) { // 345 __ ->

        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num/10] + " " + helper(num%10);
        else return below_20[num/100] + " " + "Hundred" + " " + helper(num%100);


    }


}