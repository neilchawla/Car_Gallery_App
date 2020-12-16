package com.example.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends ListActivity {

    private int getDealer(int id) {
        switch (id) {
            case R.drawable.audir8:
                return R.array.audi_dealers;

            case R.drawable.bmwi8:
                return R.array.bmw_dealers;

            case R.drawable.dodgechallengerhel:
                return R.array.dodge_dealers;

            case R.drawable.mclarenp1:
                return R.array.mclaren_dealers;

            case R.drawable.mercgwagon:
                return R.array.merc_dealers;

            case R.drawable.porsche911:
                return R.array.porsche_dealers;

            default:
                return -1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int id = intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view, getResources().getStringArray(getDealer(id))));

        ListView lv = getListView();
    }
}