public class TestStrings3Problems {
    public static void main(String[] args) {
        BasicCalculator2 calc = new BasicCalculator2();
        System.out.println("Calculated output is "+ calc.calculate("3+5 / 2"));
        System.out.println("Calculated output is "+ calc.calculate("3+2*2"));
        // Integer to english words
        IntegerToEnglishWords it = new IntegerToEnglishWords();
        System.out.println("Number in word is " + it.numberToWords(1234567));
        System.out.println("Number in word is " + it.numberToWords(1234));
    }
}
