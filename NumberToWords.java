// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String numberToWords(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");
        map.put(60,"Sixty");
        map.put(70,"Seventy");
        map.put(80,"Eighty");
        map.put(90,"Ninety");
        return numToWords(num,map).trim();
    }
    
    private String numToWords(int num, HashMap<Integer, String> map){
        if(num == 0){
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        int base;
        
        //billion case
        base = num / 1000000000;
        num = num % 1000000000;
        
        if(base > 0){
            sb.append(numToWords(base, map));
            sb.append("Billion ");
        }
        //million case
        
        base = num / 1000000;
        num = num % 1000000;
        
        if(base > 0){
            sb.append(numToWords(base,map));
            sb.append("Million ");
        }
        
        //Thousand case
        base = num / 1000;
        num = num % 1000;
        
        if(base > 0){
            sb.append(numToWords(base,map));
            sb.append("Thousand ");
        }
        //Hundred case
        base = num / 100;
        num = num % 100;
        
        if(base > 0){
            sb.append(numToWords(base,map));
            sb.append("Hundred ");
        }
        //tens case
        if(num > 20){
            base = num / 10;
            num = num % 10;

            if(base > 0){
                sb.append(map.get(base * 10));
                sb.append(" ");
            }
        }
        //ones case
        if(num > 0){
            sb.append(map.get(num));
            sb.append(" ");
        }
        
        return sb.toString();
    }
}