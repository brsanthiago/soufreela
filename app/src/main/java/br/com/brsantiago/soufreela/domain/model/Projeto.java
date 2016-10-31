package br.com.brsantiago.soufreela.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by bruno.santiago on 13/10/2016.
 */

@DatabaseTable(tableName = "projeto")
public class Projeto implements Parcelable {

    @DatabaseField(generatedId = true)
    public long id;
    @DatabaseField
    public String nome;
    @DatabaseField
    public Date dataInicial;
    @DatabaseField
    public Date dataFinal;
    @DatabaseField
    public Integer horaDia;
    @DatabaseField
    public Integer qtdeDia;
    @DatabaseField
    public Double valorProjeto;
    @DatabaseField
    public Double valorHora;

    public Projeto(){}

    protected Projeto(Parcel in) {
        id = in.readLong();
        nome = in.readString();
        horaDia = in.readInt();
        qtdeDia = in.readInt();
        dataInicial = (Date) in.readSerializable();
        dataFinal = (Date) in.readSerializable();
        valorProjeto = in.readDouble();
        valorHora = in.readDouble();
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
        dest.writeDouble(valorHora);
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

    @Override
    public String toString() {
        return "Projeto Name: "+ nome;
    }
}
