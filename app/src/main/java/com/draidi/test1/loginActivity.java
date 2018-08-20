package com.draidi.test1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        TextView signUp=(TextView)(findViewById(R.id.signUp));
        TextView resPW=(TextView)(findViewById(R.id.forgotPW));



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent signUpLink=new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.1.108/dashboard/main.php"));
                startActivity(signUpLink);*/
               openProducts();

            }
        }
        );

        signUp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(view.getContext(),"Thats fookin long press!",Toast.LENGTH_SHORT).show();
                ((Button) findViewById(R.id.loginButton)).setBackgroundColor(Color.rgb(0,188,212));
                ((Button) findViewById(R.id.loginButton)).setTextColor(Color.rgb(255,255,255));
                return true;
            }
        });
        resPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResetPwActivity();
            }
        });

    }

    public void check(View v){
        TextView userInp=(TextView)(findViewById(R.id.usernameInp));
        TextView userPw=(TextView)(findViewById(R.id.pwInp));

        String uname=userInp.getText().toString();
       String pw=userPw.getText().toString();
       MyAsyncTaskresources db=new MyAsyncTaskresources(this);
       db.execute(uname,pw);

openTakePhoto();
       // Toast.makeText(v.getContext(),"Hey there!",Toast.LENGTH_SHORT).show();
        //openSecActivity();

    }
    public void openTakePhoto(){
        Toast.makeText(this,"HelloOoOo",Toast.LENGTH_SHORT);
        Intent i=new Intent(this,take_photo.class);
        startActivity(i);
    }
    public void openSecActivity( ){
        String takenUname=((TextView)(findViewById(R.id.usernameInp))).getText().toString();
        Intent i=new Intent(this,secondActivity.class);
        i.putExtra("takenUsername",takenUname);
        startActivity(i);
    }
    public void openResetPwActivity(){
        Intent i=new Intent(this,Resetpw.class);
        startActivity(i);
    }
    public void openProducts(){
        Intent i=new Intent(this,products.class);
        startActivity(i);
    }


    String result = "";
    String line="";
    public class MyAsyncTaskresources extends AsyncTask<String, String, String> {
        Context context;
        AlertDialog al_diag;

        public MyAsyncTaskresources(Context context) {
            this.context=context;
        }

        @Override
        protected void onPreExecute() {
            al_diag=new AlertDialog.Builder(context).create();
            al_diag.setTitle("Login result");

        }
        @Override
        protected String  doInBackground(String... params) {


            InputStream isr = null;
            String username=params[0];
            String password=params[1];
            String phpConn="http://192.168.1.108/db.php";

            try{

                URL url = new URL(phpConn);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
               // isr  = new BufferedInputStream(urlConnection.getInputStream());
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                OutputStream ops=urlConnection.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                ops.close();

                InputStream ips=urlConnection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
                while ((line=reader.readLine())!=null){

                    result=line;
                }
                reader.close();
                urlConnection.disconnect();
                ips.close();
              //  Toast.makeText(context,result,Toast.LENGTH_LONG).show();
                return result;

            }

            catch(Exception e){

                Log.e("log_tag", "Error in http connection " + e.toString());



            }

return null;
        }

        protected void onPostExecute(String  s){

          //  al_diag.setMessage(s);
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            //openTakePhoto();

            //al_diag.show();
            //Toast.makeText(context,result,Toast.LENGTH_LONG).show();
           /* try {

                String s = "";

                JSONArray jArray = new JSONArray(result);

                for (int i = 0; i < jArray.length(); i++) {

                    JSONObject json = jArray.getJSONObject(i);

                    s = s + "login info : " + json.getString("id") + " " + json.getString("username") + " " + json.getString("password");
                    break;}
                if(s.length()>0){
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    Intent in=new Intent(getApplicationContext(),secondActivity.class);
                    startActivity(in);}
                else
                    Toast.makeText(getApplicationContext(),"user name or password isnot correct",Toast.LENGTH_LONG).show();


            } catch (Exception e) {

// TODO: handle exception

                Log.e("log_tag", "Error Parsing Data "+e.toString());

            }*/
        }




    }

}
