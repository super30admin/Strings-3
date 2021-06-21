class IntegerToEnglishWord {
    String[] numsBelowTwenty = new String[]{"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] scale = new String[]{"Hundred", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        StringBuilder result = new StringBuilder();
        
        //calculate digits in num
        int count = 0; int tempNum = num;
        
        //if num is 0
        if(num == 0)
            return "Zero";
        
        while(tempNum>0)
        {
            tempNum/=10;
            count++;
        }
        
        //If number is 1 digit or smaller than 20
        if(count==1)
        {
            result.append(numsBelowTwenty[num]);
            return result.toString();
        }
        
        //If number is 2 digits. 20-99.
        else if(count==2)
            return convertTwoDigits(num);
        
        //If number is 3 digits and above
        else if(count==3)
            return convertThreeDigits(num);
        
        //everything else - more than 3 digits
        else //1 000, 1 016, 1 309, 12 001, 12 310, 12 312, 12 345, 123 345, 1 234 567, 10 234 567, 100 234 567, 1 234 567 891
        {
            count=0; 
            Stack<String> tempResult = new Stack<>();
            while(num>0)
            {
                int threeDigits = num%1000;
                if(threeDigits==0)
                    tempResult.push("");
                else if(threeDigits < 9)
                    tempResult.push(numsBelowTwenty[threeDigits]);
                else if(threeDigits<100)
                    tempResult.push(convertTwoDigits(threeDigits));
                else
                    tempResult.push(convertThreeDigits(threeDigits));
                num/=1000;
                count++;
            }
            String currentScale = "";
            int size = tempResult.size()-1;
            String tempDig = "";
            while(size>0)
            {
                //System.out.println("stack: "+tempResult);
                currentScale = scale[tempResult.size()-1];
                tempDig = tempResult.pop();
                if(tempDig!="")
                {
                    result.append(tempDig);
                    result.append(" ");
                    result.append(currentScale+ " ");
                }
                size--;
            }
            tempDig = tempResult.pop();
            if(tempDig=="")
                result.setLength(result.length() - 1);
            else
                result.append(tempDig);
        }
        return result.toString();
    }
    
    private String convertThreeDigits(int num) //100, 110, 113, 123, 200, 950, 999
    {
        int firstNum = num/100;
        int lastTwoNums = num%100; 
        
        if(lastTwoNums!=0)
            return numsBelowTwenty[firstNum] + " " + "Hundred" + " " + convertTwoDigits(lastTwoNums);
        else 
            return numsBelowTwenty[firstNum] + " " + "Hundred";
    }
    
    private String convertTwoDigits(int num) //10, 13, 20, 31, 56, 68, 80, 99
    {
         if(num < 20)
             return numsBelowTwenty[num];
        //get the 1st digit
        int firstDigit = num/10; //2, 3, 9
        //get the second digit
        int secondDigit = num%10; //0, 1, 9
        
        if(secondDigit!=0)
            return tens[firstDigit]+" "+numsBelowTwenty[secondDigit];
        else 
            return tens[firstDigit];
    }
}