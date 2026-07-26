//problem1
class Solution {
    String[] thous={"","Thousand","Million","Billion"};
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(num>0){
            int res=num%1000;
            if(res>0){
                sb.insert(0,helper(res).trim()+" "+thous[i]+" ");
            }
            num=num/1000;
            i++;
        }
        return sb.toString().trim();
    }
    public String helper(int num){
        StringBuilder sb=new StringBuilder();
        if(num<20){
            sb.append(below_20[num]);
        }else if(num<100){
            sb.append(tens[num/10]).append(" ").append(below_20[num%10]);
        }else{
            sb.append(below_20[num/100]).append(" Hundred ").append(helper(num%100));
        }
        return sb.toString();
    }
}
//problem2
class Solution {
    public int calculate(String s) {
        int n=s.length();
        int curr=0;
        char lastsign='+';
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                curr=curr*10+ch-'0';
            }
            if((!Character.isDigit(ch) && ch!=' ')||i==n-1){
                if(lastsign=='+'){
                    st.push(curr);
                }else if(lastsign=='-'){
                    st.push(-curr);
                }else if(lastsign=='*'){
                    st.push(st.pop()*curr);
                }else if(lastsign=='/'){
                    st.push(st.pop()/curr);
                }
                curr=0;
            lastsign=ch;
            }
        }int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}
