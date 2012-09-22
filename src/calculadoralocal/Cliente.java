package calculadoralocal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;
import rmi.IOperacoes;

/**
 *
 * @author RafhaelRC
 */
public class Cliente {
    
    public static Logger logger = Logger.getLogger(Cliente.class);

    private IOperacoes operacoes;
    public static String URL = "rmi://127.0.0.1/Operacoes";

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

    public double area(double a, double b) throws RemoteException {
        return operacoes.multiplica(a, b);
    }

    public double perimetro(double a, double b) throws RemoteException {
        double metade = operacoes.soma(a, b);
        return operacoes.multiplica(2.0, metade);
    }
}
