/*
 * #273. Integer to English Words
 * 
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

 */


/*
 * Time Complexity: O () -> 
 * 
 * Space Complexity: O (N) -> Recursive stack space, where 'N' is number of stack frames with string representation of integers
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.strings3;

public class IntegertoWords {
	// Arrays to get the string representations of numbers
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                       "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] hundreds = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        
        // Base condition
        // If integer given is 0, then return its string representation
        if(num == 0){
            return "Zero";
        }
        
        String word = ""; // To store the result string
        int i = 0; // To keep track of which position(thousand, hundred) we are at currently
        
        /* 
        * e.g: 1123, we are getting answer from backwards -> first calling recursion on 123
        * Storing that result in 'word'
        * Then, get answer for 1 and append answer from word to it and return final result string "word"
        */
        
        while(num > 0){
            
            if(num % 1000 != 0) // e.g: 1000, we will not go inside if statement
            { 
                word = recurr(num % 1000) + thousands[i] + " " + word;    
            }
        
            i += 1; // Increment 'i' to get the correct position -> thousand, million etc
            num = num / 1000;
        }
        
        return word.trim(); // remove extra space
            
    }
    
    public String recurr(int num){
        
        // Base case to exit recursion
        if(num == 0){
            return ""; // return an empty string
        }
        
        // Recursive case
        if(num < 20){
            return below20[num] + " ";
        }
        else if(num < 100){
            return hundreds[num/10] + " " + recurr(num % 10); 
        }
        else if(num >= 100){ 
            return below20[num/100] + " Hundred " + recurr(num % 100);
        }
        
        return ""; 
        
    }
    
}
