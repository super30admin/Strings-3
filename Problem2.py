class Solution:
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        def one(num: int) -> str:
            switcher = {
                1: "One",
                2: "Two",
                3: "Three",
                4: "Four",
                5: "Five",
                6: "Six",
                7: "Seven",
                8: "Eight",
                9: "Nine",
            }
            return switcher.get(num, "")

        def two_less_20(num: int) -> str:
            switcher = {
                10: "Ten",
                11: "Eleven",
                12: "Twelve",
                13: "Thirteen",
                14: "Fourteen",
                15: "Fifteen",
                16: "Sixteen",
                17: "Seventeen",
                18: "Eighteen",
                19: "Nineteen",
            }
            return switcher.get(num, "")

        def ten(num: int) -> str:
            switcher = {
                2: "Twenty",
                3: "Thirty",
                4: "Forty",
                5: "Fifty",
                6: "Sixty",
                7: "Seventy",
                8: "Eighty",
                9: "Ninety",
            }
            return switcher.get(num, "")

        def two(num: int) -> str:
            if not num:
                return ""
            elif num < 10:
                return one(num)
            elif num < 20:
                return two_less_20(num)
            else:
                tenner = num // 10
                rest = num - tenner * 10
                return ten(tenner) + " " + one(rest) if rest else ten(tenner)

        def three(num: int) -> str:
            hundred = num // 100
            rest = num - hundred * 100
            if hundred and rest:
                return one(hundred) + " Hundred " + two(rest)
            elif not hundred and rest:
                return two(rest)
            elif hundred and not rest:
                return one(hundred) + " Hundred"

        words = ""
        chunks = [
            ("Billion", 10**9),
            ("Million", 10**6),
            ("Thousand", 10**3),
            ("", 1),
        ]
        for word, chunk_val in chunks:
            if num >= chunk_val:
                chunk_num = num // chunk_val
                words += three(chunk_num) + " " + word + " "
                num -= chunk_num * chunk_val

        return words.strip()
