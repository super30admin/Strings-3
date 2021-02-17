class Solution {
    public int calculate (String s) {
        if (s.length() == 0)
            return 0;
        s += '+';
        int currentNum = 0,res=0,lastNum=0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isWhitespace(temp))
                continue;
            if (Character.isDigit(temp))
                currentNum = (currentNum) * 10 + Character.getNumericValue(temp);
            else {
                if (operation == '+' || operation == '-') {
                    res += lastNum;
                    lastNum = operation == '+' ? currentNum : - currentNum;
                } else if (operation == '/' || operation == '*')
                    lastNum = operation == '/' ? lastNum / currentNum : lastNum * currentNum;
                currentNum = 0;
                operation = temp;
            }
            // System.out.println("currnum "+currentNum+" lastnum "+lastNum+" res "+res+" operation "+operation);
        }
        res += lastNum;
        return res;
    }
}

//Time complexity : O(N)
//Space complexity : O(1)
