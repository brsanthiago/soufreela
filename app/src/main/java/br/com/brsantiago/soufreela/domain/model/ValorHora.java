package br.com.brsantiago.soufreela.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bruno.santiago on 13/10/2016.
 */

public class ValorHora implements Parcelable {

    public long id;
    public Double valorMes;
    public Integer horaDia;
    public Integer diaSemana;
    public Integer folgaSemana;
    public Double valorDia;

    public ValorHora(){};

    protected ValorHora(Parcel in) {
        id = in.readLong();
        valorMes = in.readDouble();
        horaDia = in.readInt();
        diaSemana = in.readInt();
        folgaSemana = in.readInt();
        valorDia = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeDouble(valorMes);
        dest.writeInt(horaDia);
        dest.writeInt(diaSemana);
        dest.writeInt(folgaSemana);
        dest.writeDouble(valorDia);
    }

    public static final Creator<ValorHora> CREATOR = new Creator<ValorHora>() {
        @Override
        public ValorHora createFromParcel(Parcel in) {
            return new ValorHora(in);
        }

        @Override
        public ValorHora[] newArray(int size) {
            return new ValorHora[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
