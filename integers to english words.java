//Timecomplexity:- O(n);
//Spacecomplexity:- O(n) for reccursion stack.
//Did it run on leetcode:- Yes.
//What was the problem faced:- got wrong answers due to incorrect output formation.
//Your code with approach:- dividing number into three chunks, for that first %1000 gives you from hundreds so for all
//numbers from hundreds using reccursion to form word and merging with thousands array in intration where next time number will be num/1000.

class Solution {
    String[] below_20={" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens={" ","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands={" ","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String word=" ";
        int i=0;
        while(num>0){
            if(num%1000!=0){
                word=reccur(num%1000)+thousands[i]+" " + word;
                
            }
            i++;
            num=num/1000;
        }
      return word.trim();  
    }
    private String reccur(int num){
        if(num==0){
            return "";
        }
        else if(num<20){
            return below_20[num]+" ";
            
        }
        else if(num<100){
            return tens[num/10]+" " + reccur(num%10);
        }
        else if(num>=100){
            return below_20[num/100] +" " +"Hundred"+ " " +reccur(num%100);
        }
        return "ooho";
    }
}