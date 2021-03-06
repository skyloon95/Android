package net.skhu.d201432014;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnExam2_clicked(View button) {
        final EditText editText1 = findViewById(R.id.editText1);

        editText1.setText("");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.ok);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText1.setText("삭제");
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btnExam1_clicked(View button){
        Intent intent = new Intent(this, Exam1Activity.class);
        startActivity(intent);
    }
}
