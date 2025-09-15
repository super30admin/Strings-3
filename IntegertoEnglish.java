class Solution {
    //Idea is to use HashMap to store mappings of numbers to words and use stack to find the possible match
    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public String numberToWords(int num) {
       if(num == 0)
        return "Zero";
       HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(1000000000, "Billion");
        hm.put(1000000, "Million");
        hm.put(1000, "Thousand");
        hm.put(100, "Hundred");
        hm.put(90, "Ninety");
        hm.put(80, "Eighty");
        hm.put(70, "Seventy");
        hm.put(60, "Sixty");
        hm.put(50, "Fifty");
        hm.put(40, "Forty");
        hm.put(30, "Thirty");
        hm.put(20, "Twenty");
        hm.put(19, "Nineteen");
        hm.put(18, "Eighteen");
        hm.put(17, "Seventeen");
        hm.put(16, "Sixteen");
        hm.put(15, "Fifteen");
        hm.put(14, "Fourteen");
        hm.put(13, "Thirteen");
        hm.put(12, "Twelve");
        hm.put(11, "Eleven");
        hm.put(10, "Ten");
        hm.put(9, "Nine");
        hm.put(8, "Eight");
        hm.put(7, "Seven");
        hm.put(6, "Six");
        hm.put(5, "Five");
        hm.put(4, "Four");
        hm.put(3, "Three");
        hm.put(2, "Two");
        hm.put(1, "One");
        
        Stack<Integer> stk = new Stack<Integer>();
         stk.push(1);
         stk.push(2);
         stk.push(3);
         stk.push(4);
         stk.push(5);
         stk.push(6);
         stk.push(7);
         stk.push(8);
         stk.push(9);
         stk.push(10);
         stk.push(11);
         stk.push(12);
         stk.push(13);
         stk.push(14);
         stk.push(15);
         stk.push(16);
         stk.push(17);
         stk.push(18);
         stk.push(19);
         stk.push(20);
         stk.push(30);
         stk.push(40);
         stk.push(50);
         stk.push(60);
         stk.push(70);
         stk.push(80);
         stk.push(90);
         stk.push(100);
         stk.push(1000);
         stk.push(1000000);
         stk.push(1000000000);

        int temp = 0;
        StringBuilder str= new StringBuilder();
        while(num>0)
        {
          temp =stk.pop();
          if(num>=temp){
            if(temp>=100){
                str = str.append(numberToWords(num/temp)).append(" ");
            }
            str.append(hm.get(temp));
            num = num%temp;

            if(num!=0){
                str.append(" ");
            }
            else
            {
                break;
            }
          }
        }
        return str.toString().trim();


    }
}
