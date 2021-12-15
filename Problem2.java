class Solution {
    long nums[] = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000000, 1000_000000l, 1000_000_000000l };
    String names[] = new String[]{"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety ", "Hundred ", "Thousand ", "Million ", "Billion "};
    HashMap<Long, String> map;
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i], names[i]);
        long lBase = 1;
        long hBase = 1000;
        StringBuilder sb = new StringBuilder();
        long sub;
        String temp;
        while(num > 0){
            sub = num % 1000;
            if(sub!=0){
                temp = helper(sub);
                if(map.containsKey(hBase))
                    sb.insert(0, map.get(hBase));
                sb.insert(0, temp);
            }
            num/=1000;
            lBase*=1000;
            hBase*=1000;

        }
        return sb.toString().trim();
    }

    public String helper(long num){
        if(num==0)
            return "";
        if(num/100>0)
            return map.get(num/100)+map.get(100l)+helper(num%100);

        if(map.containsKey(num)) //11,12,20,30, etc
            return map.get(num);

        return map.get(num - num%10)+map.get(num%10);

    }
}