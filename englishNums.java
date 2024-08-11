// TC-O(1), sc-O(1)
class Solution {

    String[] below_20;
    String[] tens;
    String[] hundreds;
    String st;

    public String numberToWords(int num) {
        below_20 = new String[]{" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        tens = new String[]{" ", " ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        hundreds = new String[]{" ", "Thousand", "Million", "Billion"};
        st = new String();

        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        int triplet;
        while (num > 0) {
            triplet = num % 1000;
            if (triplet != 0) {
                st = helper(triplet).trim() + " " + hundreds[i] + " " + st;
            }

            i++;
            num = num / 1000;
        }

        return st.trim();

    }

    public String helper(int num) {

        if (num < 20) {
            return below_20[num];
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return below_20[num / 100] + " Hundred " + helper(num % 100);

        }
    }
}
