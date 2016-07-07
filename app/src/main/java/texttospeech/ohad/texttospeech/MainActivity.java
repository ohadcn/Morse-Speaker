package texttospeech.ohad.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tts;
    boolean isInitialized = false;
    Morse currnetLetter = new Morse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                isInitialized = true;
            }
        });

        ImageButton play = (ImageButton)findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isInitialized) {
                    Toast.makeText(v.getContext(), "Text to speech engine is not initialized yet!", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText text = (EditText)findViewById(R.id.textToSay);
                tts.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        ImageButton dot = (ImageButton)findViewById(R.id.dotBtn);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currnetLetter.add(Morse.MorseValues.DOT);
            }
        });

        ImageButton line = (ImageButton)findViewById(R.id.lineBtn);
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currnetLetter.add(Morse.MorseValues.LINE);
            }
        });

        ImageButton space = (ImageButton)findViewById(R.id.spaceBtn);
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currnetLetter.add(Morse.MorseValues.SPACE);
                EditText text = (EditText)findViewById(R.id.textToSay);
//                String ltr = currnetLetter.toString();
                int key  = currnetLetter.toKeyCode();
//                text.getEditableText().append(ltr);
//                System.out.println("key pressed " + key);
                if (key == KeyEvent.KEYCODE_ENTER) {
                    tts.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
//                    key = KeyEvent.KEYCODE_ENTER;
                }
                text.dispatchKeyEvent(new KeyEvent(0, 0, KeyEvent.ACTION_DOWN,
                        key, 0));
                text.dispatchKeyEvent(new KeyEvent(0, 0, KeyEvent.ACTION_UP,
                        key, 0));
                currnetLetter = new Morse();
            }
        });

        EditText text = (EditText)findViewById(R.id.textToSay);
        text.selectAll();
    }
}
