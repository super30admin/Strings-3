// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will divide the numbers into three chunks. Any given number can be divided into triplets. After every 3 digits the suffix will change. 
// To chane the triplets into words, we need to find the uniqueness in them, so we store them in different arrays. Maximum we will have four triplets and in each triplet we will perform 3 operations. 
// In the numberToWords function we find different triplets that can be formed and use a helper function to decode the triplet further

class Solution {
    String [] below20= new String[] { " ", "One", "Two", "Three", "Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String []Tens=new String[] {" "," ","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String []Thousands=new String[] {" ","Thousand","Million","Billion"};

    public String numberToWords(int num) 
    {
        
        int i=0;
        String result="";
        if(num==0) return "Zero";
        while(num>0)
        {
            int triplet=num%1000;
            if(triplet!=0)
            {
                result=helper(triplet).trim() + " " + Thousands[i] + " "+ result;
            }
            num=num/1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num)
    {
        if(num<20)
        {
            return below20[num];
        }
        else if(num<100)
        {
            return Tens[num/10] + " " + helper(num%10);
        }
        else
        {
            return below20[num/100] + " " + "Hundred" + " " + helper(num%100);
        }

    }
}