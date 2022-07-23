package sg.edu.rp.c346.id21012377.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView tvID,tvTitle, tvYear, tvSinger;
    EditText etID,etTitle,etYear, etSinger;
    RadioGroup rgStars;
    Button btnCancel, btnUpdate, btnDelete;
    Song info;
    RadioButton rbStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvID = findViewById(R.id.tvID);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvSinger = findViewById(R.id.tvSinger);
        etID = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.radio_group);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        //create variable to edit song info
        info = (Song) i.getSerializableExtra("info");

        etID.setFocusable(false);
        etID.setText(String.valueOf(info.getId()));
        etTitle.setText(info.getTitle());
        etSinger.setText(info.getSinger());
        etYear.setText(String.valueOf(info.getYear()));
        int selected = info.getStar();
        if(selected == 1){
            rbStar = findViewById(R.id.rb1);
            rbStar.setChecked(true);
        }else if(selected == 2){
            rbStar = findViewById(R.id.rb2);
            rbStar.setChecked(true);
        }else if(selected == 3){
            rbStar = findViewById(R.id.rb3);
            rbStar.setChecked(true);
        }else if(selected == 4){
            rbStar = findViewById(R.id.rb4);
            rbStar.setChecked(true);
        }else if(selected == 5){
            rbStar = findViewById(R.id.rb5);
            rbStar.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                info.setTitle(etTitle.getText().toString());
                info.setSinger(etSinger.getText().toString());
                info.setYear(Integer.parseInt(etYear.getText().toString()));
                int selected = rgStars.getCheckedRadioButtonId();
                rbStar = findViewById(selected);
                info.setStars(Integer.parseInt(rbStar.getText().toString()));
                dbh.updateSong(info);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(info.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}