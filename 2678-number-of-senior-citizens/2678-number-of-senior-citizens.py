class Solution:
    def countSeniors(self, details: List[str]) -> int:
        result = 0

        for detail in details:
            if (detail[11] in '789' or 
                (detail[11] == '6' and detail[12] != '0')):
                result += 1
                print(detail)

        return result