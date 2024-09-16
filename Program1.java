//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    HashMap<Integer,String> map = new HashMap<>();
    
    public String numberToWords(int num) {
        initializeMap();
        StringBuilder sb = new StringBuilder();
        
        if(num==0){
            return map.get(0);
        }
        if(num >= 1000000000){
            int billion = num/1000000000;
            num=num%1000000000;
            sb.append(below1000(billion)+" Billion");
        }
        
        if(num >= 1000000){
            int million = num/1000000;
            num=num%1000000;
            sb.append(below1000(million)+" Million");
        }
        
        if(num >=1000){
            int thousand = num/1000;
            num = num%1000;
            sb.append(below1000(thousand)+" Thousand");
            
        }
        if(num > 0){
            sb.append(below1000(num));
        }
        
        return sb.toString().trim();
    }
    
    
     public String below1000(int num){
         StringBuilder sb = new StringBuilder();
         if(num>=100){
             int hundred=num/100;
             sb.append(" "+map.get(hundred)+" Hundred");
             num=num%100;
         }
         
        if(num>0 && num<=20){
            sb.append(" "+map.get(num));
        }else if(num>20 && num<100){
            int tens=num/10;
            sb.append(" "+map.get(tens*10));
            int unit = num%10;
            if(unit!=0){
                sb.append(" "+map.get(unit));
            }
        }
        return sb.toString();
     }
    
    public void  initializeMap(){
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
}