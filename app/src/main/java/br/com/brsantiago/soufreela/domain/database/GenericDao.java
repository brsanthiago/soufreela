package br.com.brsantiago.soufreela.domain.database;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public abstract class GenericDao<E> extends DatabaseHelper<E> {

    protected Dao<E, Integer> dao;
    private Class<E> type;

    public GenericDao(Context context, Class<E> type) {
        super(context);
        this.type = type;
        setDao();
    }

    protected void setDao() {
        try {
            dao = DaoManager.createDao(getConnectionSource(), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<E> getAll() {
        try {
            List<E> result = dao.queryForAll();
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public E getById(int id) {
        try {
            E obj = dao.queryForId(id);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(E obj) {
        try {
            dao.create(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(E obj) {
        try {
            dao.delete(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(E obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}