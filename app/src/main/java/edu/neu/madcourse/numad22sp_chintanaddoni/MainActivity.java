package edu.neu.madcourse.numad22sp_chintanaddoni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(v -> Toast.makeText(getApplicationContext(),
                "Name: Chintan Addoni \nEmail: sheshagiriaddoni.c@northeastern.edu",
                Toast.LENGTH_LONG)
                .show());
    }


}