package rajasthantourism.com.tourrajasthan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread th = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(3000);
                }
                catch (Exception h)
                {
                }
                finally {
                    Intent i = new Intent(Splash.this,Slider.class);
                    startActivity(i);
                }
            }
        };
        th.start();
    }
}
