package com.example.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridLayoutActivity extends Activity {

    protected static final String EXTRA_RES_ID = "POS";
    private GridView gridview;

    // ArrayList to reference the names
    private ArrayList<Integer> name = new ArrayList<>(
            Arrays.asList(R.string.audi, R.string.bmw, R.string.dodge,
                    R.string.mclaren, R.string.merc, R.string.porsche)
    );

    // ArrayList to reference the images
    private ArrayList<Integer> mThumbIdsCars = new ArrayList<>(
            Arrays.asList(R.drawable.audir8, R.drawable.bmwi8, R.drawable.dodgechallengerhel,
                    R.drawable.mclarenp1, R.drawable.mercgwagon, R.drawable.porsche911)
    );

    private ArrayList<Integer> CarWebPages = new ArrayList<>(
            Arrays.asList(R.string.audi_web)
    );

    private String getWebpage(int id) {
        switch (id){
            case R.drawable.audir8:
                return "https://www.audiusa.com/us/web/en/models/r8/r8-coupe/2020/overview.html";
                //break;
            case R.drawable.bmwi8:
                return "https://www.bmwusa.com/vehicles/bmwi/i8/overview.html";
                //break;
            case R.drawable.dodgechallengerhel:
                return "https://www.dodge.com/challenger.html";
                //break;
            case R.drawable.mclarenp1:
                return "https://cars.mclaren.com/us-en/legacy/mclaren-p1";
                //break;
            case R.drawable.mercgwagon:
                return "https://www.mbusa.com/en/vehicles/class/g-class/suv";
                //break;
            case R.drawable.porsche911:
                return "https://www.porsche.com/international/models/911/911-models/carrera/";
                //break;
            default:
                return "error";
                //break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GridView
        gridview = (GridView) findViewById(R.id.gridView);

        registerForContextMenu(gridview);

        ImageAdapter imageAdapter = new ImageAdapter(this, mThumbIdsCars, name, CarWebPages);
        gridview.setAdapter(imageAdapter);

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);

                intent.putExtra(EXTRA_RES_ID, (int) id);
                intent.putExtra("web", getWebpage((int)id));
                startActivity(intent);
            }
        });
/*
        gridview.setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                return false;
            }
        });

 */
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        long id = info.id;

        switch (item.getItemId()) {
            case R.id.view:
                Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
                intent.putExtra(EXTRA_RES_ID, (int) id);
                intent.putExtra("web", getWebpage((int) id));
                startActivity(intent);
                return true;
            case R.id.webpage:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(getWebpage((int)id)));
                startActivity(intent1);
                return true;
            case R.id.dealers:
                Intent intent2 = new Intent(GridLayoutActivity.this, ListViewActivity.class);
                intent2.putExtra(EXTRA_RES_ID, (int) id);
                startActivity(intent2);
                return true;
            default:
                return false;
        }
    }


}





























