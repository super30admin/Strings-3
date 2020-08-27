/*
  time : O(n)
  Space: O(1)
  Run on LeetCode: yes
*/
class Solution {

    String ones[] = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten "};
    String teen[] = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String normal[] = {"","","Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String cent[] = {"", "Thousand ", "Million ", "Billion "};

    private StringBuilder createHunder(int num){
        StringBuilder last = new StringBuilder();

        int cnt = 0;
        int temp = num;
        while(num > 0){
            int n = num %10;
            num /= 10;
            StringBuilder str = new StringBuilder();
            if(cnt == 1){
                if(n == 1){
                    int tn = temp%10;
                    last = new StringBuilder();
                    str .append(teen[tn]);
                }
                else{
                    str.append(normal[n]);
                }
            }
            else if(cnt == 2){
                str.append(ones[n]);
                if(n > 0){
                    str.append("Hundred ");
                }
            }
            else{
                str.append(ones[n]);
            }
            str.append(last);
            last = str;
            cnt++;
        }
        return last;
    }

    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        int cen = 1000;
        StringBuilder last = new StringBuilder();
        int indx = 0;
        while(num > 0){
            //get last hunderd int.
            int hnd = num % cen;
            num = num/cen;

            //convert lasthunverd to a hundred.
            StringBuilder str = new StringBuilder();
            str = createHunder(hnd);

            //add centruy level.
            if(str.length() > 0)
                str.append(cent[indx]);
            str.append(last);

            //set this str as last.
            last = str;
            indx++;
        }
        last.deleteCharAt(last.length()-1);
        return last.toString();
    }
}
