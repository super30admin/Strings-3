import java.util.Stack;

public class problem2 {
// Time Complexity :O(n);
// Space Complexity:O(n)


    // Method1

    public int calculate(String s) {
        Stack<Integer> stack= new Stack<>();
        int result=0;
        int currNum=0;
        char lastSign='+';
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum= currNum*10+ c-'0';
            }

            if((!Character.isDigit(c) && c!=' ' ) || i!=s.length()-1  )
            {
                if(lastSign=='+')
                {
                    stack.push(currNum);
                }
                if(lastSign=='-')
                {
                    stack.push(-currNum);
                }
                if(lastSign=='/')
                {
                    int popped= stack.pop();
                    stack.push(currNum/popped);
                }
                if(lastSign=='*')
                {
                    int popped= stack.pop();
                    stack.push(currNum*popped);
                }
                currNum=0;
                lastSign=c;
            }
        }
        while (!stack.isEmpty())
        {
            result+=stack.pop();
        }


        return result;

    }
    // Method2
// Time Complexity :O(n);
// Space Complexity:O(1)
    public int calculate1(String s) {
        Stack<Integer> stack= new Stack<>();
        int result=0;
        int currNum=0;
        int calc=0, tail=0;
        char lastSign='+';
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum= currNum*10+ c-'0';
            }

            if((!Character.isDigit(c) && c!=' ' ) || i!=s.length()-1  )
            {
                if(lastSign=='+')
                {
                    calc=calc +currNum;
                    tail= currNum;
                   // stack.push(currNum);
                }
                if(lastSign=='-')
                {
                    calc= calc- currNum;
                    tail= -currNum;
                    //stack.push(-currNum);
                }
                if(lastSign=='/')
                {
                    calc= (calc-tail) +(tail/currNum);
                    tail= tail/currNum;
//                    int popped= stack.pop();
//                    stack.push(currNum/popped);
                }
                if(lastSign=='*')
                {
                    calc= (calc-tail) +(tail*currNum);
                    tail= tail* currNum;
                  //  int popped= stack.pop();
                   // stack.push(currNum*popped);
                }
                currNum=0;
                lastSign=c;
            }
        }
        while (!stack.isEmpty())
        {
            result+=stack.pop();
        }


        return result;

    }
}
