package mx.edu.itchetumal.dadm.rfc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button BtnLimpiar;
    Button BtnMostrar;
    EditText apellidoM;
    EditText apellidoP;
    EditText fecha;
    EditText nombre;
    EditText rfc;

    public String AdecuarCadena(String cadena) {
        String cadAdecu = cadena.toUpperCase().trim();
        String axu = BuildConfig.FLAVOR;
        char[] vocalesAcentuadas = new char[]{'Á', 'É', 'Í', 'Ó', 'Ú'};
        char[] vocales = new char[]{'A', 'E', 'I', 'O', 'U'};
        for (byte pos = (byte) 0; pos < vocalesAcentuadas.length; pos = (byte) (pos + 1)) {
            axu = cadAdecu.replace(vocalesAcentuadas[pos], vocales[pos]);
        }
        return axu;
    }

    public String Formatofecha(String cadena) {
        return cadena.replace("/", BuildConfig.FLAVOR);
    }

    public String ObtenerDatos(String nombre, String apellidoP, String apellidoM, String fecha) {
        String nombreAde = AdecuarCadena(nombre);
        String apellidoPAde = AdecuarCadena(apellidoP);
        String apellidoMAde = AdecuarCadena(apellidoM);
        String fechaAde = Formatofecha(fecha);
        String resultado = BuildConfig.FLAVOR;
        String Apep = apellidoPAde.substring(0, 2);
        String Apem = apellidoMAde.substring(0, 1);
        String name = nombreAde.substring(0, 1);
        String dia = fechaAde.substring(0, 2);
        String mes = fechaAde.substring(2, 4);
        String yea = fechaAde.substring(6, 8);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Apep);
        stringBuilder.append(Apem);
        stringBuilder.append(name);
        stringBuilder.append(yea);
        stringBuilder.append(mes);
        stringBuilder.append(dia);
        return stringBuilder.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombre = (EditText) findViewById(R.id.EditTextNombre);
        this.apellidoP = (EditText) findViewById(R.id.EditTextApellidoP);
        this.apellidoM = (EditText) findViewById(R.id.EditTextApellidoM);
        this.fecha = (EditText) findViewById(R.id.EditTextFecha);
        this.rfc = (EditText) findViewById(R.id.EditTextRfc);
        this.BtnMostrar = (Button) findViewById(R.id.ButtonMostrar);
        this.BtnLimpiar = (Button) findViewById(R.id.ButtonLimpiar);
        this.BtnLimpiar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.nombre.setText(" ");
                MainActivity.this.apellidoP.setText(" ");
                MainActivity.this.apellidoM.setText(" ");
                MainActivity.this.fecha.setText(" ");
                MainActivity.this.rfc.setText(" ");
            }
        });


        this.BtnMostrar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.rfc.setText(MainActivity.this.ObtenerDatos(MainActivity.this.nombre.getText().toString(), MainActivity.this.apellidoP.getText().toString(), MainActivity.this.apellidoM.getText().toString(), MainActivity.this.fecha.getText().toString()));
            }
        });


    }
}
