package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidassignment.Suffixer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                if (text.length() == 0) {
                    throw new Exception("Please enter a string that is at least 1 character long");
                }

                indexNumber = Integer.parseInt(index);
                if (indexNumber < 0 || indexNumber > text.length() - 1) {
                    throw new Exception("Index should be greater than 0 and smaller than " + (text.length()-1));
                }
            } catch (NumberFormatException e) {
                out.setText(R.string.invalid_number);
                return;
            } catch (Exception e) {
                out.setText(e.getMessage());
                return;
            }

            Suffixer suffix = new Suffixer(text, indexNumber);
            try {
                out.setText("Suffix is: " + suffix.getSuffix());
            }
            catch(Exception e) {
                out.setText(e.getMessage());
            }
        });


    }
}