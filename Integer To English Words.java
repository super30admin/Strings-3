//  Time Complexity: O(1)
//  Space Complexity: O(1)
class Solution {
    String below20[] = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String thousands[] = new String[]{"", " Thousand ", " Million ", " Billion "};
    String tens[] = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        String result = "";
        int i=0;
        if(num == 0) return "Zero";
        while(num > 0){
            int triplet = num%1000;
            if(triplet != 0){
                result = helper(triplet).trim() + thousands[i] + result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
        
    }

    private String helper(int num){
        String result = "";
        if(num < 20){
            result = below20[num];
        }else if(num < 100){
            result = tens[num/10] + " " + helper(num%10);
        }else{
            result = below20[num/100] + " Hundred " + helper(num % 100);
        }
        return result;
    }
}