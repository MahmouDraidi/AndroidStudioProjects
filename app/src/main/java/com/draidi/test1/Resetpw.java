package com.draidi.test1;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resetpw extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
        case R.id.add:
           /* if(item.isChecked()==true)
                item.setChecked(false);
            else item.setChecked(true);*/
            ((TextView)(findViewById(R.id.textView2))).setTextColor(Color.BLACK);
            return true;
            case R.id.profile:
                if(item.isChecked()==true)
                    item.setChecked(false);
                else item.setChecked(true);
                ((TextView)(findViewById(R.id.textView2))).setTextColor(Color.RED);
                return true;
            case R.id.myProducts:
                if(item.isChecked()==true)
                    item.setChecked(false);
                else item.setChecked(true);
                ((TextView)(findViewById(R.id.textView2))).setTextColor(Color.GREEN);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpw);

        Button next=(Button)(findViewById(R.id.nextButton1));
        Button next1=(Button)(findViewById(R.id.next2));
        Button update=(Button)(findViewById(R.id.update));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em=((TextView)(findViewById(R.id.emailText))).getText().toString();
                if(em.equals("mahmoud.draidi")) {
                    ((ConstraintLayout) (findViewById(R.id.firstLayout))).setVisibility(View.INVISIBLE);
                    ((ConstraintLayout) (findViewById(R.id.secondLayout))).setVisibility(View.VISIBLE);
                }
            }

        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ver_code=((TextView)(findViewById(R.id.verCodeText))).getText().toString();
                if(ver_code.equals("123321")){
                ((ConstraintLayout)(findViewById(R.id.thirdLayout))).setVisibility(View.VISIBLE);
                ((ConstraintLayout)(findViewById(R.id.secondLayout))).setVisibility(View.INVISIBLE);
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });


    }
    public void openLoginActivity(){
        Intent i=new Intent(this,loginActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
