package AppController;

import com.restaurante_maven.Modelo.Repositorios.RepositoryClients;
import com.restaurante_maven.Modelo.Repositorios.RepositoryOrders;
import com.restaurante_maven.Modelo.Repositorios.RepositoryProduct;

public class AppController {

    public RepositoryClients clients = RepositoryClients.instanceRepositoryClients();
    public RepositoryOrders orders = RepositoryOrders.getMiRepOrder();
    public RepositoryProduct product = new RepositoryProduct();

    public AppController() {
    }

    public boolean loadClients() {
        boolean result = false;

        return result;
    }

    public boolean saveClients() {
        boolean result = false;

        return result;
    }

    public boolean loadOrdersClients() {
        boolean result = false;

        return result;
    }

    public boolean saveOrders() {
        boolean result = false;

        return result;
    }
    
}
