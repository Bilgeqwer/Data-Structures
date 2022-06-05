public class Recursive {
    public static void main(String[] args) {
        
      System.out.println(recursiveFactorial(5));
    }

    private static int recursiveFactorial(int n) {
        int x;
        if(n==1) return(1);
        else {
            x=n*recursiveFactorial(n-1);
            return x;
        }
        
    }
}
