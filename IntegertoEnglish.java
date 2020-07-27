// Time Complexity - O(1) 
// Space Complexity - O(1)
class Solution {
    static final int THOUSAND = 1000, MILLION = 1_000_000, BILLION = 1_000_000_000;

    static final String[] L0 = new String[]{"", "One", "Two",  "Three", "Four", "Five",  "Six", "Seven", "Eight", "Nine"};

    static final String[] L1 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static final String[] L2 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return ntow(num);
    }
    
    public String ntow(int num) {
        if(num >= BILLION) 
            return concat(ntow(num/BILLION)+" Billion", ntow(num%BILLION));
        if(num >= MILLION)
            return concat(ntow(num/MILLION)+" Million", ntow(num%MILLION));
        if(num >= THOUSAND)
            return concat(ntow(num/THOUSAND)+" Thousand", ntow(num%THOUSAND));
        // num below 1000
        String ans = num < 100 ? "":L0[num/100] + " Hundred";
        num = num%100;
        return num >= 10 && num <= 19 ? concat(ans, L1[num%10]) : concat(ans, concat(L2[num/10],L0[num%10]));
    }
    
    public String concat(String s1, String s2) {
        return s1 == "" ? s2 : s2 == "" ? s1 : s1+" "+s2;
    }
}