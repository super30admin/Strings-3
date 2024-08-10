def basic_calculator(s):
    if not s:
        return 0
    
    stack = []
    last_operator = '+'
    cur_num = 0

    for i,ch in enumerate(s):
        if ch.isdigit():
            cur_num = cur_num *10 + int(ch)
        if ch in "+-*/" or i == len(s)-1:
            if last_operator == "+":
                stack.append(cur_num)
            elif last_operator == "-":
                stack.append(-cur_num)
            elif last_operator == "*":
                stack[-1] = stack[-1]* cur_num
            elif last_operator == "/":
                stack[-1] = stack[-1]/ cur_num

            last_operator = ch
            cur_num = 0
    return sum(stack)

s = "3+2*2"
print(basic_calculator(s))