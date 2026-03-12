public class NilaiMahasiswa {
    
        int maxUTS_DC(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int leftMax  = maxUTS_DC(arr, l, mid);
        int rightMax = maxUTS_DC(arr, mid + 1, r);
        return (leftMax > rightMax) ? leftMax : rightMax;
        }
    
        int minUTS_DC(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int leftMin  = minUTS_DC(arr, l, mid);
        int rightMin = minUTS_DC(arr, mid + 1, r);
        return (leftMin < rightMin) ? leftMin : rightMin;
        }

        double rataUAS_BF(int[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total / arr.length;
        }
    }
