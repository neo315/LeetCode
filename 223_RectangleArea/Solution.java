// # 223 Rectangle Area 
//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//Rectangle Area
//Assume that the total area is never beyond the maximum possible value of int.
//    
//Tags: Math

public class Solution { 
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) { 
         
        if (C <= E || A >= G || B >= H || D <= F) return (C - A) * (D - B) + (G - E) * (H - F); 
        int height = 0; 
        int width = 0; 
         
        if (B > F && B < H)  
        { 
            if (D < H) height = D - B; 
            else height = H - B; 
        } 
        else if (D > F && D < H) 
        { 
            if (B > F) height = D - B; 
            else height = D - F; 
        } 
        else height = H - F; 
         
        if (A > E && A < G) 
        { 
            if (C < G) width = C - A; 
            else width = G - A; 
        } 
        else if (C > E && C < G) 
        { 
            if (A > E) width = C - A; 
            else width = C - E; 
        } 
        else width = G - E; 
         
        return (C - A) * (D - B) + (G - E) * (H - F) - height * width; 
    } 
}