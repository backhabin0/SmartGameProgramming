package kr.ac.tukorea.ge.and.habin.firstandapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn=findViewById(R.id.button1);
        btn.setOnClickListener(this);
    }

    @Override/// 버튼 클릭한거 onclick event
    public void onClick(View v) {
        TextView tv =findViewById(R.id.textview);
        tv.setText("백하빈 졸라ㅇㅣ쁘다");
    }
}
//onclick버튼은 3가지있음 깃 참고