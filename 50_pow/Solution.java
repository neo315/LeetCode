// #50 pow(x, n)
// Implement pow(x, n).
// Tags: Math Binary Search
public class Solution {
   public static double pow(double x, int n) {
        if (n < 0) {
  return 1 / power(x, -n);
 } else {
  return power(x, n);
    }
} 
    public static double power(double x, int n) {
 if (n == 0)
  return 1;

 double v = power(x, n / 2);
 
 if (n % 2 == 0) {
  return v * v;
 } else {
  return v * v * x;
 }
}
    public static void main(String[] args)
    {
        
        int n = Integer.parseInt(args[1]);
        //int n = -2;
        double x = Double.parseDouble(args[0]);
        double result = pow(x, n);
        System.out.printf("%f ^ %d = %f\n", x, n, result);
    }
}