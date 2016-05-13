package kr.co.yogibaba.www.yogibaba;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import kr.co.yogibaba.www.yogibaba.search.SearchActivity;
import kr.co.yogibaba.www.yogibaba.settingTab.SettinTestFragment;
import kr.co.yogibaba.www.yogibaba.shoppingtab.ShppingTabFragment;
import kr.co.yogibaba.www.yogibaba.videoTab.VideoListFragment;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabHost = (FragmentTabHost)findViewById(R.id.tabHost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("videolist").setIndicator("영상"), VideoListFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("shopping").setIndicator("쇼핑"), ShppingTabFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("setting").setIndicator("사용자설정"), SettinTestFragment.class, null);




    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_yogi) {//검색버튼임
            Intent intent=new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);// 검색 액티비티를 실행하라
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
