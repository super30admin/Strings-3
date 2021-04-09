//TC: O(num of digits)
//SC: O(3)
class Solution {
    
    String[] belowTwenty = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thous = {"","Thousand","Million","Billion","Trillion"};
    public String numberToWords(int num) {
        if(num==0)
            return belowTwenty[num];
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(num>0)
        {
            int n=num%1000;
            if(n!=0)
            {
                String str = recurr(n)+thous[i];
                sb.insert(0,str+" ");
            }
            i++;                    //Static values of intergers are taken in a string.
            num = num/1000;         //Dividing the given number by 3 digits from back and getting the string value out of that.
        }
        return sb.toString().trim();//And dividing the 3 digit number as to different static values of int strings.
    }
    
    String recurr(int n)
    {
        if(n==0)
            return "";
        else if(n<20)
            return belowTwenty[n]+" ";
        else if(n<100)
            return tens[n/10]+" "+recurr(n%10);
        else if(n>=100)
            return belowTwenty[n/100]+" Hundred "+recurr(n%100);
        return "";
    }
}