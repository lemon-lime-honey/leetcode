class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        chk = [False for i in range(len(rooms))]
        key = deque([0])
        chk[0] = True

        while key:
            now = key.popleft()
            for k in rooms[now]:
                if not chk[k]:
                    key.append(k)
                    chk[k] = True

        for tf in chk:
            if not tf: return False

        return True