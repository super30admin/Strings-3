//Time Complexity = O(1) or O(L) length of integer num
//Space Complexity = O(1);
class Solution {

    String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven",
            "Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
            "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        //base
        if(num ==0) return "Zero";
        String[] millions = {"","Thousand","Million","Billion","Trillion"};
        int i =0;
        String result= "";
        while(num > 0){
            //if num%1000 == 0 we should not add suffix
            if(num%1000 != 0) // if condition single statement so no flower brackets
                result = triplet(num%1000).trim() +" "+ millions[i] +" " + result;
            i++;
            num = num/1000;
            result = result;
        }
        return result.trim();
    }

    private String triplet(int num){
        String word = "";

        if(num < 20){
            return below_20[num];
        }else if(num < 100){
            word += tens[num/10] + " " + triplet(num%10);
            // num = num%10;
        }else if(num < 1000){
            word += below_20[num/100] + " " + "Hundred" + " " + triplet(num % 100);
            // num = num%100;
        }

        return word ;
    }
}