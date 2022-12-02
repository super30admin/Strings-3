class Solution {
    String[] below_20={
        "", "One", "Two", "Three", "Four", "Five",
"Six", "Seven", "Eight","Nine", "Ten", "Eleven",
"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
"Seventeen", "Eighteen", "Nineteen"
};
String[] tens = {
    "", "", "Twenty", "Thirty", "Forty", "Fifty",
"Sixty", "Seventy", "Eighty", "Ninety"};
String[] suffix = {"", "Thousand", "Million", "Billion", "Trillion"};
    public String numberToWords(int num) {
        if(num== 0) {
        return "Zero";
        }
        int suffixIndex = 0;
        String res = "";
while(num > 0) {
String curr = toWord(num%1000).trim();
if(!curr.isEmpty()){
res = (curr + " " + suffix[suffixIndex] + " " + res).trim();}
++suffixIndex;
num = num/1000;}
return res;}
    private String toWord(int num) {
if(num <= 19) {
    return below_20[num];
} else if(num <= 99) {
return tens[num/10] + " " + toWord(num%10);
} else {
return toWord(num/100) + " " + "Hundred" + " " + toWord(num%100);
}
    }
}
//tc=O(n)
//sc=O(1)
