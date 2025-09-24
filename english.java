class Solution {
    String[] thousand=new String[]{"","Thousand","Million","Billion"};
    String[] tens=new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy", "Eighty", "Ninety"};
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        int i=0;
        StringBuilder res=new StringBuilder();
        while(num>0){
            int triplet=num%1000;
            if(triplet>0){
             res.insert(0, helper(triplet).trim() + (thousand[i].isEmpty() ? "" : " " + thousand[i] + " "));
            }
            num=num/1000;
            i++;
        }
        return res.toString().trim();
    }
    private String helper(int n) {
    if (n == 0) return "";
    if (n < 20) return below_20[n] + " ";
    if (n < 100) return tens[n / 10] + " " + helper(n % 10);
    return below_20[n / 100] + " Hundred " + helper(n % 100);
}
}