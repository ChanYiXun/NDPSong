package sg.edu.rp.c346.id21012377.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvYear, tvSinger;
    EditText etTitle,etYear, etSinger;
    RadioGroup rgStars;
    Button btnInsert, btnSL;
    ArrayList<Song> al;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvSinger = findViewById(R.id.tvSinger);
        etTitle = findViewById(R.id.etTitle);
        etYear = findViewById(R.id.etYear);
        etSinger = findViewById(R.id.etSinger);
        rgStars = findViewById(R.id.radio_group);
        btnInsert = findViewById(R.id.btnUpdate);
        btnSL = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int starV = rgStars.getCheckedRadioButtonId();
                int stars = 0;

                if(starV == R.id.rb1){
                    stars = 1;
                }
                else if (starV == R.id.rb2){
                    stars = 2;
                }
                else if (starV == R.id.rb3){
                    stars = 3;
                }
                else if (starV == R.id.rb4){
                    stars = 4;
                }
                else if (starV == R.id.rb5){
                    stars = 5;
                }

                String titleAdd = etTitle.getText().toString();
                String singerAdd = etSinger.getText().toString();
                String yearAdd = etYear.getText().toString();


                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(titleAdd,singerAdd,stars,yearAdd);

            }
        });

        btnSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,
                       ShowListActivity.class);
                i.putExtra("al", al);
                startActivity(i);
            }
        });
    }


}