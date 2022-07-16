package sg.edu.rp.c346.id21012377.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {
    Button btn5Star;
    ListView lv;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        btn5Star = findViewById(R.id.btn5Star);
        lv = findViewById(R.id.lv);

        ArrayList<Song> al = (ArrayList<Song>) getIntent().getSerializableExtra("al");

        aa= new ArrayAdapter<Song>(this,android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnClickListener(new  AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(EditActivity.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
}