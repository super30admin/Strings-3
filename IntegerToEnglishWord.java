// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class IntegerToEnglishWord {
    String[] underTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] underTwenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] underHundred = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    String helper(int num){
        String str = new String();
        if (num < 10) str = underTen[num]; 
        else if (num < 20) str = underTwenty[num - 10]; 
        else if (num < 100) str = underHundred[num/10] + " " +  helper(num%10);
        else if (num < 1000) str = helper(num/100) + " Hundred " + helper(num%100);
        else if (num < 1000000) str = helper(num/1000) + " Thousand " + helper(num%1000);
        else if (num < 1000000000) str = helper(num/1000000) + " Million " + helper(num%1000000);
        else str = helper(num/1000000000) + " Billion " + helper(num%1000000000);
        return str.trim();
    }
}
