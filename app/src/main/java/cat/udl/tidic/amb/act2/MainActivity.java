package cat.udl.tidic.amb.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private TextView contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.buttonCrear);
        contador = findViewById(R.id.numEventos);
        startButton.setOnClickListener(new View.OnClickListener(){

               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getApplicationContext(), EventActivity.class);
                   startActivityForResult(intent,1234);
               }
           }

        );
    }

    @Override protected void onActivityResult(int requestCode, int resultCode,
                                              Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234) {
            assert data.getExtras() != null;
            String decision = data.getExtras().getString("decision");
            assert decision != null;

            if (decision.equals("accepted")){
                updateContador();
            }
        }


    }
    protected void updateContador(){
        String resultado = contador.getText().toString() ;
        int num = Integer.parseInt(resultado) + 1;
        contador.setText("" +num );
    }
}
