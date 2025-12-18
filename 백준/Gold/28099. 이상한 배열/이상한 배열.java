import java.io.*;
import java.util.*;

public class Main{
    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr, int size) {
            n = size;
            tree = new int[4 * n];
            build(arr, 1, 1, n);
        }

        void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node, start, mid);
                build(arr, 2 * node + 1, mid + 1, end);
                tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
            }
        }

        int query(int node, int start, int end, int left, int right) {
            if (right < start || end < left) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int leftMax = query(2 * node, start, mid, left, right);
            int rightMax = query(2 * node + 1, mid + 1, end, left, right);
            return Math.max(leftMax, rightMax);
        }

        int query(int left, int right) {
            if (left > right) return 0;
            return query(1, 1, n, left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            if (isWeirdArray(A, N)) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb);
    }

    static boolean isWeirdArray(int[] A, int N) {
        SegmentTree segTree = new SegmentTree(A, N);

        Map<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            positions.computeIfAbsent(A[i], k -> new ArrayList<>()).add(i);
        }

        for (int value : positions.keySet()) {
            List<Integer> posList = positions.get(value);

            for (int i = 0; i < posList.size() - 1; i++) {
                int left = posList.get(i);
                int right = posList.get(i + 1);

                if (left + 1 <= right - 1) {
                    int maxBetween = segTree.query(left + 1, right - 1);
                    if (maxBetween > value) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}