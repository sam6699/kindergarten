package kindergarten.uz.kindergarten;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import kindergarten.uz.kindergarten.mygallery.GalleryFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static MainActivity instance;
    public  int company;
    public int main;

    MainFragment mf;
    ReserveFragment rf;
    ContactsFragment cf;
    GalleryFragment gf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.tester,null);

        getSupportActionBar().setBackgroundDrawable(drawable);
        instance = this;
        Intent intent = getIntent();
        company = intent.getIntExtra("company",0);


        FragmentTransaction ft = getFragmentManager().beginTransaction();
        mf = new MainFragment();
        ft.replace(R.id.main_frame,mf);
        ft.commit();




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if (id == R.id.main) {
        mf = new MainFragment();
        ft.replace(R.id.main_frame,mf);
        } else if (id == R.id.reserve) {
        rf = new ReserveFragment();
        ft.replace(R.id.main_frame,rf);
            // Handle the camera action
        } else if (id == R.id.contacts) {
        cf = new ContactsFragment();
        ft.replace(R.id.main_frame,cf);
        } else if (id == R.id.gallery){
        gf = new GalleryFragment();
        ft.replace(R.id.main_frame,gf);
        }

        ft.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
