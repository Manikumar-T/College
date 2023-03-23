public class Euclidean {
    public static int gcd(int divident, int divider) {
        if(divider==1)
            return 1;
        if(divider==0)
            return divident;
        return gcd((divider),(divident%divider));
        
    }
}
