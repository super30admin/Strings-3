//Time complexity: O(n)
//Space complexity: O(1)


public class Solution {
    String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
     String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
     String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return calculate(num); 
    }
    
    //Calculating for each number case and calling recurrsive function inside it for number > 20
    
   public String calculate(int num) {
        String result = new String();
       
       // For number less than 10
        if (num < 10) result = belowTen[num];
       
       //For number less than 20 and greater than 10
        else if (num < 20) result = belowTwenty[num -10];
       
       //For number less than 100 
        else if (num < 100) result = belowHundred[num/10] + " " + calculate(num % 10);
       
        //For number less than 1000
        else if (num < 1000) result = calculate(num/100) + " Hundred " +  calculate(num % 100);
       
        //For number less than 1000000
        else if (num < 1000000) result = calculate(num/1000) + " Thousand " +  calculate(num % 1000);
       
        //For number less than 1000000000
        else if (num < 1000000000) result = calculate(num/1000000) + " Million " +  calculate(num % 1000000);
       
        //For number greater than 1 billion
        else result = calculate(num/1000000000) + " Billion " + calculate(num % 1000000000);
       
        //Removing space
        return result.trim();
    }
}