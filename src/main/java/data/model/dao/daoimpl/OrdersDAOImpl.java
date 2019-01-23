package data.model.dao.daoimpl;

import data.model.dao.OrdersDAO;

import java.time.LocalDate;
import java.util.Collection;

public class OrdersDAOImpl implements OrdersDAO {
    //todo обязательно доделаю (почему тут так много кода?)
    public int insert(Order order) {
        return 0;
    }

    public boolean delete(Order order) {
        return false;
    }

    public Order findByID(int id) {
        return null;
    }

    public boolean update(Order order) {
        return false;
    }

    public boolean saveOrUpdate(Order order) {
        return false;
    }

    public Collection<Order> findByDate(LocalDate date) {
        return null;
    }

    public Collection<Order> findByOfficiant(Officiant officiant) {
        return null;
    }
}
