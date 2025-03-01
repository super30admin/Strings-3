# tc O(n), sc O(1).
# if space, increment
# if operation, save it
# if digit, build the number and perform operation
operation = "+"
res = 0
prev_num = 0
idx = 0

while idx < len(s):
    if s[idx].isdigit():
        num = 0
        while idx < len(s) and s[idx].isdigit():
            num = (num * 10) + int(s[idx])
            idx += 1
        
        idx -= 1

        if operation == "+":
            res += num
            prev_num = num
        elif operation == "-":
            res -= num
            prev_num = -num
        elif operation == "*":
            res -= prev_num
            res += prev_num * num
            prev_num = prev_num * num
        elif operation == "/":
            res -= prev_num
            res += int(prev_num/num)
            prev_num = int(prev_num/num)

    elif s[idx] != " ":
        operation = s[idx]
    
    idx += 1

return res