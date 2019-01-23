package data.model.dao;

import data.model.dao.daoimpl.Item;

import java.util.Collection;

public interface ItemsDAO {
    boolean insert(Item item);

    boolean delete(Item item);

    Item findByID(int id);

    boolean update(Item item);

    boolean saveOrUpdate(Item item);

    Collection<Item> findByName(String name);

    Collection<Item> findByCost(Double cost);

    Collection<Item> getAll();
}
