package com.example.handler;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText textView;
    Handler handler = new Handler();
    Button button1, button2, button3;
    ProgressBar progressBar;
    int sec = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        textView = findViewById( R.id.text );
        button1 = findViewById( R.id.bt1 );
        button2 = findViewById( R.id.bt2 );
        button3 = findViewById( R.id.bt3 );
        progressBar = findViewById( R.id.progress_horizontal );
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runnable.run();
            }
        } );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks( runnable );
            }
        } ); 
        
        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, Main2Activity.class);
                startActivity( intent );
                
            }
        } );
    
    }
        
        
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (sec <= 10) {
                textView.setText( 10.0 * sec+"%");
                double  progess  = (10.0 * sec);
                progressBar.setProgress( (int)progess );
                sec++;
                handler.postDelayed( this, 1000 );
            } else {
                textView.setText( "Time is completed" );
                progressBar.setProgress( 0 );
                Toast.makeText( MainActivity.this, "Progress is done", Toast.LENGTH_SHORT ).show();

            }
        }
    };
}
//https://github.com/deepakmeett/PaperFace.git