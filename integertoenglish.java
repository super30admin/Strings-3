/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    private static final String[] ones = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static final String[] tens = new String[]{"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private static final String[] special = new String[] {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"
    };
    
    private static final int billion = 1000000000;
    private static final int million = 1000000;
    private static final int thousand = 1000;
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num >= billion) {
            int b = num / billion;
            getSegment(b, sb);
            sb.append(" Billion");
            num = num % billion;
            flag = true;
        }
        if (num >= million) {
            if (flag) sb.append(' ');
            int m = num / million;
            getSegment(m, sb);
            sb.append(" Million");
            num = num % million;
            flag = true;
        }
        if (num >= thousand) {
            if (flag) sb.append(' ');
            int  t = num / thousand;
            getSegment(t, sb);
            sb.append(" Thousand");
            num = num % thousand;
            flag = true;
        }
        
        if (flag && num > 0) sb.append(' ');
        getSegment(num, sb);
        return sb.toString();
    }
    
    private void getSegment(int val, StringBuilder sb) {
        boolean flag = false;
        
        if (val >= 100) {
            int hunds = val / 100;
            sb.append(ones[hunds-1]);
            sb.append(' ');
            sb.append("Hundred");
            val = val % 100;
            flag = true;
        }
        if (val >= 10) {
            if (flag) sb.append(' ');
            if (val >= 11 && val <= 19) {
                int ind = val - 10;
                sb.append(special[ind-1]);
                val = 0;
            } else {
                int t = val / 10;
                sb.append(tens[t-1]);
                val = val % 10;
            }               
            flag = true;
        }
        if (val >= 1) {
            if (flag) sb.append(' ');
            sb.append(ones[val-1]);
        }
        
    }
}