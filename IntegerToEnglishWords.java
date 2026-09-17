//TimeComplexity: O(logn)
//SpaceComplexity: O(1)
class Solution {

    String[] units = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ",                          "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ",                                "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = new String[]{"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",                         "Eighty ", "Ninety "};
    String[] thousands = new String[]{"", "Thousand ", "Million ", "Billion "};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int index  = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0)
        {
            int remainder = num % 1000;
            if(remainder != 0){
                sb.insert(0, thousands[index]).insert(0, getTriplets(remainder));
            }
            num = num/1000;
            index++;
        }

        return sb.toString().trim();
    }

    private String getTriplets(int num){
        if(num ==0) return "";
        else if(num < 20) return units[num];
        else if(num < 100) return tens[num/10] + units[num%10];
        else return units[num/100] + "Hundred " + getTriplets(num%100);
    }
}