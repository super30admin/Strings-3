// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen", "Fourteen","Fifteen","Sixteen","Seventeen",
        "Eighteen","Nineteen"};
        String[] thousand = {"","Thousand","Million","Billion"};
        String[] below100 = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        
      if(num == 0){
                return "Zero";
            }
            int i =0;
            String result = "";
            while(num > 0){
                if(num % 1000 != 0){
                    result = fun(num % 1000) + thousand[i] + " " + result;
                }
                i++;
                num= num / 1000;
            }
            return result.trim();
    }

    private String fun(int num){
            if(num == 0) return "";
            else if(num<20) return below20[num] + " ";
            else if(num< 100) return below100[num/10]+ " "+ fun(num % 10);
            else return below20[num/100] + " Hundred " + fun(num % 100);
        }
}
