package data.model.dao;

import data.model.dao.daoimpl.Officiant;

import java.util.Collection;

public interface OfficiantsDAO {
    int insert(Officiant officiant);

    boolean delete(Officiant officiant);

    Officiant findByID(int id);

    boolean update(Officiant officiant);

    boolean saveOrUpdate(Officiant o);

    Collection<Officiant> findByName(String firstName, String secondName);
}
