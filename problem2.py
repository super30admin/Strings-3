#basic calc
#TC: O(N)
#SC: O(1)
class Solution:
    def calculate(self, s: str) -> int:
        curr_res = 0
        res = 0
        num = 0
        op = "+"  # keep the last operator we have seen
        
		# append a "+" sign at the end because we can catch the very last item
        for ch in s + "+":
            if ch.isdigit():
                num = 10 * num + int(ch)

            # if we have a symbol, we would start to calculate the previous part.
            # note that we have to catch the last chracter since there will no sign afterwards to trigger calculation
            if ch in ("+", "-", "*", "/"):
                if op == "+":
                    curr_res += num
                elif op == "-":
                    curr_res -= num
                elif op == "*":
                    curr_res *= num
                elif op == "/":
                    # in python if there is a negative number, we should alway use int() instead of //
                    curr_res = int(curr_res / num)
                
                # if the chracter is "+" or "-", we do not need to worry about
                # the priority so that we can add the curr_res to the eventual res
                if ch in ("+", "-"):
                    res += curr_res
                    curr_res = 0
                
                op = ch
                num = 0
        
        return res