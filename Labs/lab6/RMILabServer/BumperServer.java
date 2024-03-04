import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BumperServer {
    public static void main(String[] args) {
        try {
//            LocateRegistry.createRegistry(1099); // RMI registry on port 1099
            Bumper bumper = new BumperServant();
            Naming.rebind("bumper", bumper);
            System.out.println("Bumper Service is running...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
