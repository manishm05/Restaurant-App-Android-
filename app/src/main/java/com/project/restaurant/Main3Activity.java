package com.project.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button b1=(Button)findViewById(R.id.button2);
        Button b2=(Button)findViewById(R.id.button3);
        Button b3=(Button)findViewById(R.id.button4);
        Button b4=(Button)findViewById(R.id.button7);
        TextView t1= (TextView) findViewById(R.id.textView36);
        TextView t2= (TextView) findViewById(R.id.textView37);
        Intent intent=getIntent();
        String id= intent.getStringExtra("abc");
        t1.setText(id);
        t2.setText("9643261554");
        b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent=new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent=new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent= new Intent(Main3Activity.this, Main9Activity.class);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent=new Intent(Main3Activity.this, Main5Activity.class);
                startActivity(intent);
            }
        });
    }
}
