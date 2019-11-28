//Time Complexity :O(exp(N))
//Space Complexity :O(1) + recursion stack
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Got extra spaces in the result and then added extra conditions for that.


//Your code here along with comments explaining your approach

class IntegerToString {
    public String numberToWords(int num) {
        if(0 == num){return numbers[0];}
        return printNumber(String.valueOf(num));
    }
    
     String numbers[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
     String numbers1[] = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
     String numbers2[] = {"","","","Hundred","Thousand","Million","Billion"};
    private String printNumber(String number){
        if(null == number || number.length() == 0 || number.equals("0")){return "";}
        Long val = Long.valueOf(number);
        if(val == 0){return "";}
        if(0 < val && val <= 19){
            return numbers[val.intValue()];
        }else if(20 <= val && val <= 99){
            String ss = number.substring(1,number.length());
            if(Integer.valueOf(ss) == 0){
                return numbers1[Character.getNumericValue(number.charAt(0))];
            }
            return numbers1[Character.getNumericValue(number.charAt(0))] + " "+printNumber(ss);
        }else if(100 <= val && val<= 999){
            String ss = number.substring(1,number.length());
            if(Integer.valueOf(ss) == 0){
                return numbers[Character.getNumericValue(number.charAt(0))] + " "+ numbers2[3];
            }
            return numbers[Character.getNumericValue(number.charAt(0))] + " "+ numbers2[3] + " "+printNumber(ss);
        }else if(1000 <= val && val <= 999999){
            String part1 = printNumber(String.valueOf(val/1000));
            String part2 = printNumber(String.valueOf(val%1000));
            String result = part1+ " "+ numbers2[4];
            if(!part2.trim().equals("")){
                result = result +" "+ part2;
            }
            return  result;
        }else if(1000000 <= val && val < 1000000000){
            String part1 = printNumber(String.valueOf(val/1000000));
            String part2 = printNumber(String.valueOf(val%1000000));
            String result = part1+ " "+ numbers2[5];
            if(!part2.trim().equals("")){
                result = result +" "+ part2;
            }
            return  result;
        } else {
            String part1 = printNumber(String.valueOf(val/1000000000));
            String part2 = printNumber(String.valueOf(val%1000000000));
            String result = part1+ " "+ numbers2[6];
            if(!part2.trim().equals("")){
                result = result +" "+ part2;
            }
            return  result;
        }
    }