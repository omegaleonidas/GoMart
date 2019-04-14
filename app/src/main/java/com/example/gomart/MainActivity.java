package com.example.gomart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gomart.Adapter.AdapterExample;
import com.example.gomart.Model.Model_Foto;

import java.util.ArrayList;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String kata[] = {"kata"};
    FlipperLayout flipperLayout;
    RecyclerView recyclerView;
    AdapterExample adapter1;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);
        final ArrayList<Model_Foto> model_fotos = new ArrayList<>();
        model_fotos.add(new Model_Foto(R.drawable.makanan));
        model_fotos.add(new Model_Foto(R.drawable.minum));
        model_fotos.add(new Model_Foto(R.drawable.makanan));
        model_fotos.add(new Model_Foto(R.drawable.minum));
        model_fotos.add(new Model_Foto(R.drawable.makanan));
        model_fotos.add(new Model_Foto(R.drawable.minum));
        model_fotos.add(new Model_Foto(R.drawable.makanan));
        model_fotos.add(new Model_Foto(R.drawable.minum));
        model_fotos.add(new Model_Foto(R.drawable.makanan));
        model_fotos.add(new Model_Foto(R.drawable.minum));
        layoutManager = new LinearLayoutManager(this);
        adapter1 = new AdapterExample(model_fotos);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter1);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), kata.toString(), Toast.LENGTH_LONG).show();
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        flipperLayout = findViewById(R.id.Flipper1);
        setlayout();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void setlayout() {
        String url[] = new String[]{

                "http://www.galleriasm.com/Images/Branch/branch_ov2.jpg",
                "https://www.seriouseats.com/images/2016/01/20160115-things-never-to-but-at-supermarket-.jpg",
                "https://a57.foxnews.com/a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2018/09/640/320/1862/1048/meatsupermarketap.jpg?ve=1&tl=1?ve=1&tl=1",
                "https://freshchoice.co.nz/libraries/timthumb/timthumb.php?w=900&h=600&q=80&zc=1&src=/https://freshchoice.co.nz/media/com_mtree/images/listings/o/387.jpg",
        };

        for (int i = 0; i < 4; i++) {

            FlipperView view = new FlipperView(getBaseContext());
            view.setImageUrl(url[i])
                    .setDescription("Image" + (i + 1));
            flipperLayout.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    Toast.makeText(MainActivity.this, "" + (flipperLayout.getCurrentPagePosition() + 1), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
