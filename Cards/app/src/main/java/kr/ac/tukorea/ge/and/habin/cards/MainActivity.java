package kr.ac.tukorea.ge.and.habin.cards;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/// control+art+o 누르면 안쓰는 헤더 지워줌

import kr.ac.tukorea.ge.and.habin.cards.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private @NonNull ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
    }

    public void OnButtonCard(View view) {
        Log.d("OnButtonCard","view");


    }
}