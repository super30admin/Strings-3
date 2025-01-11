class Problem1 {

    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion"};

    //TC :O(1)
    //SC :O(1)
    public String numberToWords(int num) {
        if(num ==0){
            return "Zero";
        }
        String result ="";


        //get the number out in group of three
        int i =0;
        while(num>0){
            int triplet =  num % 1000;
            if(triplet>0){
                result = helper(triplet) +" "+ thousands[i] +" "+ result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }

    String helper(int number){
        //takes in 3 digit numbers
        //789
        String result ="";
        if(number<20){
            result =  below20[number];
        }
        else if(number<100){
            result =  tens[number/10] +" "+ below20[number%10];
        }else{
            //number is greater than 100 - 789
            result =   below20[number/100]+" Hundred "+helper(number%100);
        }
        return result.trim();
    }

}