package calculadoralocal;

import java.net.MalformedURLException;
import java.rmi.*;
import org.apache.log4j.Logger;
import rmi.IOperacoes;

/**
 * Classe Cliente
 * @author Rafhael Cunha, Matheus Dal Forno, Thiago Krug, Bruno Vicelli
 * 
 */
public class Cliente {
    
    public static Logger logger = Logger.getLogger(Cliente.class);

    private IOperacoes operacoes;
    public static String URL = "rmi://127.0.0.1/Operacoes";

    /**
     * Método Construtor da classe Cliente
     */
    public Cliente() {
        logger.info("Iniciando Cliente...");
        try {
            logger.info("Obtendo referência ao objeto remoto...");
            operacoes = (IOperacoes) Naming.lookup(URL);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            logger.fatal("Problema ao conectar no servidor!", e);
            System.exit(0);
        }
    }
    /**
     * Método area
     * @param a
     * @param b
     * @return multiplicação de a por b.
     * @throws RemoteException 
     */
    public double area(double a, double b) throws RemoteException {
        return operacoes.multiplica(a, b);
    }
    /**
     * Método perimetro
     * @param a
     * @param b
     * @return  multiplicação de 2 x  metade(a + b);
     * @throws RemoteException 
     */
    public double perimetro(double a, double b) throws RemoteException {
        double metade = operacoes.soma(a, b);
        return operacoes.multiplica(2.0, metade);
    }
}
