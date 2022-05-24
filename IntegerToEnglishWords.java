class Solution {

    //Time Complexity = 0(1) Since the range of the digits is given and it cannot exceed that
    //Space Complexity 0(1); We have a fixed space alloted for the array and it does not take up any more space than that. For recursive stack, there can only be 3 stacks at at ime since we are dealing with only 3 integer values in recursive stack at once
    //Did it successfully run on leetcode: Yes
    //Did you face nay problem while coding: No

    //In brief, explain your approach

    String [] thousands = {"", "Thousand", "Million", "Billion"};   //declared a thousands array to capture the thousand's position
    String [] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};//declared this since the nomenclature of numbers below 20 are different and then we reuse all the numbers
    String [] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}; //to capture ten's place

    public String numberToWords(int num) {
        if( num == 0){
            return "Zero";  //if there is no number then the output wil be 0
        }
        String result = ""; //declaring a string for result
        int i = 0;  //to navigate the thousands array
        while( num > 0){    //till num comes to 0
            if(num % 1000 != 0){    //base condition
                result = helper(num % 1000) + thousands[i] + " " + result;  //sending the remainder to the helper method to find the word till hundred's position
            }

            i++;
            num = num / 1000;   //decrementing the number by 3 indices
        }
        return result.trim();   //returning the final result and trimming the last space in the string to match the output condition
    }
    public String helper(int num){
        if(num == 0){   //if the remainder of the above modulo is 0, then we return an empty string
            return "";
        }
        else if(num < 20){ //if it is less than 20, then we go to the below 2's array and return the required no.
            return below20[num] + " ";
        }
        else if(num < 100){ //if the function receive a no above 20, then we go to the tens array, and take the ten's position word and call helper method recursively to get the word for no. at one's place
            return tens[num / 10] + " " + helper(num % 10);
        }
        else{
            return below20[num / 100] + " Hundred " + helper(num % 100);    //if the no. is above 100, we take num from 100's spot and return the word for that index, then we add hundred to out result and then recursive call helper method to get the word for the digit at 10's and 1's place
        }
    }
}