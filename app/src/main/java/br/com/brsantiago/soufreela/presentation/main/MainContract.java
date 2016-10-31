package br.com.brsantiago.soufreela.presentation.main;

import java.util.List;

import br.com.brsantiago.soufreela.domain.model.Projeto;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class MainContract {
    public interface View {
        void setUpLista(List<Projeto> projetos);

        void showLoadingLayout();

        void showSuccessLayout();

        void showEmptyLayout();
    }

    public interface Presenter {
        List<Projeto> onSaveInstanceState();

        void onLoadInstanceState(List<Projeto> projetoAggregation);

        void loadLista();

        void refreshUi();

        void retryLista();

        void setView(MainContract.View view);
    }
}
