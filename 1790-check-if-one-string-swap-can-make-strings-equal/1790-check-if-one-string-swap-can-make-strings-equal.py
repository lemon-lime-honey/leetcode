class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        letter1, letter2 = None, None
        chk = False

        for i in range(len(s1)):
            if s1[i] != s2[i]:
                if letter1 and letter2:
                    if s1[i] == letter2 and s2[i] == letter1 and not chk:
                        chk = True
                    else:
                        return False
                else:
                    letter1 = s1[i]
                    letter2 = s2[i]

        return not chk and not letter1 and not letter2 or chk