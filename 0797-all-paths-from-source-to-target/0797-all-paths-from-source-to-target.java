class Solution {
    int[][] map;
    List<List<Integer>> rtn;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        map = new int[graph.length][graph.length];
        rtn = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            for(int trgt : graph[i]) {
                map[i][trgt] = 1;
            }
        }

        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new LinkedList<>();
        visited[0] = true;
        path.add(0);

        dfs(0, visited, path);

        return rtn;
    }
    
    public void dfs(int from, boolean[] visited, List<Integer> path) {
        if(from == map.length-1) {
            rtn.add(new LinkedList<>(path));
            return;
        }

        for (int to = 0; to < map[from].length; to++) {
            int isPath = map[from][to];

            if(!visited[to] && isPath == 1) {
                visited[to] = true;
                path.add(to);
                dfs(to, visited, path);
                visited[to] = false;
                path.remove(path.size()-1);
            }
        }
    }
}