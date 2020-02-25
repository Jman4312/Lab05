package com.lowejimmy.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPreferences;
    SharedPreferences.Editor preferencesEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataStore.createdThisLife += 1;
        mPreferences = getSharedPreferences("com.lowejimmy.lab05.sharedprefs",MODE_PRIVATE);
        preferencesEditor = mPreferences.edit();

        DataStore.createdSinceInstall = mPreferences.getInt("createdSinceInstall", 1);
        DataStore.startedSinceInstall = mPreferences.getInt("startedSinceInstall", 0);
        DataStore.resumedSinceInstall = mPreferences.getInt("resumedSinceInstall", 0);
        DataStore.pausedSinceInstall = mPreferences.getInt("pausedSinceInstall", 0);
        DataStore.restartedSinceInstall = mPreferences.getInt("restartedSinceInstall", 0);
        DataStore.stoppedSinceInstall = mPreferences.getInt("stoppedSinceInstall", 0);
        DataStore.destroyedSinceInstall = mPreferences.getInt("destroyedSinceInstall", 0);


        //preferencesEditor.putString("mResponse", responseText.getText().toString());
        // preferencesEditor.putInt("mResponseNum", Integer.parseInt(response2Text.getText().toString()));
        preferencesEditor.apply();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DataStore.startedThisLife += 1;
        DataStore.startedSinceInstall += 1;
        preferencesEditor.putInt("startedSinceInstalled", DataStore.startedSinceInstall + 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataStore.resumedThisLife +=1;
        DataStore.resumedSinceInstall +=1;
        preferencesEditor.putInt("resumedSinceInstalled", DataStore.resumedSinceInstall + 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataStore.pausedThisLife += 1;
        DataStore.pausedSinceInstall +=1;
        preferencesEditor.putInt("pausedSinceInstalled", DataStore.pausedSinceInstall + 1);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        DataStore.restartedThisLife += 1;
        DataStore.restartedSinceInstall +=1;
        preferencesEditor.putInt("restartedSinceInstalled", DataStore.restartedSinceInstall + 1);
    }

    @Override
    protected void onStop() {
        DataStore.stoppedThisLife += 1;
        DataStore.stoppedSinceInstall +=1;
        preferencesEditor.putInt("stpopedSinceInstalled", DataStore.stoppedSinceInstall + 1);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        DataStore.destroyedThisLife += 1;
        DataStore.destroyedSinceInstall +=1;
        preferencesEditor.putInt("destroyedSinceInstalled", DataStore.destroyedSinceInstall + 1);
        super.onDestroy();
    }

    public void thisLife(View view) {
        String returnString = "Times Created: " + String.valueOf(DataStore.createdThisLife) +
                "\n Times Started: " + String.valueOf(DataStore.startedThisLife) +
                "\n Times Resumed: " + String.valueOf(DataStore.resumedThisLife) +
                "\n Times Paused: " + String.valueOf(DataStore.pausedThisLife) +
                "\n Times Stopped: " + String.valueOf(DataStore.stoppedThisLife) +
                "\n Times Restarted: " + String.valueOf(DataStore.restartedThisLife) +
                "\n Times Destroyed: " + String.valueOf(DataStore.destroyedThisLife);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        CharSequence text = returnString;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void sinceInstall(View view) {
        String returnString = "Times Created: " + String.valueOf(DataStore.createdSinceInstall) +
                "\n Times Started: " + String.valueOf(DataStore.startedSinceInstall) +
                "\n Times Resumed: " + String.valueOf(DataStore.resumedSinceInstall) +
                "\n Times Paused: " + String.valueOf(DataStore.pausedSinceInstall) +
                "\n Times Stopped: " + String.valueOf(DataStore.stoppedSinceInstall) +
                "\n Times Restarted: " + String.valueOf(DataStore.restartedSinceInstall) +
                "\n Times Destroyed: " + String.valueOf(DataStore.destroyedSinceInstall);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        CharSequence text = returnString;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void resetValues(View view){
        DataStore.createdThisLife = 0;
        DataStore.createdSinceInstall = 0;

        DataStore.startedThisLife = 0;
        DataStore.startedSinceInstall = 0;

        DataStore.resumedThisLife = 0;
        DataStore.resumedSinceInstall = 0;

        DataStore.pausedThisLife = 0;
        DataStore.pausedSinceInstall = 0;

        DataStore.stoppedThisLife = 0;
        DataStore.stoppedSinceInstall = 0;

        DataStore.restartedThisLife = 0;
        DataStore.restartedSinceInstall = 0;

        DataStore.destroyedThisLife = 0;
        DataStore.destroyedSinceInstall = 0;

        mPreferences = getSharedPreferences("com.lowejimmy.lab05.sharedprefs",MODE_PRIVATE);
        preferencesEditor = mPreferences.edit();

        preferencesEditor.putInt("createdSinceInstall", 0);
        preferencesEditor.putInt("resumedSinceInstall", 0);
        preferencesEditor.putInt("restartedSinceInstall", 0);
        preferencesEditor.putInt("stoppedSinceInstall", 0);
        preferencesEditor.putInt("destroyedSinceInstall", 0);
        preferencesEditor.putInt("pausedSinceInstall", 0);
        preferencesEditor.putInt("startedSinceInstall", 0);

        preferencesEditor.apply();
    }
}