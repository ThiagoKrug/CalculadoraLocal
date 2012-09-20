package calculadoralocal;

import java.rmi.RemoteException;
import org.apache.log4j.Logger;

/**
 *
 * @author thiago
 */
public class Main {
    
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] argv) {
        Cliente c = new Cliente();
        try {
            logger.info("Cálculo da área: " + c.area(20.0, 40.0));
            logger.info("Cálculo do perímetro: " + c.perimetro(20.0, 40.0));
        } catch (RemoteException e) {
            logger.fatal("Ocorreu um problema durante as chamadas remotas!", e);
        }
    }
}
