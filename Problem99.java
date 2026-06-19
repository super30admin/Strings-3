//Time Complexity: O(1)
//Space Complexity: O(1)

class Solution {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        StringBuilder result = new StringBuilder();

        while(num > 0) {
            int triplet = num % 1000;

            if(triplet > 0) {
                result.insert(0, helper(triplet).trim() + thousands[i]);
            }

            num = num / 1000;
            i++;
        }

        return result.toString().trim();
    }

    private String helper(int triplet) {
        StringBuilder sb = new StringBuilder();

        if(triplet < 20) {
            sb.append(below_20[triplet]);
        } else if(triplet < 100) {
            sb.append(tens[triplet / 10]).append(" ").append(below_20[triplet % 10]);
        } else {
            sb.append(below_20[triplet / 100]).append(" Hundred ").append(helper(triplet % 100));
        }

        return sb.toString();
    }
}