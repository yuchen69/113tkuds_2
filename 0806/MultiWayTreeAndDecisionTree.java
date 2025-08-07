import java.util.*;

public class MultiWayTreeAndDecisionTree {
    static class Node {
        String val;
        List<Node> children;
        Node(String val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public void dfs(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        for (Node child : root.children) dfs(child);
    }

    public void bfs(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.val);
            q.addAll(cur.children);
        }
    }

    public Node createGuessTree() {
        Node root = new Node("Is it a number > 50?");
        Node yes = new Node("Is it even?");
        Node no = new Node("Is it prime?");
        yes.children.add(new Node("Probably 60"));
        yes.children.add(new Node("Probably 55"));
        no.children.add(new Node("Probably 47"));
        no.children.add(new Node("Probably 35"));
        root.children.add(yes);
        root.children.add(no);
        return root;
    }

    public int height(Node node) {
        if (node == null) return 0;
        int max = 0;
        for (Node child : node.children)
            max = Math.max(max, height(child));
        return max + 1;
    }

    public Map<String, Integer> nodeDegrees(Node node) {
        Map<String, Integer> map = new HashMap<>();
        countDegrees(node, map);
        return map;
    }

    private void countDegrees(Node node, Map<String, Integer> map) {
        if (node == null) return;
        map.put(node.val, node.children.size());
        for (Node child : node.children)
            countDegrees(child, map);
    }
}
