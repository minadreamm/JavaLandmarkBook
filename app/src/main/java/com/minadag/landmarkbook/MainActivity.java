package com.minadag.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.minadag.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    ArrayList<Landmark> ArrayListLandmark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        ArrayListLandmark = new ArrayList<>();

        // data

        Landmark pisa =  new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel","France",R.drawable.eifel);
        Landmark galata = new Landmark("Galata Tower", "Turkey",R.drawable.galata);
        Landmark coloseum = new Landmark("Coloseum", "Italy", R.drawable.coloseum);

        ArrayListLandmark.add(pisa);
        ArrayListLandmark.add(eiffel);
        ArrayListLandmark.add(galata);
        ArrayListLandmark.add(coloseum);

        //Adapter
        //ListView

        //mapping

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                ArrayListLandmark.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );

        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("mina",ArrayListLandmark.get(position));
                startActivity(intent);
            }
        });
    }
}