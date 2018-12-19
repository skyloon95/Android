package net.skhu.d201432014;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        String[] stringArray = {"관리자", "사용자", "손님"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner_userType);
        spinner.setAdapter(adapter);

        View.OnClickListener btnOk_clicked = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                int index1 = spinner.getSelectedItemPosition();
                String s = spinner.getSelectedItem().toString();

                editText1.setText(s);
            }
        };
        Button btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(btnOk_clicked);

        RadioGroup.OnCheckedChangeListener group1_checked = new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                String s = radioButton.getText().toString();

                editText1.setText(s);
            }
        };
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(group1_checked);
    }
}
