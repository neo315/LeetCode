// 302 Smallest Rectangle Enclosing Black Pixels
//An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
//
//For example, given the following image:
//
//[
//  "0010",
//  "0110",
//  "0100"
//]
//and x = 0, y = 2,
//Return 6
//    
public class Solution { 
    public int minArea(char[][] image, int x, int y) { 
        if (image == null || image.length == 0 || image[0].length == 0 || x < 0 || y < 0) { 
            return 0; 
        } 
        int m = image.length, n = image[0].length; 
        int left = searchColumn(image, 0, y, true); 
        int right = searchColumn(image, y+1, n, false); 
        int top = searchRow(image, 0, x, true); 
        int bottom = searchRow(image, x+1, m, false); 
        return (right - left) * (bottom - top); 
    } 
    private int searchColumn(char[][] image, int lo, int hi, boolean flag) { 
        int m = image.length, n = image[0].length; 
        while (lo < hi) { 
            int mid = lo + (hi - lo) / 2; 
            boolean hasBlack = false; 
            for (int i = 0; i < m; i++) { 
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
    private int searchRow(char[][] image, int lo, int hi, boolean flag) { 
        int m = image.length, n = image[0].length; 
        while (lo < hi) { 
            int mid = lo + (hi - lo) / 2; 
            boolean hasBlack = false; 
            for (int j = 0; j < n; j++) { 
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