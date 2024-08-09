/*
TC --> O(1)
SC --> O(1)
 */
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
        int chunks;
        while (num > 0) {
            chunks = num % 1000;
            if (chunks != 0) {
                st = Helper(chunks).trim() + " " + hundreds[i] + " " + st;
            }

            i++;
            num = num / 1000;
        }

        return st.trim();

    }

    public String Helper(int num) {

        if (num < 20) {
            return below_20[num];
        } else if (num < 100) {
            return tens[num / 10] + " " + Helper(num % 10);
        } else {
            return below_20[num / 100] + " Hundred " + Helper(num % 100);

        }
    }
}
