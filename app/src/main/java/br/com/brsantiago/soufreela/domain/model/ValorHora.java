package br.com.brsantiago.soufreela.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by bruno.santiago on 13/10/2016.
 */

@DatabaseTable(tableName = "valor_hora")
public class ValorHora implements Parcelable {

    @DatabaseField(generatedId = true)
    public long id;
    @DatabaseField(columnName = "valor_mes")
    public Double valorMes;
    @DatabaseField(columnName = "hora_dia")
    public Integer horaDia;
    @DatabaseField(columnName = "dia_semana")
    public Integer diaSemana;
    @DatabaseField(columnName = "folga_semana")
    public Integer folgaSemana;
    @DatabaseField(columnName = "valor_dia")
    public Double valorDia;

    public ValorHora(){}

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
