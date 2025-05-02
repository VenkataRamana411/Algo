package prep.graph.algo.disjoint;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(List.of("John", "j1@com", "j2@com", "j3@com"));
        accounts.add(List.of("John", "j4@com"));
        accounts.add(List.of("Raj", "r1@com", "r2@com"));
        accounts.add(List.of("John", "j1@com", "j5@com"));
        accounts.add(List.of("Raj", "r2@com", "r3@com"));
        accounts.add(List.of("Mary", "m1@com"));
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> valueMap = new HashMap<>();
        int n = accounts.size();
        DS dsu = new DS(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!valueMap.containsKey(mail)) {
                    valueMap.put(mail, i);
                } else {
                    dsu.unionBySize(i, valueMap.get(mail));
                }
            }
        }
        List<List<String>> mergedMails = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMails.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> value : valueMap.entrySet()) {
            mergedMails.get(dsu.findParent(value.getValue()))
                    .add(value.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMails.get(i).size() != 0) {
                Collections.sort(mergedMails.get(i));
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                temp.addAll(mergedMails.get(i));
                result.add(temp);
            }
        }

        return result;
    }

    private static class DS {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DS(int V) {
            for (int i = 0; i < V; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (!parent.get(node).equals(node)) { // Avoid unnecessary recursion
                parent.set(node, findParent(parent.get(node))); // Direct compression
            }
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int up = findParent(u);
            int vp = findParent(v);

            if (up == vp) {
                return;
            } else if (size.get(up) < size.get(vp)) {
                size.set(vp, size.get(vp) + size.get(up));
                parent.set(up, vp);
            } else {
                size.set(up, size.get(up) + size.get(vp));
                parent.set(vp, up);
            }
        }
    }
}
