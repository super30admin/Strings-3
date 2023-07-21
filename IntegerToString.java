import java.util.HashMap;
import java.util.Map;

public class IntegerToString {
    //Time complexity: O(N) size of the integer
    //Space Complexity: constant(maps are fixed and just additional string builder
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        Map<Integer, String> denomination = new HashMap<>();
        denomination.put(0, "");
        denomination.put(1, "Thousand");
        denomination.put(2, "Million");
        denomination.put(3, "Billion");
        int denom = 1000;
        StringBuilder str = new StringBuilder();

        int ctr = 0;
        while(num != 0){
            int current = num % denom;
            num = num/denom;
            StringBuilder curr = eval(current);
            if(curr.length() != 0){
                str.insert(0, eval(current) + " "+ denomination.get(ctr));
            }
            ctr++;
        }
        return str.toString().trim();
    }

    private StringBuilder eval(int num){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2, "Two");map.put(3, "Three");map.put(4, "Four");map.put(5, "Five");map.put(6, "Six");map.put(7, "Seven");map.put(8, "Eight");map.put(9, "Nine");
        map.put(10, "Ten");map.put(11, "Eleven");map.put(12, "Twelve");map.put(13, "Thirteen");map.put(14, "Fourteen");map.put(15, "Fifteen");map.put(16, "Sixteen");
        map.put(17, "Seventeen");map.put(18, "Eighteen");map.put(19, "Nineteen");map.put(20, "Twenty");map.put(30, "Thirty");map.put(40, "Forty");map.put(50, "Fifty");
        map.put(60, "Sixty");map.put(70, "Seventy");map.put(80, "Eighty");map.put(90, "Ninety");


        if(num == 0){
            return new StringBuilder();
        }
        StringBuilder st = new StringBuilder();
        //has hundred
        int hundred = num /100;
        num = num % 100;
        if(hundred != 0){
            st.append(" "+map.get(hundred)+ " Hundred");
        }

        //has tens
        int ten = num / 10;
        if(ten > 0 && ten < 2){
            st.append(" "+ map.get(num));
        }
        else{
            if(ten >= 2){
                st.append(" "+ map.get(ten*10));

            }
            num = num%10;
            if(num> 0){
                st.append(" "+map.get(num % 10));
            }
        }

        return st;
    }
}
