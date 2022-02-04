package edu.neu.madcourse.numad22sp_chintanaddoni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class click_button extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
    }
    public void click_button(View view){
        String text = "Pressed: ";
        switch (view.getId()){
            case R.id.button_A:
                text+="A";
                break;
            case R.id.button_B:
                text+="B";
                break;
            case R.id.button_C:
                text+="C";
                break;
            case R.id.button_D:
                text+="D";
                break;
            case R.id.button_E:
                text+="E";
                break;
            case R.id.button_F:
                text+="F";
                break;
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
    }
}
