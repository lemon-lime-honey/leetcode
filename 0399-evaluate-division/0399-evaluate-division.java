class Pair {
    public String letter;
    public double val;

    public Pair(String s, double d) {
        letter = s;
        val = d;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.val < o2.val) {
            return -1;
        } else {
            return 1;
        }
    }
}

class Solution {
    private double[] result;
    private Map<String, List<Pair>> graph;

    private void getGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < values.length; i++) {
            if (!graph.containsKey(equations.get(i).get(0))) {
                List<Pair> temp = new ArrayList<>();
                temp.add(new Pair(equations.get(i).get(1), values[i]));
                graph.put(equations.get(i).get(0), temp);
            } else {
                graph.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            }
            if (!graph.containsKey(equations.get(i).get(1))) {
                List<Pair> temp = new ArrayList<>();
                temp.add(new Pair(equations.get(i).get(0), 1 / values[i]));
                graph.put(equations.get(i).get(1), temp);
            } else {
                graph.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1 / values[i]));
            }
        }
    }

    private double calc(List<String> query) {
        if (!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))) {
                return -1.0;
        }

        if (query.get(0) == query.get(1)) {
            return 1.0;
        }

        PriorityQueue<Pair> que = new PriorityQueue<>(new PairComparator());
        que.add(new Pair(query.get(0), 1.0));
        Set<String> chk = new HashSet<>();

        while (!que.isEmpty()) {
            String now = que.peek().letter;
            double val = que.peek().val;
            que.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                String next_letter = graph.get(now).get(i).letter;
                double next_val = graph.get(now).get(i).val;

                if (chk.contains(next_letter)) {
                    continue;
                }
                if (next_letter.equals(query.get(1))) {
                    return next_val * val;
                }

                chk.add(next_letter);
                que.add(new Pair(next_letter, next_val * val));
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        result = new double[queries.size()];
        graph = new HashMap<>();

        getGraph(equations, values);

        for (int i = 0; i < queries.size(); i++) {
            double res = calc(queries.get(i));
            result[i] = res;
        }

        return result;
    }
}