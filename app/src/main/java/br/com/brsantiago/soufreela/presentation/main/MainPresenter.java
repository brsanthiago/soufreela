package br.com.brsantiago.soufreela.presentation.main;

import java.util.List;

import br.com.brsantiago.soufreela.domain.model.Projeto;
import br.com.brsantiago.soufreela.domain.service.ProjetoService;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private ProjetoService service;
    private List<Projeto> projetoAggregation;

    public MainPresenter(ProjetoService service) {
        this.service = service;
    }

    @Override
    public List<Projeto> onSaveInstanceState() {
        return projetoAggregation;
    }

    @Override
    public void onLoadInstanceState(List<Projeto> projetoAggregation) {
        this.projetoAggregation = projetoAggregation;

    }

    @Override
    public void loadLista() {
        view.showLoadingLayout();
        projetoAggregation = service.getProjetos();
        if (projetoAggregation != null) {
            refreshUi();
        } else {
            view.showEmptyLayout();
        }
    }

    @Override
    public void refreshUi() {
        if (!projetoAggregation.isEmpty()) {
            view.showSuccessLayout();
            view.setUpLista(projetoAggregation);
        } else {
            view.showEmptyLayout();
        }
    }

    @Override
    public void retryLista() {
        loadLista();
    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }
}
