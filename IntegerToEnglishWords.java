class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }
       String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  String[] thousands = {"", "Thousand", "Million", "Billion"};


    StringBuilder sb = new StringBuilder();                               
        int hPosition = 0; // tracking the position for every third digit;
        while ( num > 0){
            int workingNum = num % 1000;
            if (workingNum !=0){
            // logic num start
            StringBuilder thisString = new StringBuilder();
            if (workingNum >= 100){
            thisString.insert(0,below_20[workingNum/100]+ " Hundred ");
            } 
            //working with last 2 digits of the 3 digits
            int lastTwo = workingNum%100;
            if (lastTwo > 19){
                    int tens = lastTwo /10;
                    thisString.append(hundreds[tens]+" ");
                thisString.append (below_20[lastTwo%10]+ " ");
            } else {
                thisString.append (below_20[lastTwo]+ " ");
            }

            
            //logic num end
            thisString.append (thousands[hPosition]+" ");
            sb.insert(0, thisString);
       }
                   num = num/1000;
            hPosition++;
 
        }

          return sb.toString().trim().replaceAll("\\s+", " "); 
    }

}

