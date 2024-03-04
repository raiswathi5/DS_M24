import java.math.BigInteger;
import java.rmi.Naming;

public class BumperClient {
    public static void main(String[] args) {
        try {
            Bumper bumper = (Bumper) Naming.lookup("rmi://localhost/bumper");
            BigInteger ctr = BigInteger.ZERO;
            BigInteger n = BigInteger.valueOf(10000);

            long start = System.currentTimeMillis();

            while (ctr.compareTo(n) < 0) {
                bumper.bump();
                ctr = ctr.add(BigInteger.ONE);
            }

            long stop = System.currentTimeMillis();

            BigInteger serverCounter = bumper.get();
            System.out.println("Counter on server: " + serverCounter);
            System.out.println("Time taken (seconds): " + (stop - start) / 1000.0);
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
