class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] thousand = {"","Thousand","Million","Billion"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(Integer num) {
        if(num == 0) return "Zero";
        String result = "";
        int idx = 0;

        while(num > 0){ 
            int triplet = num % 1000; 
            if(triplet != 0){
                result = helper(triplet).trim() +" " + thousand[idx] +" "+ result;
            }
            idx ++;
            num = num/1000; 
        }
        return result.trim();
    }

    private String helper(int num){
            if(num < 20){
                return below_20[num];
            }else if(num < 100){
                return tens[num/10] + " " + helper(num%10);
            }else{
                return below_20[num/100] + " Hundred " + helper(num%100);
            }
        }

}