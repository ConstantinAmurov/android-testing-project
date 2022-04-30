package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final EditText textInput = findViewById(R.id.input1);
        final EditText indexSuffixInput = findViewById(R.id.input2);
        final TextView out = findViewById(R.id.out);

        button.setOnClickListener(view -> {
            String text = textInput.getText().toString();
            String index = indexSuffixInput.getText().toString();
            int indexNumber;

            try {
                indexNumber = Integer.parseInt(index);
                if(indexNumber < 0 || indexNumber > text.length()-1) {
                    throw new Exception("Index should be greater than 0 and less than " + (text.length()-1));
                }
            }
            catch(NumberFormatException e) {
                out.setText(e.getMessage());
                return;
            }
            catch (Exception e) {
                out.setText(e.getMessage());
                return;
            }
        });


    }
}