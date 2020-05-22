package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);

        final ArrayList<Integer> words = new ArrayList<Integer>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k = Integer.parseInt(et.getText().toString());
                int f1 = 0, f2 = 1, t;
                words.add(f1);
                for (int i = 1; f2 <= k; i++){
                    words.add(f2);
                    t = f2;
                    f2 = f2 + f1;
                    f1 = t;
                }
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_list_item_1, words);

                ListView root = findViewById(R.id.block);

                root.setAdapter(adapter);
            }
        });
    }
}
