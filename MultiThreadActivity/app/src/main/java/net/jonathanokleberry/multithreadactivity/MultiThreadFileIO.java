package net.jonathanokleberry.multithreadactivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;


//To Do:
//        Make the "doWork()" function do something
//        Add functions for each of the buttons
//        Add a List View (In Progress, deciphering what to add to previous work on progress bar


public class MultiThreadFileIO extends AppCompatActivity {

    //////////////////////////////////////////////////////////////////////////////
    // Some code to create a progress bar across the top of our activity / page //
    //////////////////////////////////////////////////////////////////////////////

    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    //////////////////////////////////////////
    // Some code to work with our list view //
    //////////////////////////////////////////

    // The adapter being used to display the list's data
    SimpleCursorAdapter mAdapter;


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_multi_thread_file_io);

        mProgress = (ProgressBar) findViewById(R.id.progress_bar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
//                    mProgressStatus = doWork();

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }




}
