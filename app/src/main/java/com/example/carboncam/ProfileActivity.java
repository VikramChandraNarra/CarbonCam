package com.example.carboncam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carboncam.databinding.ActivityProfileBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private BarChart barChart;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.carboncam.databinding.ActivityProfileBinding binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        back = findViewById(R.id.profile_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, Feed.class);
                startActivity(intent);
            }
        });

        //pre-fill bar chart
        barChart = findViewById(R.id.barChart);
        configureChart();
    }

    private void configureChart() {
        //bar chart title
        Description desc = new Description();
        desc.setText("");
        desc.setTextSize(28);
        barChart.setDescription(desc);

        //set bar chart data
        BarDataSet barDataSet = new BarDataSet(getData(), "Geeks for Geeks");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        //customize chart
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextSize(16f);
    }

    //prefill data
    private ArrayList<BarEntry> getData() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 4));
        entries.add(new BarEntry(2f, 6));
        entries.add(new BarEntry(3f, 8));
        entries.add(new BarEntry(4f, 2));
        entries.add(new BarEntry(5f, 4));
        entries.add(new BarEntry(6f, 1));

        return entries;
    }
}