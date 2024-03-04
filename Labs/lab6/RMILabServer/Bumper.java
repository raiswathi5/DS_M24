//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.BigInteger;

public interface Bumper extends Remote {
    boolean bump() throws RemoteException;
    BigInteger get() throws RemoteException;
}
