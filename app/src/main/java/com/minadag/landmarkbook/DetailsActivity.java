package com.minadag.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.minadag.landmarkbook.databinding.ActivityDetailsBinding;
import com.minadag.landmarkbook.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
                                    // casting
        Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("mina");

        binding.countryText.setText(selectedLandmark.country);
        binding.nameText.setText(selectedLandmark.name);
        binding.imageView.setImageResource(selectedLandmark.image);
    }
}