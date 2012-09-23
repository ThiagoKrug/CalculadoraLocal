package calculadoralocal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;
import rmi.IOperacoes;

/**
 * Classe que obtém a referência remota do objeto no servidor, e calcula a área
 * e o perímetro.
 *
 * @author Bruno Vicelli
 * @author Matheus Dal Forno
 * @author Rafhael Rodrigues Cunha
 * @author Thiago Cassio Krug
 */
public class Cliente {

    public static Logger logger = Logger.getLogger(Cliente.class);
    private IOperacoes operacoes;
    public static String URL = "rmi://127.0.0.1/Operacoes";

    /**
     * Método construtor da classe Cliente
     */
    public Cliente(String url) {
        if (!url.equalsIgnoreCase("")) {
            URL = url;
        }
        logger.info("URL do servidor " + URL);
    }

    /**
     * Inicia o cliente, que faz a vinculação do objeto remoto com a referência
     * do objeto local.
     */
    public void iniciar() {
        logger.info("Iniciando Cliente...");
        try {
            logger.info("Obtendo referência ao objeto remoto...");
            operacoes = (IOperacoes) Naming.lookup(URL);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            logger.fatal("Problema ao conectar no servidor!", e);
            System.exit(-1);
        }
    }

    /**
     * Calcula a área
     *
     * @param a
     * @param b
     * @return multiplicação de a por b.
     * @throws RemoteException
     */
    public double area(double a, double b) throws RemoteException {
        return operacoes.multiplica(a, b);
    }

    /**
     * Calcula o perímetro
     *
     * @param a
     * @param b
     * @return multiplicação de 2 x metade(a + b);
     * @throws RemoteException
     */
    public double perimetro(double a, double b) throws RemoteException {
        double metade = operacoes.soma(a, b);
        return operacoes.multiplica(2.0, metade);
    }
}
