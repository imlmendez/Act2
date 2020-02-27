package cat.udl.tidic.amb.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import cat.udl.tidic.amb.act2.models.EventModel;

public class EventActivity extends AppCompatActivity {

    private Button cancel;
    private Button confirmar;
    private EditText mnom;
    private EditText mdesc;
    private DatePicker eventDatePicker;
    private EventModel e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        cancel = findViewById(R.id.cancelEvent);
        confirmar = findViewById(R.id.CreateEvent);
        mnom = findViewById(R.id.nomEvent);
        mdesc = findViewById(R.id.DescripcioEvent);
        eventDatePicker = findViewById(R.id.datePicker_event);

        cancel.setOnClickListener(new View.OnClickListener(){

           @Override
            public void onClick(View v) {
               Intent i = new Intent();
               i.putExtra("decision","dec");
               setResult(1234,i);
               finish();
            }
        });

        confirmar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), confirmActivity.class);
                //e = new EventModel(mnom.getText().toString(),mdesc.getText().toString(),eventDatePicker.getYear(), eventDatePicker.getMonth(), eventDatePicker.getDayOfMonth() );

                intent.putExtra("nom", mnom.getText().toString());
                intent.putExtra("desc", mdesc.getText().toString());
                intent.putExtra("year", eventDatePicker.getYear());
                intent.putExtra("month", eventDatePicker.getMonth());
                intent.putExtra("day", eventDatePicker.getDayOfMonth());

                startActivityForResult(intent, 1234);


            }
        });


    }
    @Override protected void onActivityResult(int requestCode, int resultCode,
                                              Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234) {
            assert data.getExtras() != null;
            String decision = data.getExtras().getString("decision");
            assert decision != null;

            if (decision.equals("accepted")){
                Intent i = new Intent();
                i.putExtra("decision","accepted");
                setResult(1234,i);
                finish();
            }
        }


    }

}
