import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int [] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
        
        for(int i=1; i<n; i++){
            arr[i] += arr[i-1];
        }

		int sum = arr[k-1];
		for(int i=k;i<n;i++) {
			sum = Math.max(sum, arr[i]-arr[i-k]);
		}

		System.out.println(sum);
	}
}