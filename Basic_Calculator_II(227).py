# Time Complexity: O(N) because length of number is already capped
# Space Complexity: O(1)

class Solution:
    def calculate(self, s: str) -> int:
        if((s is None) or len(s)==0):
            return 0

        s = s.strip()

        calculated = 0
        tail = 0
        num = 0
        lastSign = "+"

        for i in range(len(s)):
            cur = s[i]
            if cur is " ":
                continue
            if cur.isdigit():
                num = num*10 + (int(cur))

            # if we are at the last index we need to process it
            if((not cur.isdigit()) or i==len(s)-1):
                if lastSign=='+':
                    calculated += num
                    tail = num
                elif lastSign=='-':
                    calculated -= num
                    tail = -num
                # for x or / we need to undo the previous action that's why we keep
                # a tail
                elif lastSign=='*':
                    calculated = calculated-tail + (tail*num)
                    tail = tail*num
                else:
                    #we are using the int(x/y) because in case of negative numbers
                    # Python Floors the result when // is used
                    # so in case of -3//2 we expect -1 but python gives us -2
                    calculated = calculated-tail + int(tail/num)
                    tail = int(tail/num)
                lastSign = cur
                num = 0

        return calculated

        # # Using Stack
        # s = s.strip()
        # stack = list()
        # num = 0
        # lastSign = '+'

        # for i in range(len(s)):
        #     cur = s[i]
        #     if cur == " ":
        #         continue
        #     if cur.isdigit():
        #         num = num*10 + int(cur)
        #     if((not cur.isdigit()) or i==len(s)-1):
        #         if lastSign=='+':
        #             stack.append(num)
        #         elif lastSign=='-':
        #             stack.append(-num)
        #         elif lastSign=='*':
        #             last_num = stack.pop()
        #             stack.append(last_num*num)
        #         else:
        #             last_num = stack.pop()
        #             stack.append(int(last_num/num))
        #         lastSign = cur
        #         num = 0

        # res = 0
        # for elem in stack:
        #     res+=elem
        # return res