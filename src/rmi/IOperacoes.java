package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que é implementada pelo servidor da aplicação
 *
 * @author Bruno Vicelli
 * @author Matheus Dal Forno
 * @author Rafhael Rodrigues Cunha
 * @author Thiago Cassio Krug
 */
public interface IOperacoes extends Remote {

    /**
     * Faz o cálculo da soma de dois valores
     *
     * @param a
     * @param b
     * @return
     * @throws RemoteException
     */
    public double soma(double a, double b) throws RemoteException;

    /**
     * Faz o cálculo da subtração de dois valores
     *
     * @param a
     * @param b
     * @return
     * @throws RemoteException
     */
    public double subtrai(double a, double b) throws RemoteException;

    /**
     * Faz o cálculo da multiplicação de dois valores
     *
     * @param a
     * @param b
     * @return
     * @throws RemoteException
     */
    public double multiplica(double a, double b) throws RemoteException;

    /**
     * Faz o cálculo da divisão de dois valores
     *
     * @param a
     * @param b
     * @return
     * @throws RemoteException
     */
    public double divide(double a, double b) throws RemoteException;
}
