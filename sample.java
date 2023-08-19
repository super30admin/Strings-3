//Problem 1: Integer to English words
// Time Complexity : O(12) Best case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Form triplets and recursively find solutions for triplet
class Solution {
    String[] below_20={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen", "Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] thousands={"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String result="";
        int i=0; //suffix
        while(num>0){
            int triplet=num%1000;

            if(triplet!=0){
                result= helper(triplet).trim() + " " + thousands[i] + " " + result;
            }
            num=num/1000;
            i++;
        }
        return result.trim();
    }
    private String helper(int triplet){
        if(triplet<20){
            return below_20[triplet] + " ";
        }
        else if(triplet<100){
            return tens[triplet/10] + " " +helper(triplet%10);
        }
        else{
            return below_20[triplet/100] + " Hundred " + helper(triplet%100);
        }
    }
}

//Problem 2: Basic Calculator 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//put last number in the stack with its sign, then add up all the numbers in the stack, for multiply and divide, remove element in stack and do operation then store again.

class Solution {
    public int calculate(String s) {
        if(s==null) return 0;
        s.trim();
        char lastSign= '+';
        int cur=0;
        int n=s.length();
        //Stack Solution
        // Stack<Integer> st= new Stack<>();
        // for(int i=0;i<n;i++){
        //     char c=s.charAt(i);

        //     if(Character.isDigit(c)){
        //         cur=cur*10 +c-'0';
        //     }
        //     if((!Character.isDigit(c) && c!=' ') || i==n-1){
        //         if(lastSign=='+'){
        //             st.push(cur);
        //         }
        //         else if(lastSign=='-'){
        //             st.push(-cur);
        //         }
        //         else if(lastSign=='*'){
        //             int popped=st.pop();
        //             st.push(popped*cur);
        //         }
        //         else { //division
        //             int popped=st.pop();
        //             st.push(popped/cur);
        //         }
        //         lastSign=c;
        //         cur=0; 
        //     }
        // }
        // int calc=0;
        // while(!st.isEmpty())
        //     calc+=st.pop();
        // return calc;

        //TailSolution
        int calc=0,tail=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(Character.isDigit(c)){
                cur=cur*10 +c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==n-1){
                if(lastSign=='+'){
                    calc +=cur;
                    tail =cur;
                }
                else if(lastSign=='-'){
                    calc+= -cur;
                    tail = -cur;
                }
                else if(lastSign=='*'){
                    calc = calc-tail + (tail*cur);
                    tail=tail*cur;
                }
                else { //division
                    calc = calc-tail + (tail/cur);
                    tail=tail/cur;
                }
                lastSign=c;
                cur=0; 
            }
        }
        return calc;
    }
}