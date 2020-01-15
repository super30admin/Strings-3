/**
Leet Code Submitted : YES
Space COmplexity : O(1) Fixed HashMap
Time Complexity : O(Number of digits in Int)

HashMap is populated with string data which are requird to convert digits to word.
The idea is to recursively iterate each digit of the number till we find relevant entry in hashmap. Also, the pther trick or scenario is to handle space which caused lot of issue for me.
**/
class Solution {
    StringBuffer word = new StringBuffer();
    int flag = 0;
    
    public String numberToWords(int num) {
        HashMap<Integer,String> hm = new HashMap<>(); 
        hm.put(1,"One");
        hm.put(2,"Two");
        hm.put(3,"Three");
        hm.put(4,"Four");
        hm.put(5,"Five");
        hm.put(6,"Six");
        hm.put(7,"Seven");
        hm.put(8,"Eight");
        hm.put(9,"Nine");
        hm.put(10,"Ten");
        hm.put(11,"Eleven");
        hm.put(12,"Twelve");
        hm.put(13,"Thirteen");
        hm.put(14,"Fourteen");
        hm.put(15,"Fifteen");
        hm.put(16,"Sixteen");
        hm.put(17,"Seventeen");
        hm.put(18,"Eighteen");
        hm.put(19,"Nineteen");
        hm.put(20,"Twenty");
        hm.put(30,"Thirty");
        hm.put(40,"Forty");
        hm.put(50,"Fifty");
        hm.put(60,"Sixty");
        hm.put(70,"Seventy");
        hm.put(80,"Eighty");
        hm.put(90,"Ninety");
        hm.put(100,"hundred");
        hm.put(1000,"Thousand");
        hm.put(1000000,"Million");
        hm.put(1000000000,"Billion");
        
        if(num == 0)
            return "Zero";
        
        return int2word(num,hm,0).trim();
    }
    
    private String int2word(int num,Map<Integer,String> hm,int flag){
        String space = flag == 0 ? "" : " ";
        if(num == 0)
            return "";
        
        if(num >= 100 && num < 1000){
                return space + hm.get(num/100) + " Hundred" + int2word(num%100,hm,1);
            }else if(num >= 1000 && num < 1000000){
                return space + int2word(num/1000,hm,0) + " Thousand" +  int2word(num%1000,hm,1);
            }else if(num >= 1000000 && num < 1000000000){
                return space + int2word(num/1000000,hm,0) + " Million" + int2word(num%1000000,hm,1);
            }else if(num >= 1000000000){ 
                return space + int2word(num/1000000000,hm,0) + " Billion" +  int2word(num%1000000000,hm,1);
            }
            else{
                if(num >= 20){
                    return space + hm.get((num/10)*10) +  int2word(num%10,hm,1);
                }else if(num != 0){
                    return space + hm.get(num);
                }else
                    return "";
            }
    }
}
