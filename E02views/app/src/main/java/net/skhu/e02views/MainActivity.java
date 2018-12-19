package net.skhu.e02views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //  화면 구성요소 내용을 화면에 불러와 채운다. ( 레이아웃에 따라 ) = layout inflation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_signUp) {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_memo) {
            Intent intent = new Intent(this, MemoActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_buttons){
            Intent intent = new Intent(this, ButtonsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_checkboxes){
            Intent intent = new Intent(this, CheckboxesActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_spinners) {
            Intent intent = new Intent(this, SpinnersActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_alerts) {
            Intent intent = new Intent(this, AlertsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
