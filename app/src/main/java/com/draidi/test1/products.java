package com.draidi.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);
       // ArrayList<prod_class> products=new ArrayList<prod_class>();
        prod_class item1=new prod_class(1, "Canon", "mahmoud", "Cameras","3", "idk", "2850$", "ca3.jpg", " ", " ", "34", "1/6/2018");
        prod_class item2=new prod_class(2, "BMW", "bassam", "Vehicles","1", "idk", "50k$", "l3.jpg", " ", " ", "30", "1/6/2018");
        prod_class item3=new prod_class(3, "habash birds", "habash", "Animals","20", "idk", "20000$", "w1.jpg", " ", " ", "14", "1/6/2018");
        ArrayList<prod_class> products=new ArrayList<prod_class>();
        products.add(item1);products.add(item2);products.add(item3);

        /*String[] food={"Tomato","Potato","fuck","the","damn","hell"};*/
        ListView LV=(findViewById(R.id.ProdList));

        LV.setAdapter(new product_adapter(this,products));
    }
}
