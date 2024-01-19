class Solution {
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<>();
        String[] names = path.split("/");

        for (String name: names) {
            if (name.equals("..")) {
                if (!result.isEmpty()) {
                    result.remove(result.size() - 1);
                }
            } else if (!name.isBlank() && !name.equals(".")) {
                result.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('/');

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i != (result.size() - 1)) {
                sb.append('/');
            }
        }

        return sb.toString();
    }
}