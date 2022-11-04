import javax.lang.model.util.ElementScanner6;

//approach -one and only!!
/*
 * for every unique english representation take seprate array. 
 * for 0-19
 * for Tens - Twenty, Thirty and so on..
 * for triplets - Thousand, Million, Billion etc
 * 
 * in the main method we will process the number and look for the result of available tripler. so we process the number
 * in following sequence
 * Triplets - num%1000 
 * Hundreds - num%100
 * tens - num%10
 * ones - num
 * 
 * so in main method, we will just call the helper with num%1000 and 
 * then we will move on to next triplet with num/1000, and with that we will lso do i++!!
 * TC - because we are just going to have 32 character at max - it's constant
 * Sc - same reson - recursive staack space is constant here becuse it will be at max 32!
 */

 class Solution{
    
    String[]  thousands = {"", "Thousand", "Million", "Billion"};
    String[] ones = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","Ten","Twenty", "Thirty", "Forty","Fifty","Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        int i=0;
        String result ="";
        while(num >0)
        {
            if(num%1000 != 0){
                result = helper(num%1000)+ " "+ thousands[i]+ " "+result;
            }
            num = num/1000; //moving onto next triplet
            i++;

        }
        return result.trim();
    }
    private String helper(int num)
    {
        if(num < 20)
        {
            return ones[num];
        }
        else if(num < 100)
        {
            return (tens[num/10]+ " "+helper(num%10)).trim(); //we dont append result here as this is 
            //what we return and final addition will be in main method
        }else{
            //its<1000 and >100
            return (ones[nums/1000]+ " "+ "Hundread"+ " "+helper(num%100)).trim();
        }
    }
 }