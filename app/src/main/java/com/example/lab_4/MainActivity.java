package com.example.lab_4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private TextView gestureText;
    private TextView gestureText2;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gestureText = findViewById(R.id.gesture_text);
        gestureText2 = findViewById(R.id.gesture_text2);
        gestureDetector = new GestureDetector(this, this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText("пользователь нажл на экран");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("пользователь не отпускает экран и не проводит пальцем");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("пользователь отпускает экран после одиночного нажатия");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float v, float v1) {
        gestureText.setText("пользователь проводит пальцем по экрану");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("пользователь нажимает и удерживает экран в течение некоторого времени");
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float v, float v1) {
        gestureText.setText("пользователь быстро проводит пальцем по экрану");
        return false;
    }

//    @Override
//    public boolean onDoubleTap(MotionEvent event) {
//        gestureText.setText("пользователь использовал двойное нажатие");
//        return false;
//    }
}