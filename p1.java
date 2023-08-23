// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Had to lookup trim function


// Your code here along with comments explaining your approach

class Solution {
    //Storing the unique strings that will be used repeatedly
    String[] one = new String[]{"","One", "Two" , "Three" , "Four" , "Five", "Six" , "Seven" , "Eight", "Nine" , "Ten", "Eleven" , "Twelve" , "Thirteen" , "Fourteen" , "Fifteen" , "Sixteen", "Seventeen" , "Eighteen" , "Nineteen"};

        String[] ten = new String[]{"","Ten" , "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String[] hun = new String[]{"", "Hundred", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        //Edge case
        if(num == 0) return "Zero";
        String str = "";
        //Count to keep track of suffix
        int cnt = 2;

        //Run the loop at max 4 times to process 4 triplets
        while(num >0){
            int temp = num%1000;
            num = num/1000;
            
            if(cnt == 2) str = helper(temp);
            else if(temp != 0) str = helper(temp) + " " + str ;
            
            if(num > 0 && num%1000 != 0) str = hun[cnt] + " " + str;
            cnt++;
            
        }

        str= str.trim();
        return str;
    }

    //Helper function to get the string of int where int is ranging from 0 to 999
    private String helper(int num){
        
        String s = "";
        
        if(num%100 < 20){
            s = one[num%100];
            num = num/100;
        }
        else{
            s = one[num%10];
            num = num/10;
            s = ten[num%10] + " " + s;
            num = num/10;
        }

        if(num%10 > 0) s = one[num%10] + " " + hun[1] + " " + s;
        s= s.trim();
        return s;
    }
}