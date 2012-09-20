package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author thiago
 */
public interface IOperacoes extends Remote {

    public double soma(double a, double b) throws RemoteException;

    public double subtrai(double a, double b) throws RemoteException;

    public double multiplica(double a, double b) throws RemoteException;

    public double divide(double a, double b) throws RemoteException;
}
