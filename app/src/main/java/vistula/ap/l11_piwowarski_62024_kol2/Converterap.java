package vistula.ap.l11_piwowarski_62024_kol2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converterap extends AppCompatActivity {
    WriteReadToolsap writeReadToolsap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_converterap);
        writeReadToolsap = new WriteReadToolsap();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        readInternalAtStartap();
    }
    public void readInternalAtStartap() {
        TextView txtAllap = (TextView) findViewById(R.id.txtAll2ap);

        String[] parts = writeReadToolsap.readInternal(this);

        if (parts != null && parts.length >= 3) {
            String allap = parts[0] + "\n" + parts[1] + "\n" + parts[2];
            txtAllap.setText(allap);
        }
    }
    public void Convertap(View view){
        EditText tempap = (EditText) findViewById(R.id.editTempap);
        String tempStringap = tempap.getText().toString();
        double tempNumberap;

        try {
            tempNumberap = Double.parseDouble(tempStringap);
        } catch (NumberFormatException e) {
            tempNumberap = 0;
        }

        TextView txtcelpap = (TextView) findViewById(R.id.txtCelsiusap);
        TextView txtfahap = (TextView) findViewById(R.id.txtFahrenheitap);
        TextView txtkelap = (TextView) findViewById(R.id.txtKelvinap);
        Spinner spinnerTempap = (Spinner) findViewById(R.id.spinnerTempap);
        String tempChoiceap = spinnerTempap.getSelectedItem().toString().toUpperCase();

        txtcelpap.setText(String.format("%.2f", ConverterToolsap.convertTemperatureap(tempNumberap, tempChoiceap, "CELSIUS")));
        txtfahap.setText(String.format("%.2f", ConverterToolsap.convertTemperatureap(tempNumberap, tempChoiceap, "FAHRENHEIT")));
        txtkelap.setText(String.format("%.2f", ConverterToolsap.convertTemperatureap(tempNumberap, tempChoiceap, "KELVIN")));
    }
    public void moveToMainap(View view){
        Intent intentap = new Intent(this, MainActivity.class);
        startActivity(intentap);
    }
}