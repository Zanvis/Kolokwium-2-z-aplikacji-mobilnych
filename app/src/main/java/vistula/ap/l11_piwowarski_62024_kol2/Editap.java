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

public class Editap extends AppCompatActivity {
    WriteReadToolsap writeReadToolsap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editap);

        writeReadToolsap = new WriteReadToolsap();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        readInternalAtStartap();
    }

    public void readInternalAtStartap() {
        TextView txtAllap = (TextView) findViewById(R.id.txtAll3ap);
        EditText editNameap = (EditText)findViewById(R.id.editName2ap);
        EditText editSurnameap = (EditText)findViewById(R.id.editSurname2ap);
        EditText editTownap = (EditText)findViewById(R.id.editTown2ap);

        String[] parts = writeReadToolsap.readInternal(this);

        if (parts != null && parts.length >= 3) {
            String allap = parts[0] + "\n" + parts[1] + "\n" + parts[2];
            txtAllap.setText(allap);
            editNameap.setText(parts[0]);
            editSurnameap.setText(parts[1]);
            editTownap.setText(parts[2]);
        }
    }

    public void moveToMainap(View view){
        Intent intentap = new Intent(this, MainActivity.class);
        startActivity(intentap);
    }

    public void writeInternalap(View view){
        EditText editNameap = (EditText)findViewById(R.id.editName2ap);
        EditText editSurnameap = (EditText)findViewById(R.id.editSurname2ap);
        EditText editTownap = (EditText)findViewById(R.id.editTown2ap);
        TextView txtAllap = (TextView) findViewById(R.id.txtAll3ap);

        writeReadToolsap.writeInternalap(this,
                editNameap.getText().toString(),
                editSurnameap.getText().toString(),
                editTownap.getText().toString());
        String[] parts = writeReadToolsap.readInternal(this);

        if (parts != null && parts.length >= 3) {
            String allap = parts[0] + "\n" + parts[1] + "\n" + parts[2];
            txtAllap.setText(allap);
        }
    }
}
