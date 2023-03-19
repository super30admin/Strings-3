/*
Integer to English Words
approach: take the given number in triplets and for each triplet divide by 100 and check if that number is
below 20 or above 20 to 100 or above 100;
time: O(12) -> O(1)
space: O(1)
 */
public class Problem2 {
    String[] below20 = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
            "Ten","Eleven","Twelve","Thirteen","Fourteen", "Fifteen","Sixteen","Seventeen",
            "Eighteen","Nineteen"};
    String[] tens = {"", "Ten", "Twenty","Thirty", "Forty", "Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = {"", "Thousand","Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i = 0;
        String res = "";
        while(num>0) {
            int triplet = num%1000;
            if(triplet!=0)
                res=getTriplet(triplet)+thousands[i]+" "+res;
            num/=1000;
            i++;
        }

        return res.trim();
    }

    private String getTriplet(int num) {
        if(num==0) return "";
        if(num<20) {
            return below20[num]+" ";
        }
        else if(num<100) {
            return tens[(num/10)]+" "+getTriplet(num%10);
        }
        else return below20[num/100]+" Hundred "+getTriplet(num%100);
    }
}
