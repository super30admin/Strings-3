/*
 * Time complexity : O(n)
 * Space complexity : O(1) 
 *  
 */

class Solution {
    public String numberToWords(int num) {
        
        if(num == 0){
            return "Zero";
        }
        
        int billion = num / 1000000000;
        int million = (num - ( billion * 1000000000)) / 1000000;
        int thousand = (num - ( billion * 1000000000) - (million * 1000000))/1000;
        int hundred = num - ( billion * 1000000000) - (million * 1000000) - (thousand * 1000);
        
        StringBuilder  result = new StringBuilder();
        
        if(billion != 0){
            result.append(parseThree(billion)).append(" Billion ");
        }
        
        if(million != 0){
            System.out.println(million);
            
            // if(billion != 0){
            //     result.append(" ");
            // }
            result.append(parseThree(million)).append(" Million ");
        }
        
        if(thousand != 0){
            
            // if(million != 0){
            //     result.append(" ");
            // }
            result.append(parseThree(thousand)).append(" Thousand ");
        }
        
        if(hundred != 0){
            
            // if(thousand != 0){
            //     result.append(" ");
            // }
            result.append(parseThree(hundred));
        }
        
        return result.toString().trim();
        
    }
    
    private String parseOnes(int num){
        
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
                case 4: return "Four";
                case 5: return "Five";
                case 6: return "Six";
                case 7: return "Seven";
                case 8: return "Eight";
                case 9: return "Nine";
        }
        
        return "";
    }
    
    private String parseTwenty(int num){
        
        switch(num){
            case 11 : return "Eleven";
                case 12 : return "Twelve";
                case 13 : return "Thirteen";
                case 14 : return "Fourteen";
                case 15 : return "Fifteen";
                case 16 : return "Sixteen";
                case 17 : return "Seventeen";
                case 18 : return "Eighteen";
                case 19 : return "Nineteen";
                
        }
        
        return "";
    }
    
    private String parseTwos(int num){
        switch(num){
            case 10: return "Ten";
            case 20: return "Twenty";
            case 30: return "Thirty";
                case 40: return "Forty";
                case 50: return "Fifty";
                case 60: return "Sixty";
                case 70: return "Seventy";
                case 80: return "Eighty";
                case 90: return "Ninety";
        }
        
        return "";
    }
    
    private String parseThree(int num){
        
        StringBuilder str = new StringBuilder();
        
        int hundred = num / 100;
        
        if(hundred != 0){
            str.append(parseOnes(hundred)).append(" Hundred ");
        }
        
        int twos = num - ( hundred * 100);
        
        if(twos < 10){    
            str.append(parseOnes(twos));
        }else if(twos > 10 && twos < 20){
            str.append(parseTwenty(twos));
        }else if(twos % 10 == 0){
            str.append(parseTwos(twos));
        }else{
            int rest = twos - twos%10;
            str.append(parseTwos(rest)).append(" ").append(parseOnes(twos % 10));
        }
        
        return str.toString().trim();
    }
}