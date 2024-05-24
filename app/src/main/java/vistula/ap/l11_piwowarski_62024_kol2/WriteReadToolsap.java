package vistula.ap.l11_piwowarski_62024_kol2;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WriteReadToolsap {
    String zapisap = "zapis.txt";

    public void writeInternalap(Context contextap, String editNameap, String editSurnameap, String editTownap){
        String[] userInfo = {
                editNameap,
                editSurnameap,
                editTownap
        };

        String strap = String.join(",", userInfo);

        try {
            FileOutputStream fOutap = contextap.openFileOutput(zapisap, Context.MODE_PRIVATE);
            OutputStreamWriter oswap = new OutputStreamWriter(fOutap);
            oswap.write(strap);
            oswap.flush();
            oswap.close();
        } catch (IOException e){
            Toast.makeText(contextap, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public String[] readInternal(Context contextap) {
        try {
            FileInputStream finap = contextap.openFileInput(zapisap);
            InputStreamReader israp = new InputStreamReader(finap);
            StringBuilder stringBuilder = new StringBuilder();
            char[] inputBufferap = new char[100];
            int charReadap;
            while ((charReadap = israp.read(inputBufferap)) > 0) {
                stringBuilder.append(inputBufferap, 0, charReadap);
            }
            String fullString = stringBuilder.toString();
            String[] parts = fullString.split(",", -1);

            if (parts.length >= 3) {
                return parts;
            } else {
                Toast.makeText(contextap, "Data format error", Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            Toast.makeText(contextap, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return null;
    }
}
