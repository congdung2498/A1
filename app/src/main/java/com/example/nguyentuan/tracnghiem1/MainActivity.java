package com.example.nguyentuan.tracnghiem1;

import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
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

import com.example.nguyentuan.tracnghiem1.monhoc.HomeFragment;
import com.example.nguyentuan.tracnghiem1.monhoc.A1Fragment;
import com.example.nguyentuan.tracnghiem1.question.DBHelper;
import com.example.nguyentuan.tracnghiem1.question.SearchQuesFragment;
import com.example.nguyentuan.tracnghiem1.score.ScoreFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

        DBHelper db = new DBHelper(this);
        if(db.checkDataBase()){
            try {
                db.deleteDataBase();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            try {
                db.createDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                db.createDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity  in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {// Chạy vào trang chủ khi click vào trang chủ
            HomeFragment homeFragment = new HomeFragment();
            //Mỗi activity có FragmentManager để quản lý fragment
            //Lấy ra một đối tượng FragmentManager. Lớp FragmentManager cho phép thêm sửa xóa fragment trong layout của activity
            FragmentManager manager = getSupportFragmentManager();//Dùng getSupport hoặc get
            //manager.begin... cho phép CRUD
            //ta cũng có theer đặt FragmentTransaction(đói tượng quản lý CRUD)
            //Thay thế 1 content main và replace thay thế fragment cũ bằng 1 fragment mới đó là contentmain
            manager.beginTransaction().replace(R.id.content_main, homeFragment).commit();//co the thêm , homeFragment.getTag()
        } else if (id == R.id.A1) {//Chạy vào mục thi trắc nghiệm a1
            A1Fragment a1Fragment = new A1Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, a1Fragment, a1Fragment.getTag()).commit();

        } else if (id == R.id.search) {
            SearchQuesFragment searchQuesFragment = new SearchQuesFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, searchQuesFragment, searchQuesFragment.getTag()).commit();
        }else if (id == R.id.score) {
            ScoreFragment scoreFragment = new ScoreFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, scoreFragment, scoreFragment.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
