import java.util.Comparator;
import java.util.Scanner;

public class TreeMap<K,V> {
    private class TreeNode implements Comparable<TreeNode>{
        private K key;
        private V value;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private void set(TreeNode o) {
            this.key = o.key;
            this.value = o.value;
        }
        public int compareTo(TreeNode o) {
            return compareKeys(key, o.key);
        }
    }
    private TreeNode root;
    private Comparator<? super K> comparator;
    private int compareKeys(K first, K second){
        if (comparator == null){
            return ((Comparable) first).compareTo(second);
        }
        return comparator.compare(first, second);
    }
    public TreeMap(){
        comparator = null;
    }
    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key: ");
        K key = (K) sc.next();
        System.out.print("Enter value: ");
        V value = (V) sc.next();
        add(key, value);
        System.out.println();
    }
    public void add(K key, V value) {
        if (comparator == null && !(key instanceof Comparable)) {
            throw new RuntimeException("If key isn't comparable you must set comparator!");
        }
        TreeNode res = new TreeNode(key, value);

        if (root == null) {
            root = res;
            return;
        }
        TreeNode node = root;
        while(true) {
            int comp = res.compareTo(node);
            if (comp == 0) {
                node.set(res);
                break;
            }
            if (comp > 0) {
                if (node.right == null) {
                    node.right = res;
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = res;
                    break;
                }
                node = node.left;
            }
        }
    }
    public void get(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the key: ");
        K key = (K) sc.next();
        V value = get(key);
        if (value != null)
            System.out.println(value + " is value of node");
        else
            System.out.println("Tree is empty.");
    }
    public V get(K key) {
        TreeNode node = root;
        while (node != null) {
            int comp = compareKeys(key, node.key);
            if (comp == 0) {
                return node.value;
            }
            if (comp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
