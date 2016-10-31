package br.com.brsantiago.soufreela.view;

import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

import br.com.brsantiago.soufreela.R;

public class CalculaHoraActivity extends AppCompatActivity {

    private Button btnSave;

    private EditText edValorMes;
    private EditText edFolgaAno;
    private EditText edDiaSemana;
    private EditText edHoraDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_hora);

        btnSave = (Button) findViewById(R.id.btnSave);
        edValorMes = (EditText) findViewById(R.id.edValorMes);
        edFolgaAno = (EditText) findViewById(R.id.edFolgaAno);
        edDiaSemana = (EditText) findViewById(R.id.edDiaSemana);
        edHoraDia = (EditText) findViewById(R.id.edHoraDia);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaHora();
            }
        });

    }

    protected void calculaHora() {
        final Double qtdeMes = Double.parseDouble(edValorMes.getText().toString().replace(".","").replace(",","."));
        final Double horasPorDia = Double.parseDouble(edHoraDia.getText().toString().replace(".","").replace(",","."));
        final Double diasPorSemana = Double.parseDouble(edDiaSemana.getText().toString().replace(".","").replace(",","."));
        final Double horasPorSemana = horasPorDia * diasPorSemana;
        final Double horasPorAnoDeFolga = horasPorSemana * diasPorSemana;
        Double valorHoraFinal = qtdeMes * 12 / (53.1 * horasPorSemana - horasPorAnoDeFolga);

        valorHoraFinal += valorHoraFinal * 20 / 100;
        System.out.println("VALOR HORA: "+ valorHoraFinal);

        final DecimalFormat format = new DecimalFormat("##");

        Toast.makeText(this,
                format.format(valorHoraFinal),Toast.LENGTH_LONG).show();

    }
}
