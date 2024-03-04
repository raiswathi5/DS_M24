import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BumperServant extends UnicastRemoteObject implements Bumper {
    private BigInteger counter;

    protected BumperServant() throws RemoteException {
        super();
        counter = BigInteger.ZERO;
    }

    @Override
    public boolean bump() throws RemoteException {
        counter = counter.add(BigInteger.ONE);
        return true;
    }

    @Override
    public BigInteger get() throws RemoteException {
        return counter;
    }
}
