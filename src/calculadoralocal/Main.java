package calculadoralocal;

import java.rmi.RemoteException;
import org.apache.log4j.Logger;

/**
 * Inicia o cliente
 *
 * @author Bruno Vicelli
 * @author Matheus Dal Forno
 * @author Rafhael Rodrigues Cunha
 * @author Thiago Cassio Krug
 */
public class Main {

    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println(args);
        String url = "";
        if (args != null && args.length >= 1) {
            url = args[0];
        }
        
        Cliente c = new Cliente(url);
        c.iniciar();
        try {
            logger.info("Cálculo da área: " + c.area(20.0, 40.0));
            logger.info("Cálculo do perímetro: " + c.perimetro(20.0, 40.0));
        } catch (RemoteException e) {
            logger.fatal("Ocorreu um problema durante as chamadas remotas!", e);
        }
    }
}
