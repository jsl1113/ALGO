import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        int flag = 0;
    }

    static class Trie {
        Node root = new Node();

        public String insert(String word) {
            Node node = root;
            StringBuilder sb = new StringBuilder();
            boolean isEnd = false;
            for(char c : word.toCharArray()) {
                if(node.children.get(c) != null) {
                    node = node.children.get(c);
                    sb.append(c);
                } else {
                    Node next = new Node();
                    node.children.put(c, next);
                    node = next;

                    if(!isEnd) {
                        sb.append(c);
                        isEnd = true;
                    }
                }
            }

            if(node.flag == 0) {
                node.flag = 1;
                return sb.toString();
            } else {
                node.flag += 1;
                return sb.append(node.flag).toString();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = trie.insert(br.readLine());
            sb.append(str).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}