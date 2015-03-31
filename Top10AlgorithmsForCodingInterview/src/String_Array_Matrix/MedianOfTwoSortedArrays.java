package String_Array_Matrix;

/**
 * Created by wyzhangdongsheng1 on 2014/9/3.
 */
public class MedianOfTwoSortedArrays {
    public static int findMedianSortedArrays(int[] A, int[] B){
        int[] C = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < A.length && j < B.length){
            while(j < B.length && i < A.length && A[i] < B[j]){
                C[k++] = A[i++];
            }
            while(i < A.length && j < B.length && B[j] < A[i]){
                C[k++] = B[j++];
            }
            while(j < B.length && i < A.length && A[i] == B[j]){
                C[k++] = A[i++];
                j++;
            }
        }
        while(i < A.length) C[k++] = A[i++];
        while(j < B.length) C[k++] = B[j++];
        for (int l = 0; l < k; l++) {
            System.out.print(C[l] + "\t");
        }
        System.out.println();
        return C[k / 2];
    }
    public static double findMedianSortedArraysLeetCode(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }
    public static int findKth(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd){
        int aLen = A.length - aStart - 1;
        int bLen = B.length - bStart - 1;
        if(aLen == 0)
            return B[bStart + k];
        if(bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen);
        int bMid = k - aMid - 1;

        aMid += aStart;
        bMid += bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);

    }
    public static void main(String[] args) {
        int[] A = {1,2,3,5,9,1928};
        int[] B = {0,4,7,8,11};
        System.out.println(findMedianSortedArrays(A,B));
    }

}
