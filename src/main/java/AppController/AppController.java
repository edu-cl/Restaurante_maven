package AppController;

import com.restaurante_maven.Modelo.Repositorios.MainMenuController;
import com.restaurante_maven.Modelo.Repositorios.OrderMenuController;
import com.restaurante_maven.Modelo.Repositorios.RepositoryChart;
import com.restaurante_maven.Modelo.Repositorios.RepositoryClients;
import com.restaurante_maven.Modelo.Repositorios.RepositoryOrders;
import com.restaurante_maven.Modelo.Repositorios.RepositoryProduct;


public  class AppController {

    public RepositoryClients clients = RepositoryClients.instanceRepositoryClients();
    public RepositoryOrders orders = RepositoryOrders.getMiRepOrder();
    public RepositoryProduct product = new RepositoryProduct();
    public OrderMenuController OrdenMenu=new OrderMenuController();
    public MainMenuController MenuFunction=new MainMenuController();
    public RepositoryChart carrito=RepositoryChart.instanceReposirotyChart();

    public AppController() {
    }

   
}
