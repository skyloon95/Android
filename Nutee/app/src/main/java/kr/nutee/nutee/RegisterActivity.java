package kr.nutee.nutee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn_Register = (Button) findViewById(R.id.button_register);
        View.OnClickListener listener_Register = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText editText_inputId = (EditText)findViewById(R.id.editText_InputId);
                String loginId = editText_inputId.getText().toString();
                if(isEmptyOrWhiteSpace(loginId))
                    editText_inputId.setError("아이디를 입력하세요");

                EditText editText_inputNickname = (EditText)findViewById(R.id.editText_InputNickname);
                String nickname = editText_inputNickname.getText().toString();
                if(isEmptyOrWhiteSpace(nickname))
                    editText_inputNickname.setError("닉네임을 입력하세요");

                EditText editText_password = (EditText)findViewById(R.id.editText_PSW);
                String password = editText_password.getText().toString();
                if(isEmptyOrWhiteSpace(password))
                    editText_password.setError("비밀번호를 입력하세요");

                EditText editText_passwordCheck = (EditText)findViewById(R.id.editText_PSWCheck);
                String passwordCheck = editText_passwordCheck.getText().toString();
                if(isEmptyOrWhiteSpace(passwordCheck)||!isSame(password, passwordCheck))
                    editText_passwordCheck.setError("비밀번호를 확인해주세요");

                String msg_success = "회원가입 성공! ID : " + loginId + " // 닉네임 : " + nickname;
                Toast.makeText(RegisterActivity.this, msg_success, Toast.LENGTH_LONG).show();

            }
        };
        btn_Register.setOnClickListener(listener_Register);
    }
    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }

    static boolean isSame(String s1, String s2){
        if(s1.equals(s2))
            return true;
        else
            return false;
    }
}
