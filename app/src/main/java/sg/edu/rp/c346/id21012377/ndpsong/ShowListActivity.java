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
    CustomAdapter ca;
    ArrayList<Song> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        btn5Star = findViewById(R.id.btn5Star);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();

        ca = new CustomAdapter(this, R.layout.rows, al);
        lv.setAdapter(ca);

        DBHelper dbh = new DBHelper(ShowListActivity.this);
        al.clear();
        al.addAll(dbh.getAllSongs());
        ca.notifyDataSetChanged();

        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowListActivity.this);
                al.clear();
                int filterText = 5;
                al.addAll(dbh.get5Star(filterText));

                ca.notifyDataSetChanged();
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {


                Song data = al.get(position);
                Intent i = new Intent(ShowListActivity.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
        //to refresh list view after editing
        @Override
        protected void onResume() {
            super.onResume();
            DBHelper dbh = new DBHelper(ShowListActivity.this);
            al.clear();
            al.addAll(dbh.getAllSongs());
            ca.notifyDataSetChanged();
        }
    }
