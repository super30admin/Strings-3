public class IntegerToEnglishWords {

    public static void main(String[] args){
        int i = 1234567;
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        integerToEnglishWords.numberToWords(i);

    }
    // Devide number in chunks of 3.
    //Iterate and at every iteration based on number <1000, <100 or <20 based on number
    //get the suffix from the corresponding array and string concatinate
    // recurse to devide and add under 20, under 100 and under thousad.
    String[] thousands = { "", "Thousand", "Million", "Billion" };

    String[] below_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String result = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result =  recurse(num % 1000)  + thousands[i] + " "  + result ;
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }

    private String recurse(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return below_20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] +" " + recurse(num % 10);
        }else{
            return below_20[num/100] + " Hundred "  + recurse(num%100);
        }

    }
}
