package android.love.tabprepare;

import android.love.tabprepare.ui.main.EventListener;
import android.love.tabprepare.ui.main.PlaceholderFragment;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.love.tabprepare.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }


    public void applyEditTextDate(String s) {
        this.text = s;

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        PlaceholderFragment fragment = (PlaceholderFragment) sectionsPagerAdapter.getRegisteredFragment(position);
        if(text!=null && position == 3){
            fragment.addReceivedText(text);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}