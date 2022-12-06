//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
       
        int mod = 1000000000 + 7;
      
        int ttn = Integer.MAX_VALUE; // TIME TILL NOW.
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.size(); i++){
            
            int src = roads.get(i).get(0);
            int dest = roads.get(i).get(1);
            int time = roads.get(i).get(2);

            graph.get(src).add(new Node(dest,time));
            graph.get(dest).add(new Node(src,time));
        }

        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        
        int [] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Node> que = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a.time,b.time);
        });

        que.add(new Node(0,0));

        while(que.size() > 0){

            Node node = que.remove();
            int start = node.node;
            int time = node.time;


            for(Node nd : graph.get(start)){

                int dest = nd.node;
                int newTime = nd.time;


                    if(dist[dest] > newTime + time){
                    dist[dest] = newTime + time;
                    que.add(new Node(dest,dist[dest]));
                     ways[dest] = (ways[start] + ways[dest]) % mod;

                    } else if (dist[dest] == newTime + time){
                        ways[dest] = (ways[start] + ways[dest]) % mod;
                    }

            }
        }

        return ways[n-1];
    }
}

class Node {
    int node;
    int time;

    Node(int node, int time){
        this.node = node;
        this.time = time;
    }
}