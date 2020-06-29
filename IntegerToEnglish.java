//time complexity- O(1)
//space complexity- O(1)
public class IntegerToEnglish {
    static String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] hndrd = {"","Thousand", "Million", "Billion"};
        String[] ones = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        StringBuilder sol = new StringBuilder();
        int i = 0;
        while(num > 0) {
            int triplet = num % 1000;
            if(triplet != 0) {
                sol.insert(0, makeWord(num % 1000, tens, ones) + hndrd[i] + " ");
            }
            i++;
            num /= 1000;
        }
        return sol.toString().trim();
    }
    static String makeWord(int num, String[] tens,String[] ones) {
        if(num == 0) return "";
        if(num < 20) return ones[num-1] + " ";
        if(num < 100) {
            return tens[num/10] + " " + makeWord(num % 10, tens, ones);
        } else {
            return ones[num/100 - 1] + " Hundred " + makeWord(num % 100, tens, ones);
        }
    }

    public static void main(String[] args) {
        int num = 2345689;
        System.out.println(num +" => " + numberToWords(num));
    }
}
