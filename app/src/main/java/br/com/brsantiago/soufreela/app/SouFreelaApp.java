package br.com.brsantiago.soufreela.app;

import android.app.Application;

import java.util.Date;

import br.com.brsantiago.soufreela.domain.database.helper.DatabaseManager;
import br.com.brsantiago.soufreela.domain.database.repository.ProjetoRepository;
import br.com.brsantiago.soufreela.domain.model.Projeto;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class SouFreelaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(this);

        create();
    }

    protected void create(){
        Projeto projeto = new Projeto();
        projeto.id = 1;
        projeto.nome = "Teste";
        projeto.dataInicial = new Date();
        projeto.dataFinal = new Date();
        projeto.horaDia = 4;
        projeto.qtdeDia = 45;
        projeto.valorProjeto = 7500.;
        projeto.valorHora = 50.;

        ProjetoRepository repository = ProjetoRepository.getInstance(this);
        repository.saveOrUpdate(projeto);

    }
}
