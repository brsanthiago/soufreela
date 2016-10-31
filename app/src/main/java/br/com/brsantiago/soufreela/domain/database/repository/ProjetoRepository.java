package br.com.brsantiago.soufreela.domain.database.repository;

import android.content.Context;

import br.com.brsantiago.soufreela.domain.database.dao.GenericDao;
import br.com.brsantiago.soufreela.domain.model.Projeto;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class ProjetoRepository extends GenericDao<Projeto> {
    private static ProjetoRepository dao;

    public static ProjetoRepository getInstance(Context ctx) {
        if (dao == null) {
            dao = new ProjetoRepository(ctx);
        }
        return dao;
    }

    public ProjetoRepository(Context context) {
        super(context, Projeto.class);
    }
}
