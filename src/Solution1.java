
public class Solution1 {
    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A.length==0 || A[0] != 1 || A.length<K || A[n-1]!=K)
            return false;
        else
            return true;
    }
}
