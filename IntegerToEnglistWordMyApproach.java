class IntegerToEnglishWord {
    public String numberToWords(int num) {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(0, "Zero");
        map1.put(1, "One");
        map1.put(2, "Two");
        map1.put(3, "Three");
        map1.put(4, "Four");
        map1.put(5, "Five");
        map1.put(6, "Six");
        map1.put(7, "Seven");
        map1.put(8, "Eight");
        map1.put(9, "Nine");
        
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(11, "Eleven");
        map2.put(12, "Twelve");
        map2.put(13, "Thirteen");
        map2.put(14, "Fourteen");
        map2.put(15, "Fifteen");
        map2.put(16, "Sixteen");
        map2.put(17, "Seventeen");
        map2.put(18, "Eighteen");
        map2.put(19, "Nineteen");
        
        HashMap<Integer, String> map3 = new HashMap<>();
        map3.put(10, "Ten");
        map3.put(20, "Twenty");
        map3.put(30, "Thirty");
        map3.put(40, "Forty");
        map3.put(50, "Fifty");
        map3.put(60, "Sixty");
        map3.put(70, "Seventy");
        map3.put(80, "Eighty");
        map3.put(90, "Ninety");
        
        HashMap<Integer, String> map4 = new HashMap<>();
        map4.put(100, "Hundred");
        map4.put(1000, "Thousand");
        map4.put(1000000, "Million");
        map4.put(1000000000, "Billion");
        
        int quotient;
        int tempNum; int tempnum2=0;
        StringBuilder result = new StringBuilder();
        
        if(num<10) 
            result.append(map1.get(num)); //Even though this might be handles by the last if, it won't go in because tempnum2=0 in teh beginning and we are appending a space in the beggining in the last if. not = 10 because we will return it from tempNum==10 considtion 
        
        while(num >= 10) //10 because I am appending space to the string. So I leave out the last digit and handle it in the end. Example: 120330317, num in the end would be 17. Otherwsie, it will be 7.
        {
            if(result.length()!=0)
                result.append(" ");
            
            //1234567
            quotient = num;
            tempNum = 1;
            while(quotient >= 10)
            {
                tempNum*=10;
                quotient/=10; 
            }
            
            if(map4.containsKey(tempNum))
            {
                int firstNum = num/tempNum;
                result.append(map1.get(firstNum)+" ");
                result.append(map4.get(tempNum));
            }
            else{  
                //67, 
                if(tempNum==10) //10001
                {
                    if(map1.containsKey(num))
                        result.append(map1.get(num));
                    else if(map2.containsKey(num))
                        result.append(map2.get(num));
                    else if(map3.containsKey(num))
                        result.append(map3.get(num));
                    else
                    {
                        int firstNum = num/10;
                        int secondNum = num%10;
                        result.append(map3.get(firstNum*10)+" ");
                        result.append(map1.get(secondNum));
                    }
                }
                
                //we need to pick 1st 2 nums
                //34567 - 10000 
                else if(map4.containsKey(tempNum/10))
                {
                    int firstTwoNums = num*10/tempNum;
                    if(map2.containsKey(firstTwoNums))
                        result.append(map2.get(firstTwoNums)+" ");
                    else if(map3.containsKey(firstTwoNums))
                        result.append(map3.get(firstTwoNums)+" ");
                    else
                    {
                        int firstNum = firstTwoNums/10;
                        int secondNum = firstTwoNums%10;
                        result.append(map3.get(firstNum*10)+" ");
                        result.append(map1.get(secondNum)+" ");
                    }
                    result.append(map4.get(tempNum/10));
                    tempNum/=10;
                }
                
                //we need to pick just the first 3 nums
                //234567 - 100000
                else if(map4.containsKey(tempNum/100))
                {
                    int firstNum = num/tempNum;
                    result.append(map1.get(firstNum)+" ");
                    result.append(map4.get(100)+ " ");
                    num %= tempNum;
                    tempNum/=100;
                    int firstTwoNums = num/tempNum;
                    if(map2.containsKey(firstTwoNums))
                        result.append(map2.get(firstTwoNums)+" ");
                    else
                    {
                        firstNum = firstTwoNums/10;
                        if(firstNum!=0)
                            result.append(map3.get(firstNum*10)+" ");
                        int secondNum = firstTwoNums%10;
                        if(secondNum!=0)
                            result.append(map1.get(secondNum)+" ");
                    }
                    result.append(map4.get(tempNum));
                }
            }
            num %= tempNum;
            tempnum2 = tempNum;
        }
        if(tempnum2!=10 && tempnum2!=0 && num!=0) //1. 101, 10001 2. 0, 2 , 3 3. 200, 300
            result.append(" "+map1.get(num));
        return result.toString();
    }
}