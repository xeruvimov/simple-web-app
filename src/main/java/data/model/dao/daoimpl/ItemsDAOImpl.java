package data.model.dao.daoimpl;

import data.model.dao.ItemsDAO;
import data.storage.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ItemsDAOImpl implements ItemsDAO {
    private static DataSource dataSource;

    public ItemsDAOImpl() {
        try {
            dataSource = DataSourceFactory.createDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(Item item) {
        String query = "insert into items values (?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getDescription());
            statement.setDouble(4, item.getCost());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Item item) {
        String query = "delete from items where id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, item.getId());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Item findByID(int id) {
        String query = "select * from items where id = ?";
        Item item = new Item();
        ResultSet result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            result = statement.executeQuery();
            result.next();
            item.setId(id);
            item.setName(result.getString("name"));
            item.setDescription(result.getString("description"));
            item.setCost(result.getDouble("cost"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception e) { /* ignored */ }
        }
        return item;
    }

    @Override
    public boolean update(Item item) {
        String query = "update items set name=?,description=?,cost=? where id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getCost());
            statement.setInt(4, item.getId());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveOrUpdate(Item item) {
        String query = "select * from items where id=?";
        ResultSet result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, item.getId());
            result = statement.executeQuery();
            if (result.next()) {
                return update(item);
            } else {
                return insert(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                result.close();
            } catch (Exception e) { /* ignored */ }
        }
    }

    @Override
    public Collection<Item> findByName(String name) {
        List<Item> list = new LinkedList<>();
        String query = "select * from items where name = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            getResult(list, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Collection<Item> findByCost(Double cost) {
        List<Item> list = new LinkedList<>();
        String query = "select * from items where cost = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, cost);
            getResult(list, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Collection<Item> getAll() {
        List<Item> list = new LinkedList<>();
        String query = "select * from items";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result =  statement.executeQuery(query)) {
            getResult(list, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void getResult(List<Item> list, PreparedStatement statement) throws SQLException {
        Item item;
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            item = new Item(result.getInt("id"), result.getString("name"),
                    result.getString("description"), result.getDouble("cost"));
            list.add(item);
        }
    }

    private void getResult(List<Item> list, ResultSet result) throws SQLException {
        Item item;
        while (result.next()) {
            item = new Item(result.getInt("id"), result.getString("name"),
                    result.getString("description"), result.getDouble("cost"));
            list.add(item);
        }
    }
}
