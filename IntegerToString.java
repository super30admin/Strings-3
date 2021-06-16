class Solution {
    //Time O(1)
    //Space O(1)
            String[] below20 = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = new String[]{"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = new String[]{"", "Thousand ", "Million ", "Billion "};
        
    public String numberToWords(int num) {

        int i = 0;
        if(num == 0)
        {
            return "Zero";
        }
        String result = "";
        while(num > 0)
        {
            int triplet = num%1000;
            if(triplet != 0)
            {
               result =  helper(triplet) + thousands[i] + result ;   
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    public String helper(int num)
    {
        if(num == 0)
        {
            return "";
        }
        if(num < 20) return below20[num];
        else if(num <100) return tens[num/10] + helper(num%10);
        else return below20[num/100] + "Hundred " + helper(num%100);
    }
}