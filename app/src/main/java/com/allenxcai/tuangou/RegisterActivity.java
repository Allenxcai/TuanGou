package com.allenxcai.tuangou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText mEdtUserName;
    private EditText mEdtdUserPwd;
    private Button mBtnRegister;

    private String UserName;
    private String UserPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEdtUserName = findViewById(R.id.register_edt_username);
        mEdtdUserPwd = findViewById(R.id.register_edt_password);
        mBtnRegister = findViewById(R.id.register_btn_register);


        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                //Toast.makeText(RegisterActivity.this,R.string.action_register,Toast.LENGTH_SHORT).show();
                UserName = mEdtUserName.getText().toString();
                UserPwd = mEdtdUserPwd.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("userName", UserName);
                intent.putExtra("userPwd", UserPwd);
                if ((UserName.length() == 0) || (UserPwd.length() == 0))
                    setResult(RESULT_CANCELED, intent);
                else setResult(RESULT_OK, intent);

                finish();


            }
        });
    }


}
