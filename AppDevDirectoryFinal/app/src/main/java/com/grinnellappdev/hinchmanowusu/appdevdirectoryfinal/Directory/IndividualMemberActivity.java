package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.Directory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class IndividualMemberActivity extends Activity {

    String name, year, major, role, picurl, weburl, giturl, linkedurl, twitterurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_member);

        ImageLoader loader = ImageLoader.getInstance();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        picurl = bundle.getString("image");

        TextView nameTextView = (TextView) findViewById(R.id.name);
        TextView yearTextView = (TextView) findViewById(R.id.year);
        TextView majorTextView = (TextView) findViewById(R.id.major);
        TextView roleTextView = (TextView) findViewById(R.id.role);

        ImageView imgview = ((ImageView) findViewById(R.id.imageView1));

        loader.displayImage(picurl, imgview);

        year = bundle.getString("year");
        name = bundle.getString("name");
        major = bundle.getString("major");
        role = bundle.getString("role");
        weburl = bundle.getString("weburl");
        linkedurl = bundle.getString("linkedurl");
        giturl = bundle.getString("giturl");
        twitterurl = bundle.getString("twitterurl");

//		Log.d("HomepageURL : ", homepageurl);
//		Log.d("TwitterURL: ", twitterurl);
//		Log.d("GitURL : ", giturl);
//		Log.d("LinkedInURL : ", linkedurl);


        nameTextView.setText(name);
        yearTextView.setText(year);
        majorTextView.setText(major);
        roleTextView.setText(role);

        ImageButton git = (ImageButton) findViewById(R.id.gitHubButton);
        ImageButton twitter = (ImageButton) findViewById(R.id.twitterButton);
        ImageButton home = (ImageButton) findViewById(R.id.homeButton);
        ImageButton linkedin = (ImageButton) findViewById(R.id.linkedButton);

        git.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse(giturl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        twitter.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse(twitterurl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        home.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse(weburl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        linkedin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse(linkedurl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

    }

    // not sure why this is here if no menu is defined for the activity_individual_member.xml
    // in any case, Michael and I can go over this together with this resource:
    // http://developer.android.com/guide/topics/ui/menus.html
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.individual_member, menu);
        return true;
    }*/

}