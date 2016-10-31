package br.com.brsantiago.soufreela.domain.database.repository;

import android.content.Context;

import br.com.brsantiago.soufreela.domain.model.ValorHora;
import br.com.brsantiago.soufreela.domain.database.dao.GenericDao;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class ValorHoraDAO extends GenericDao<ValorHora> {
    private static ValorHoraDAO dao;

    public static ValorHoraDAO getInstance(Context ctx) {
        if (dao == null) {
            dao = new ValorHoraDAO(ctx);
        }
        return dao;
    }

    public ValorHoraDAO(Context context) {
        super(context, ValorHora.class);
    }
}
