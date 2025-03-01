# tc O(1), sc O(1).
if num == 0:
    return "Zero"
name = {
    90: 'Ninety',
    80: 'Eighty',
    70: 'Seventy',
    60: 'Sixty',
    50: 'Fifty',
    40: 'Forty',
    30: 'Thirty',
    20: 'Twenty',
    19: 'Nineteen',
    18: 'Eighteen',
    17: 'Seventeen',
    16: 'Sixteen',
    15: 'Fifteen',
    14: 'Fourteen',
    13: 'Thirteen',
    12: 'Twelve',
    11: 'Eleven',
    10: 'Ten',
    9: 'Nine',
    8: 'Eight',
    7: 'Seven',
    6: 'Six',
    5: 'Five',
    4: 'Four',
    3: 'Three',
    2: 'Two',
    1: 'One'
}

def digit_to_word(digit):
    hundreds, tens, ones = digit // 100, (digit % 100) // 10, digit % 10
    if hundreds > 0:
        res.append(name[hundreds] + " Hundred")
    if tens == 1:
        res.append(name[digit%100])
        return
    if tens > 0:
        res.append(name[tens*10])
    if ones > 0:
        res.append(name[ones])

    

denominator = 1000000000
res = []
for unit in ["Billion", "Million", "Thousand", ""]:
    q = num // denominator
    num = num % denominator
    if q > 0:
        digit_to_word(q)
        if unit != "":
            res.append(unit)
    denominator /= 1000
print(res)
return " ".join(res)