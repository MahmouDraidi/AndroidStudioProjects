package com.draidi.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        WebView wv=((WebView)(findViewById(R.id.signUpPage)));
        wv.loadUrl("http://192.168.1.108/dashboard/loginPage.php");
        wv.getSettings().setJavaScriptEnabled(true);

        wv.setWebViewClient(new WebViewClient());
        //taking username that the previous activity sent
        Bundle data=getIntent().getExtras();
        String passedUname=data.getString("takenUsername");
        ((TextView)(findViewById(R.id.Welcome_Message))).setText("Hi "+passedUname);



    }

    public void goBack(View view){
        Intent i=new Intent(this,loginActivity.class);
        startActivity(i);
    }
}
