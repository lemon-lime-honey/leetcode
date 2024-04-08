class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        nums = [0, 0]
        idx = 0

        for student in students:
            nums[student] += 1

        while idx < len(sandwiches):
            if nums[sandwiches[idx]] > 0:
                nums[sandwiches[idx]] -= 1
            else:
                break
            idx += 1

        return len(sandwiches) - idx