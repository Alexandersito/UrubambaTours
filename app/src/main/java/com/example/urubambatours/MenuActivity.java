package com.example.urubambatours;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //UI
        mDrawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.content, new FragmentHome()).commit();
        setTitle("Urubamba Tours");

        //Setup toolbar
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    private void selectItemNav(MenuItem item) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (item.getItemId()){
            case R.id.nav_home:
                ft.replace(R.id.content,new FragmentHome()).commit();
                setTitle("Urubamba Tours");
            break;
            case R.id.nav_top:
                ft.replace(R.id.content,new FragmentTop()).commit();
                setTitle(item.getTitle());
                break;
            case R.id.nav_especiales:
                ft.replace(R.id.content,new FragmentEspeciales()).commit();
                setTitle(item.getTitle());
                break;
            case R.id.nav_carrito:
                ft.replace(R.id.content,new FragmentCarrito()).commit();
                setTitle(item.getTitle());
                break;
            case R.id.nav_nosotros:
                ft.replace(R.id.content,new FragmentNosotros()).commit();
                setTitle(item.getTitle());
                break;
        }

        mDrawerLayout.closeDrawers();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}