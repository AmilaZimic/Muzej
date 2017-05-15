package com.example.dana.muzej;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dana.muzej.Fragments.AboutMuseumFragment;
import com.example.dana.muzej.Fragments.BookATourFragment;
import com.example.dana.muzej.Fragments.HomeFragment;
import com.example.dana.muzej.Fragments.InfoFragment;
import com.example.dana.muzej.Fragments.NearbyFragment;
import com.example.dana.muzej.Fragments.RateFragment;
import com.example.dana.muzej.Fragments.SupportUsFragment;
import com.example.dana.muzej.Fragments.Whatsnew;

import java.util.Locale;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener,
        HomeFragment.OnFragmentInteractionListener,
        NearbyFragment.OnFragmentInteractionListener,
        SupportUsFragment.OnFragmentInteractionListener,
        InfoFragment.OnFragmentInteractionListener,
        RateFragment.OnFragmentInteractionListener,
        BookATourFragment.OnFragmentInteractionListener

{
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Home fragment call*/

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        HomeFragment homeFragment=new HomeFragment();
        fragmentTransaction.add(R.id.fragment_container,homeFragment);
        fragmentTransaction.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void setLocal(String language){

        myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            AboutMuseumFragment aboutFragment=new AboutMuseumFragment();
            fragmentTransaction.replace(R.id.fragment_container,aboutFragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nav_home) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.fragment_container, homeFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_info) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            InfoFragment infoFragment=new InfoFragment();
            fragmentTransaction.replace(R.id.fragment_container,infoFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_nearby) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            NearbyFragment nearbyFragment=new NearbyFragment();
            fragmentTransaction.replace(R.id.fragment_container,nearbyFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_news) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            Whatsnew news=new Whatsnew();
            fragmentTransaction.replace(R.id.fragment_container,news);
            fragmentTransaction.commit();

        }  else if (id == R.id.nav_rate) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            RateFragment rateFragment=new RateFragment();
            fragmentTransaction.replace(R.id.fragment_container,rateFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_support) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            SupportUsFragment supportUsFragment=new SupportUsFragment();
            fragmentTransaction.replace(R.id.fragment_container,supportUsFragment);
            fragmentTransaction.commit();

        }  else if (id == R.id.nav_book_a_tour) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            BookATourFragment bookATourFragment=new BookATourFragment();
            fragmentTransaction.replace(R.id.fragment_container,bookATourFragment);
            fragmentTransaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}