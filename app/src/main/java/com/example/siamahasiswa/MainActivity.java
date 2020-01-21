package com.example.siamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_logout;
    TextView txt_id, txt_nim;
    String id, nim;
    SharedPreferences sharedpreferences;

    //public static final String TAG_ID = "id";
    public static final String TAG_NIM = "nim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txt_id = (TextView) findViewById(R.id.txt_id);
        txt_nim = (TextView) findViewById(R.id.txt_username);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        sharedpreferences = getSharedPreferences(Mylogin.my_shared_preferences, Context.MODE_PRIVATE);

        //id = getIntent().getStringExtra(TAG_ID);
        nim = getIntent().getStringExtra(TAG_NIM);

        //txt_id.setText("ID : " + id);
        txt_nim.setText("NIM : " + nim);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(Mylogin.session_status, false);
                //editor.putString(TAG_ID, null);
                editor.putString(TAG_NIM, null);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, Mylogin.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
