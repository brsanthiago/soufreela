package br.com.brsantiago.soufreela.domain.service;

import android.content.Context;

import java.util.List;

import br.com.brsantiago.soufreela.domain.database.repository.ProjetoRepository;
import br.com.brsantiago.soufreela.domain.model.Projeto;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(final Context context) {
        this.repository = ProjetoRepository.getInstance(context);
    }


    public List<Projeto> getProjetos() {
        return repository.getAll();
    }
}
