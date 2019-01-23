package data.model.dao.daoimpl;

import data.model.dao.OfficiantsDAO;

import java.util.Collection;

public class OfficiantsDAOImpl implements OfficiantsDAO {
    //todo обязательно доделаю (почему тут так много кода?)
    public int insert(Officiant officiant) {
        return 0;
    }

    public boolean delete(Officiant officiant) {
        return false;
    }

    public Officiant findByID(int id) {
        return null;
    }

    public boolean update(Officiant officiant) {
        return false;
    }

    public boolean saveOrUpdate(Officiant o) {
        return false;
    }

    public Collection<Officiant> findByName(String firstName, String secondName) {
        return null;
    }
}
