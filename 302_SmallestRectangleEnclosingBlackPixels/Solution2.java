public class Solution2 { 
    public int minArea(char[][] image, int x, int y) { 
        if (image == null || image.length == 0 || image[0].length == 0 || x < 0 || y < 0) { 
            return 0; 
        } 
        int m = image.length, n = image[0].length; 
        int left = searchColumn(image, 0, y, 0, m, true); 
        int right = searchColumn(image, y+1, n, 0, m, false); 
        int top = searchRow(image, 0, x, left, right, true); 
        int bottom = searchRow(image, x+1, m, left, right, false); 
        return (right - left) * (bottom - top); 
    } 
    private int searchColumn(char[][] image, int lo, int hi, int top, int bottom, boolean flag) { 
        int m = image.length, n = image[0].length; 
        while (lo < hi) { 
            int mid = lo + (hi - lo) / 2; 
            boolean hasBlack = false; 
            for (int i = top; i < bottom; i++) { 
                if (image[i][mid] == '1') { 
                    hasBlack = true; 
                    break; 
                } 
            } 
            if (hasBlack == flag) { 
                hi = mid; 
            } 
            else { 
                lo = mid + 1; 
            } 
        } 
        return hi; 
    } 
    private int searchRow(char[][] image, int lo, int hi, int left, int right, boolean flag) { 
        int m = image.length, n = image[0].length; 
        while (lo < hi) { 
            int mid = lo + (hi - lo) / 2; 
            boolean hasBlack = false; 
            for (int j = left; j < right; j++) { 
                if (image[mid][j] == '1') { 
                    hasBlack = true; 
                    break; 
                } 
            } 
            if (hasBlack == flag) { 
                hi = mid; 
            } 
            else { 
                lo = mid + 1; 
            } 
        } 
        return hi; 
    } 
}