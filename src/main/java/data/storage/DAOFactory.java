package data.storage;

import data.model.dao.ItemsDAO;
import data.model.dao.OfficiantsDAO;
import data.model.dao.OrdersDAO;

public abstract class DAOFactory {

    private static DAOFactory instance;

    protected DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (instance == null) {
            instance = new SqlPerRequestDAOFactory();
        }
        return instance;
    }

    public abstract OrdersDAO getOrdersDAO();

    public abstract OfficiantsDAO geOfficiantsDAO();

    public abstract ItemsDAO getItemsDAO();

}
