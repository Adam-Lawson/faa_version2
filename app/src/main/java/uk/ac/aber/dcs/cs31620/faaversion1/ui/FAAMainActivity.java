package uk.ac.aber.dcs.cs31620.faaversion1.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import uk.ac.aber.dcs.cs31620.faaversion1.R;
import uk.ac.aber.dcs.cs31620.faaversion1.ui.cats.CatsFragment;
import uk.ac.aber.dcs.cs31620.faaversion1.ui.faa_users.FAAUsersFragment;
import uk.ac.aber.dcs.cs31620.faaversion1.ui.fosterers.FosterersFragment;
import uk.ac.aber.dcs.cs31620.faaversion1.ui.home.HomeFragment;
import uk.ac.aber.dcs.cs31620.faaversion1.ui.kittens.KittensFragment;

public class FAAMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faamain);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the navigation drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        // Create ActionBar toggle (burger icon) for the navigation drawer
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this,
                        drawer,
                        toolbar,
                        R.string.nav_open_drawer,
                        R.string.nav_close_drawer);

        drawer.addDrawerListener(toggle);
        toggle.syncState(); // sync the state of the icon with drawer state

        // Find the navigation drawer
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Handle navigation drawer option selections
        navigationView.setNavigationItemSelectedListener(this);

        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    /**
     * Called when an item in the navigation drawer is selected
     * @param item The item that was selected
     * @return true if te item was handled
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Toast.makeText(this, "Item id: " + item.getItemId(), Toast.LENGTH_LONG).show();
        return true;
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0: return getResources().getText(R.string.home_tab);
                case 1: return getResources().getText(R.string.kitten_tab);
                case 2: return getResources().getText(R.string.cat_tab);
                case 3: return getResources().getText(R.string.fosterer_tab);
                case 4: return getResources().getText(R.string.faa_user_tab);
            }
            return null;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new HomeFragment();
                case 1: return new KittensFragment();
                case 2: return new CatsFragment();
                case 3: return new FosterersFragment();
                case 4: return new FAAUsersFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
