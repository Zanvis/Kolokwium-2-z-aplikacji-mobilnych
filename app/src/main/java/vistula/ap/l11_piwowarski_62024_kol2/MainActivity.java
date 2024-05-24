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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String zapisap = "zapis.txt";
    WriteReadToolsap writeReadToolsap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        writeReadToolsap = new WriteReadToolsap();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        readInternalAtStartap();
    }
    public void moveToImagesap(View view){
        Intent intentap = new Intent(this, Imagesap.class);
        startActivity(intentap);
    }
    public void writeInternalap(View view){
        EditText editNameap = (EditText)findViewById(R.id.editNameap);
        EditText editSurnameap = (EditText)findViewById(R.id.editSurnameap);
        Spinner spinnerTownap = (Spinner) findViewById(R.id.spinnerTownap);
        String townap = spinnerTownap.getSelectedItem().toString();

        writeReadToolsap.writeInternalap(this,
                editNameap.getText().toString(),
                editSurnameap.getText().toString(),
                townap);
    }
    public void readInternalAtStartap() {
        TextView txtAllap = (TextView) findViewById(R.id.txtAllap);

        String[] parts = writeReadToolsap.readInternal(this);

        if (parts != null && parts.length >= 3) {
            String allap = parts[0] + "\n" + parts[1] + "\n" + parts[2];
            txtAllap.setText(allap);
        }
    }
}