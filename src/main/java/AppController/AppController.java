package AppController;

import com.restaurante_maven.Modelo.Repositorios.MainMenuController;
import com.restaurante_maven.Modelo.Repositorios.OrderMenuController;
import com.restaurante_maven.Modelo.Repositorios.RepositoryChart;
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
    public OrderMenuController OrdenMenu=new OrderMenuController();
    public MainMenuController MenuFunction=new MainMenuController();
    public RepositoryChart carrito=RepositoryChart.getGetInstance();

    public AppController() {
    }

   
}
