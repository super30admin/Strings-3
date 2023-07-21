public class Integer2English {
    String[] below20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String result = "";
        int i = 0;
        while (num > 0) {
            int triplet = num % 1000;
            if (triplet != 0) {
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;
                // result = (result.isEmpty() ? "" : " ") + helper(triplet) + " " + thousands[i]
                // + " " + result.trim();
            }
            i++;
            num /= 1000;
        }
        return result.trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return below20[num];
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return below20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        Integer2English integer2English = new Integer2English();
        int num1 = 12345;
        int num2 = 1234567;

        String words1 = integer2English.numberToWords(num1);
        System.out.println("Number in words: " + words1);

        String words2 = integer2English.numberToWords(num2);
        System.out.println("Number in words: " + words2);
    }
}