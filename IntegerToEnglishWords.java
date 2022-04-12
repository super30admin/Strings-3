/*
Time Complexity: O(1)
Space Complexity: O(1)
Run on Leetcode: yes
Any difficulties: No

Approach:
1. Solved once discussed in the class
 */
public class IntegerToEnglishWords {
    public static String[] twenties = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String[] thousands = {"", "Thousand", "Million", "Billion"};
    public static String integerToEnglishWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String convertedWord = "";
        int i=0;
        while(num > 0){
            if(num % 1000 != 0){ // if number is a three digit number
                convertedWord = convertNumIntoWords(num % 1000) + thousands[i] + " "+ convertedWord;
            }
            num = num/1000;
            i++;
        }
        return convertedWord.trim();
    }
    public static String convertNumIntoWords(int num){

        if(num == 0){
            return "";
        }
        else if(num < 20){ // if number is till 19
            return twenties[num%20] +" ";
        }
        else if(num < 100){ // numbers till 99
            return hundreds[num/10] + " "+convertNumIntoWords(num%10);
        }
        else {
            return twenties[num / 100] + " Hundred " + convertNumIntoWords(num % 100);
        }
    }

    public static void main(String[] args){
        System.out.println("Integer to English Words: "+ integerToEnglishWords(123));
    }
}
