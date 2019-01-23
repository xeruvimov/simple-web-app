package data.storage;

import data.model.dao.ItemsDAO;
import data.model.dao.OfficiantsDAO;
import data.model.dao.OrdersDAO;
import data.model.dao.daoimpl.ItemsDAOImpl;
import data.model.dao.daoimpl.OfficiantsDAOImpl;
import data.model.dao.daoimpl.OrdersDAOImpl;

public class SqlPerRequestDAOFactory extends DAOFactory {
    public OrdersDAO getOrdersDAO() {
        return new OrdersDAOImpl();
    }

    public OfficiantsDAO geOfficiantsDAO() {
        return new OfficiantsDAOImpl();
    }

    public ItemsDAO getItemsDAO() {
        return new ItemsDAOImpl();
    }
}
