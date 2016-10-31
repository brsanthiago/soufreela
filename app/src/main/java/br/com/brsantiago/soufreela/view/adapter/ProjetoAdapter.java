package br.com.brsantiago.soufreela.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.soufreela.R;
import br.com.brsantiago.soufreela.domain.model.Projeto;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.santiago on 31/10/2016.
 */

public class ProjetoAdapter  extends RecyclerView.Adapter<ProjetoAdapter.ProjetoViewHolder> {
    private List<Projeto> mLista = new ArrayList<>();
    private Context context;

    public ProjetoAdapter(Context context, List<Projeto> lista) {
        this.mLista = lista;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(ProjetoViewHolder holder, int position) {
        Projeto projeto = mLista.get(position);

        if (projeto != null) {
            holder.tvId.setText(projeto.nome);
        }
    }

    @Override
    public ProjetoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_projeto, parent, false);
        ProjetoViewHolder viewHolder = new ProjetoViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class ProjetoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tvNome)
        TextView tvId;

        public ProjetoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }
    }

}
