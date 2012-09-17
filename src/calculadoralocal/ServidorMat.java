/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralocal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author RafhaelRC
 */
public class ServidorMat extends UnicastRemoteObject implements InterfaceServidorMat
{
    public ServidorMat() throws RemoteException
    {
        System.out.println("Novo Servidor instanciado...");
    }
    public double soma(double a, double b) throws RemoteException
    {
        return a+b;
    }
    public double subtrai(double a, double b) throws RemoteException
    {
        return a-b;
    }
    public double multiplica(double a, double b) throws RemoteException
    {
        return a*b;
    }
    public double divide(double a, double b) throws RemoteException
    {
        return a/b;
    }
} 
