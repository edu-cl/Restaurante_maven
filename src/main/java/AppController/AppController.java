package AppController;

import com.restaurante_maven.Modelo.Repositorios.RepositoryClients;
import com.restaurante_maven.Modelo.Repositorios.RepositoryOrders;
import com.restaurante_maven.Modelo.Repositorios.RepositoryProduct;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class AppController {

    public RepositoryClients clients = RepositoryClients.instanceRepositoryClients();
    public RepositoryOrders orders = RepositoryOrders.getMiRepOrder();
    public RepositoryProduct product = new RepositoryProduct();

    public AppController() {
    }

   
}
