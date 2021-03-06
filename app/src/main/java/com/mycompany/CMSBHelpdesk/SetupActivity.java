package com.mycompany.CMSBHelpdesk;

/**
 * This is just the splash page which only opens once when user first opens the app
 * or clears the app data
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.mycompany.CMSBHelpdesk.helpers.sharedPreference;


public class SetupActivity extends Activity {


    Button mSetupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_setup);

        mSetupBtn = (Button) findViewById(R.id.SetUpBtn);
        //mSetupBtn.setBackgroundResource(R.drawable.mycolors2);
        mSetupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, Settings.class);
                sharedPreference.setString(SetupActivity.this, "oneTS", "true");
                startActivity(intent);
                SetupActivity.this.finish();
                overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
            }
        });
    }


    @Override
    public void onBackPressed(){
        System.exit(1);
    }
}
