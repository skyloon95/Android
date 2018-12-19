package net.skhu.e201432014;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    StudentRecyclerAdapter recyclerAdapter;
    ArrayList<StudentData> arrayList;
    StudentAddFragment studentAddFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<StudentData>();
        recyclerAdapter = new StudentRecyclerAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);

        final EditText editText_studentNumber = findViewById(R.id.editText_studentNumber);
        final EditText editText_name = findViewById(R.id.editText_name);
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener((v -> {
            String number = editText_studentNumber.getText().toString();
            String name = editText_name.getText().toString();
            editText_name.setText("");
            editText_studentNumber.setText("");
            arrayList.add(new StudentData(number,name));
            recyclerAdapter.notifyDataSetChanged();
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_remove) {
            Log.d("삭제버튼 눌림여부", "눌림");
            for(int i = arrayList.size()-1 ; i>=0 ; i--)
                arrayList.remove(i);
            recyclerAdapter.notifyDataSetChanged();
            return true;
        }

        else if(id == R.id.action_add){
            Log.d("등록버튼 눌림여부", "눌림");
            showStudentAddDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showStudentAddDialog() {
        if (studentAddFragment == null) // 대화상자 관리자 객체를 아직 만들지 않았다면
            studentAddFragment = new StudentAddFragment(); // 대화상자 관리자 객체를 만든다
        studentAddFragment.show(getSupportFragmentManager(), "addDialog"); // 화면에 대화상자 보이기
    }

}
