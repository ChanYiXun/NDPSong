package sg.edu.rp.c346.id21012377.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvYear, tvSinger;
    EditText etTitle,etYear, etSinger;
    RadioGroup rgStars;
    Button btnInsert, btnSL;
    RadioButton rbStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvSinger = findViewById(R.id.tvSinger);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.radio_group);
        btnInsert = findViewById(R.id.btnUpdate);
        btnSL = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = etTitle.getText().toString();
                String Singer = etSinger.getText().toString();
                int Year = Integer.parseInt(etYear.getText().toString());
                int selected = rgStars.getCheckedRadioButtonId();
                rbStar = findViewById(selected);
                int Star = Integer.parseInt(rbStar.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(Title,Singer,Year,Star);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,
                       ShowListActivity.class);
                startActivity(i);
            }
        });
    }


}