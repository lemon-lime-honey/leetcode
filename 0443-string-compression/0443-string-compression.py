class Solution:
    def compress(self, chars: List[str]) -> int:
        result, idx = 0, 0

        while idx < len(chars):
            target = chars[idx]
            cnt = 0
            while idx < len(chars) and chars[idx] == target:
                cnt += 1
                idx += 1
            chars[result] = target
            result += 1
            if cnt > 1:
                for c in str(cnt):
                    chars[result] = c
                    result += 1

        return result