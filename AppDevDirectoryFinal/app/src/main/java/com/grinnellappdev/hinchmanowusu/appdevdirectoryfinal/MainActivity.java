package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal;

import java.util.ArrayList;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.About.About;
import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.ContactUs.Contactus;
import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.Model.DrawerItem;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    //nav drawer title
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    //slide menu items
    private String[] mDrawerItems;

    private ArrayList<DrawerItem> navDrawerItems;
    CustomDrawerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();

        //load slide menu items
        mDrawerItems = getResources().getStringArray(R.array.drawer_titles);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        navDrawerItems = new ArrayList<DrawerItem>();

        //set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);

        navDrawerItems.add(new DrawerItem(mDrawerItems[0]));
        navDrawerItems.add(new DrawerItem(mDrawerItems[1]));
        navDrawerItems.add(new DrawerItem(mDrawerItems[2]));
        navDrawerItems.add(new DrawerItem(mDrawerItems[3]));

        //setting the nav drawer list adapter
        adapter = new CustomDrawerAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        //Add items to the ListView
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItems));
        //Set the onItemClickListener so something happens when a user clicks on an item.
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //Enable ActionBar app icon to behave as action to toggle the Navigation Drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle
                (this,
                 mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // set the default content area to item 0
        // when the app opens for the first time
        if (savedInstanceState == null) {
            navigateTo(0);
        }

    }//onCreate(Bundle)

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if(mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        //handle action bar actions click
        switch(item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }//onPostCreate(Bundle)

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }//onConfigurationChanged(Configuration)

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            navigateTo(position);
        }
    }//class DrawerItemClickListener

    private void navigateTo(int position) {
        Fragment fragment = null;
        switch(position) {
            case 0: //getSupportFragmentManager()
                    //.beginTransaction()
                    //.replace(R.id.content_frame, Directory.newInstance(), Directory.TAG).commit();
                    break;
            case 1: //getSupportFragmentManager()
                    //.beginTransaction()
                    //.replace(R.id.content_frame, SocialMedia.newInstance(), SocialMedia.TAG).commit();
                break;
            case 2: getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, About.newInstance(), About.TAG).commit();
                    fragment = new About();
                break;
            case 3: getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, Contactus.newInstance(), Contactus.TAG).commit();
                    fragment = new Contactus();
                break;
        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            //update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            //error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }//navigateTo(int)

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }//setTitle(CharSequence)

}//class MainActivity
