package br.com.brsantiago.soufreela.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by bruno.santiago on 13/10/2016.
 */

public class Projeto implements Parcelable {

    public long id;
    public String nome;
    public Date dataInicial;
    public Date dataFinal;
    public Integer horaDia;
    public Integer qtdeDia;
    public Double valorProjeto;
    public ValorHora valorHora;

    protected Projeto(Parcel in) {
        id = in.readLong();
        nome = in.readString();
        horaDia = in.readInt();
        qtdeDia = in.readInt();
        dataInicial = (Date) in.readSerializable();
        dataFinal = (Date) in.readSerializable();
        valorProjeto = in.readDouble();
        valorHora = in.readParcelable(ValorHora.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nome);
        dest.writeInt(horaDia);
        dest.writeInt(qtdeDia);
        dest.writeSerializable(dataInicial);
        dest.writeSerializable(dataFinal);
        dest.writeDouble(valorProjeto);
        dest.writeParcelable(valorHora, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Projeto> CREATOR = new Creator<Projeto>() {
        @Override
        public Projeto createFromParcel(Parcel in) {
            return new Projeto(in);
        }

        @Override
        public Projeto[] newArray(int size) {
            return new Projeto[size];
        }
    };
}
