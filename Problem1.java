import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class Solution {
    
    private HashMap<Integer,String> tens = new HashMap<Integer,String>();
    private HashMap<Integer,String> twenties = new HashMap<Integer,String>();
    private HashMap<Integer, String> tenMult = new HashMap<Integer,String>();

    
    public String parseTwos(Integer num){
        String res = "";
        if(num % 10 == 0 && num != 0){
            res = tenMult.get(num);
        }else if(num >= 20){
            res = tenMult.get(num/10 * 10) + " " + tens.get(num - num/10*10);
        }else if(num >= 11){
            res = twenties.get(num);
        }else if(num != 0){
            res = tens.get(num);
        }
        
        return res;
    }
    
    public String parseThrees(Integer num){
        int hundreds = num / 100;
        String res="";
        if(num % 100 == 0){
            res = tens.get(hundreds) + " Hundred";
        }else if(hundreds != 0){
            res = tens.get(hundreds) + " Hundred " + parseTwos(num-hundreds*100);
        }else{
            res = parseTwos(num);
        }
        return res;
    }
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        tens.put(1,"One");
        tens.put(2,"Two");
        tens.put(3,"Three");
        tens.put(4,"Four");
        tens.put(5,"Five");
        tens.put(6,"Six");
        tens.put(7,"Seven");
        tens.put(8,"Eight");
        tens.put(9,"Nine");
        tens.put(10,"Ten");
        
        twenties.put(11,"Eleven");
        twenties.put(12,"Twelve");
        twenties.put(13,"Thirteen");
        twenties.put(14,"Fourteen");
        twenties.put(15,"Fifteen");
        twenties.put(16,"Sixteen");
        twenties.put(17,"Seventeen");
        twenties.put(18,"Eighteen");
        twenties.put(19,"Nineteen");
    
        tenMult.put(10,"Ten");
        tenMult.put(20,"Twenty");
        tenMult.put(30,"Thirty");
        tenMult.put(40,"Forty");
        tenMult.put(50,"Fifty");
        tenMult.put(60,"Sixty");
        tenMult.put(70,"Seventy");
        tenMult.put(80,"Eighty");
        tenMult.put(90,"Ninety");
        
        
        String result = "";
        int billion = num / 1_000_000_000;
        int million = (num - (billion*1_000_000_000)) / 1_000_000;
        int thousand =( num -(billion * 1_000_000_000) - (million * 1_000_000))/ 1_000;
        int rest = (num - (billion*1_000_000_000) - (million * 1_000_000) - (thousand * 1_000));
        
        if(billion != 0){
            result += parseThrees(billion) + " Billion";
        }
        if(million != 0){
            if(!result.isEmpty()) result += " ";
            result += parseThrees(million) + " Million";
        }
        if(thousand != 0){
            if(!result.isEmpty()) result += " ";
            result += parseThrees(thousand) + " Thousand";
        }
        if(rest != 0){
            if(!result.isEmpty()) result += " ";
            result += parseThrees(rest);
        }

        return result;
    }
}


//1234567891


