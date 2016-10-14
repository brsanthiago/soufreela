package br.com.brsantiago.soufreela.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by bruno.santiago on 13/10/2016.
 */

public class ValorHora implements Parcelable {

    public Double valorMes;
    public Integer horaDia;
    public Integer diaSemana;
    public Integer folgaSemana;
    public Double valorDia;

    protected ValorHora(Parcel in) {
        valorMes = in.readDouble();
        horaDia = in.readInt();
        diaSemana = in.readInt();
        folgaSemana = in.readInt();
        valorDia = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
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
