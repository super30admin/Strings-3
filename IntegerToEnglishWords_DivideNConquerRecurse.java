import java.util.Scanner;

public class IntegerToEnglishWords_DivideNConquerRecurse {

    // DIVIDE AND CONQUER WITH RECURSION - O(N)

    String[] under20 = {"","One","Two","Three","Four",
            "Five","Six","Seven","Eight","Nine","Ten", "Eleven","Twelve",
            "Thirteen","Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen","Nineteen"};

    String[] tens = {"", "Ten","Twenty","Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] triplets = {"","Thousand","Million","Billion"};

    public String numberToWords(int num) {

        if(num == 0) return "Zero";

        String result = "";

        // iterate over each triplet
        for(int i = 0; num > 0; i++){ // O(N)

            // if reminder of remaining number/1000 is not zero
            if(num % 1000 != 0){

                // update result
                result = helper(num % 1000).trim() + " " + triplets[i] + " " + result;
            }

            // next number to be processed for next triplet is one thousandth of current number
            num = num / 1000;
        }

        return result.trim();
    }

    // recursion call to convert num to words
    private String helper(int num){ // O(1)

        if(num < 20){

            return under20[num];
        }

        else if(num < 100){

            return tens[num / 10] + " " + helper(num % 10);
        }

        else{

            return under20[num / 100]+ " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {

        IntegerToEnglishWords_DivideNConquerRecurse obj = new IntegerToEnglishWords_DivideNConquerRecurse();

        Scanner scanner = new Scanner(System.in);

        System.out.println("num: ");
        int num = scanner.nextInt();

        System.out.println(obj.numberToWords(num));

    }
}


/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(1)
*/

