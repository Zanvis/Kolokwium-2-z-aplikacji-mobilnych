package vistula.ap.l11_piwowarski_62024_kol2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Imagesap extends AppCompatActivity {
    WriteReadToolsap writeReadToolsap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagesap);
        writeReadToolsap = new WriteReadToolsap();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        readInternalAtStartap();
    }
    public void readInternalAtStartap() {
        TextView txtAllap = (TextView) findViewById(R.id.txtFromMemoryap);

        String[] parts = writeReadToolsap.readInternal(this);

        if (parts != null && parts.length >= 3) {
            String allap = parts[0] + "\n" + parts[1] + "\n" + parts[2];
            txtAllap.setText(allap);
        }
    }
    public void moveToMainap(View view){
        Intent intentap = new Intent(this, MainActivity.class);
        startActivity(intentap);
    }
    public void moveToConverterap(View view){
        Intent intentap = new Intent(this, Converterap.class);
        startActivity(intentap);
    }
    public void moveToMemoryap(View view){
        Intent intentap = new Intent(this, Editap.class);
        startActivity(intentap);
    }
}