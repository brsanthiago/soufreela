package br.com.brsantiago.soufreela.domain.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.HashMap;
import java.util.Map;

import br.com.brsantiago.soufreela.domain.model.Projeto;
import br.com.brsantiago.soufreela.domain.model.ValorHora;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class DatabaseHelper<E> extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "sou.freela";
    private static final int DATABASE_VERSION = 1;
    private Map<Class, Dao<Parcelable, Object>> daos = new HashMap<>();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource src) {
        try {
            TableUtils.createTable(src, ValorHora.class);
            TableUtils.createTable(src, Projeto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource src, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(src, ValorHora.class, true);
            TableUtils.dropTable(src, Projeto.class, true);
            onCreate(db, src);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
