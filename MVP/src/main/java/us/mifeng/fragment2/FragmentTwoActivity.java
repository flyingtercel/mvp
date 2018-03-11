package us.mifeng.fragment2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import us.mifeng.fragment2.persion.DataPersionComp;
import us.mifeng.fragment2.persion.IDataPersion;
import us.mifeng.login.R;

public class FragmentTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_fragments);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_fragments);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);

        IDataPersion dataPersion = new DataPersionComp(this);
        dataPersion.loadData();

    }
    public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

        public String[]pagers = {"FragmentA","FragmentB","FragmentC"};
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TdFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return pagers.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pagers[position];
        }
    }
}
