/**
 * Time Complexity: 
 * Space Complexity: 
 * Did this code successfully run on Leetcode: Yes/No
 * Any problem you faced while coding this: None

 * Approach:
 * Explain your approach here.
 */

public class BasicCalculator2 {
    String[] below20 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] placeValue = new String[] { "", "Thousand", "Million", "Billion" };

    String[] tens = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String result = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result = createUnderThousand(num % 1000) + placeValue[i] + " " + result;
            }
            num /= 1000;
            i++;
        }

        return result.trim();
    }

    private String createUnderThousand(int num) {
        if (num == 0)
            return "";
        else if (num < 20) {
            return below20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + createUnderThousand(num % 10);
        } else {
            return below20[num / 100] + " Hundred " + createUnderThousand(num % 100);
        }
    }

    public static void main(String[] args) {
        // Your code here
        BasicCalculator2 obj = new BasicCalculator2();
        int num = (int) (Math.pow(2L, 31L) - 1);
        String result = obj.numberToWords(num);
        String expString = "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven";
        System.out.println(result);
        assert (expString == null ? result == null : expString.equals(result));
    }
}