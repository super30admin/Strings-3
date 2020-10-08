//Time Complexity: O(n)
//Space Complexity: O(n)
//Did run on leetcode: yes



class Solution {
    
    //declare string values
    //to print thousands places
    String[] thousands = {"","Thousand","Million","Billion"};
    //below twenty values
    String[] below20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
                    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    //Above 100
    String[] above100 = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        
        String word = "";
        int i=0;
        //to execute a triple at a time
        while(num!=0){
            if(num%1000!=0){
                word = recurr(num%1000)+thousands[i]+" "+word;
            }
            
            num = num/1000;
            i = i+1;
        }
        
        return word.trim();
        
    }
    
    
    //a recurrence function to return the "123" a triple part of the number
    private String recurr(int num){
        //base case
        if(num==0)
            return "";
        
        if(num<20){
            return below20[num]+" ";
        }else if(num<100){
            return above100[num/10]+" "+recurr(num%10);
        }else if(num>=100){
            return below20[num/100]+" Hundred "+recurr(num%100);
        }
        
        return "";
    }
}
