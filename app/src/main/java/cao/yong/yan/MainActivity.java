package cao.yong.yan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import cao.yong.yan.view.MyView;

public class MainActivity extends AppCompatActivity {

    //棋谱试图
    private MyView chessManual;
    private String TAG="cyy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chessManual= (MyView) findViewById(R.id.mv_chessManual);
        chessManual.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                Log.i(TAG, "onTouch: "+x+"\t"+y);
                return true;
            }
        });
    }
}
