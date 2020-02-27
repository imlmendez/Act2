package cat.udl.tidic.amb.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.tidic.amb.act2.presenter.EventPresenter;

public class confirmActivity extends AppCompatActivity implements EventViewActions{

    private TextView resultado;
    private Button cancel;
    private Button confirma;

    private EventPresenter ep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        resultado = findViewById(R.id.eventoCompletado);
        confirma = findViewById(R.id.confirmarEvento);
        cancel = findViewById(R.id.cancelConfirmacion);
        ep = new EventPresenter(this);


        Bundle extras = getIntent().getExtras();
        assert extras != null;
        String mnom = extras.getString("nom");
        String mdesc = extras.getString("desc");
        int myear = extras.getInt("year");
        int mmonth = extras.getInt("month");
        int mday = extras.getInt("day");

        ep.setEvent(mnom,mdesc,myear,mmonth,mday);
        ep.getEvent();

        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("decision","rejected");
                setResult(1234,i);
                finish();
            }
        });

        confirma.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("decision","accepted");
                setResult(1234,i);
                finish();
            }
        });


    }

    @Override
    public void updateUI(String message) {
        Log.d("evento",message);
        resultado.setText(message);

    }
}
