package net.skhu.e04list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();
        arrayList.add("One");
        arrayList.add("Two");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        final EditText e = (EditText) findViewById(R.id.editText);
        Button b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener((v)->{
                CharSequence s = e.getText();
                e.setText("");
                arrayList.add(s.toString());
                adapter.notifyDataSetChanged();
            }
        );
    }
}
