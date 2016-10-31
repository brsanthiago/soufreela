package br.com.brsantiago.soufreela.domain.database.repository;

import android.content.Context;

import br.com.brsantiago.soufreela.domain.model.ValorHora;
import br.com.brsantiago.soufreela.domain.database.dao.GenericDao;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class ValorHoraRepository extends GenericDao<ValorHora> {
    private static ValorHoraRepository dao;

    public static ValorHoraRepository getInstance(Context ctx) {
        if (dao == null) {
            dao = new ValorHoraRepository(ctx);
        }
        return dao;
    }

    public ValorHoraRepository(Context context) {
        super(context, ValorHora.class);
    }
}
