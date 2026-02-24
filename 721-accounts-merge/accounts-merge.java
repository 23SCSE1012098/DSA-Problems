// class Solution {
//     int [] parent;
//     int [] size ;
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         HashMap<String, Integer> mp = new HashMap<>();
//         for(int i=0;i<accounts.size();i++){
//             for(int j =1;j<accounts.get(i).size();j++){
//                 String email = accounts.get(i).get(j);
//                 if(!mp.ContainsKey(email)){
//                     mp.put(email);
//                 }
//                 else{
//                     Union(i,mp[email],parent);
//                 }
//             }
//         }
        
        
//     }
//     static void Union(int x, int y, int parent[]){
//         int px= find(x,parent);
//         int py= find(y,parent);
//         if(px==py) return;
//         if(size[px]>size[py]){
//             parent[py]=px;
//             size[px]=size[px]+size[py];
//         }
//         else if(size[px]<size[py]){
//             parent[px]=py;
//             size[py]=size[px]+size[py];
//         }
//         parent[py]=px;
//         return;
//     }
//     static int find(int a, int[] parent){
//         if(parent[a]==a) return a;
//         return parent[a]=find(a,parent);
//     }
// }



/// correct code

import java.util.*;

// Disjoint Set Union (DSU) for connecting accounts
class DisjointSet {
    int[] parent;
    public DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]); // Path compression
    }
    public void unionBySize(int u, int v) {
        int rootU = findUPar(u), rootV = findUPar(v);
        if (rootU != rootV) parent[rootU] = rootV;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mapMailNode = new HashMap<>();

        // 1. Connect accounts with common emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mapMailNode.containsKey(mail)) ds.unionBySize(i, mapMailNode.get(mail));
                else mapMailNode.put(mail, i);
            }
        }

        // 2. Group emails by root parent
        Map<Integer, List<String>> merged = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            int root = ds.findUPar(entry.getValue());
            merged.computeIfAbsent(root, k -> new ArrayList<>()).add(entry.getKey());
        }

        // 3. Format result
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : merged.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = accounts.get(entry.getKey()).get(0);
            emails.add(0, name);
            ans.add(emails);
        }
        return ans;
    }
}
