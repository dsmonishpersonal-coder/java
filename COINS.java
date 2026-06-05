import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Long, Long> memo = new HashMap<>();

    static long solve(long n) {
        if (n == 0) return 0;

        if (memo.containsKey(n))
            return memo.get(n);

        long ans = Math.max(
                n,
                solve(n / 2) + solve(n / 3) + solve(n / 4)
        );

        memo.put(n, ans);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
            long n = Long.parseLong(line.trim());
            System.out.println(solve(n));
        }
    }
}