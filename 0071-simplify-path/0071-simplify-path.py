class Solution:
    def simplifyPath(self, path: str) -> str:
        result = list()

        for name in path.split('/'):
            if name == '..':
                if result: result.pop()
            elif name not in ('', '.'): result.append(name)

        return '/' + '/'.join(result)