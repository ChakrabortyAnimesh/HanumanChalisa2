package com.durga.bumba.hanumanchalisa;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.IOException;


public class HomeActivity extends AppCompatActivity {

  public ImageView imageViewshankh;
  //  private int duration;
    boolean  pressed;
    Runnable runnable;
    private int duration;
    boolean isbuttonon =false;
    SeekBar seekBar;
    public MediaPlayer mediaPlayer;
    Handler handler;
    public Button play;
    ViewPager viewPager;
    private View mPendulum,mPendulum2,ghanta;
    private Animation mAnimation;
    private Animation gAnimation;

   // Button but;

    private ImageView nextButton;
    private int counter=0;
    private int[] songarry;
    private int[] imagearray;
    private ViewFlipper viewFlipper;
    private Toolbar toolbar;
    int[] sliderImageId = new int[]{
            R.drawable.hanuman_new_best,R.drawable.hanuman_new1,R.drawable.hanuman_new_best2,R.drawable.hanuman_new2,R.drawable.hanuman_new3,R.drawable.hanuman_new_3,R.drawable.hanuman_new_4,R.drawable.hanuman_new5, R.drawable.hanuman,R.drawable.hanuman1
    };


    private ImageView btnPrev,btnNext;
    private WallpaperManager myWallpaperManager;
    private int position;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        viewPager = (ViewPager) findViewById(R.id.add);

        ViewPager ViewPager = (android.support.v4.view.ViewPager) findViewById(R.id.add);

        ImageAdapter adapterView = new ImageAdapter(this,sliderImageId);
        ViewPager.setAdapter(adapterView);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        songarry = new int[]{R.raw.aaa,R.raw.marutnandan,R.raw.shri_ram_jai_ram,R.raw.gayatrimantra};
        mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[0]);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more_vert_black_24dp));
        ImageView imagehanuman = (ImageView)findViewById(R.id.hanuman);
      //  seekBar = (SeekBar)  findViewById(R.id.seekbar);

        /* ********************************   Bell ringing  ***************************** */
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(HomeActivity.this,R.raw.templebellandoid);
        final MediaPlayer mediaPlayer12 = MediaPlayer.create(HomeActivity.this,R.raw.templebellandoid);
        final MediaPlayer mediaPlayerghanta = MediaPlayer.create(HomeActivity.this, R.raw.handbellsoundandroid);
        mPendulum2 = findViewById(R.id.bell12);
        mPendulum=findViewById(R.id.bell1);
        ghanta = findViewById(R.id.ghanta);



        mAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        gAnimation = AnimationUtils.loadAnimation(this, R.anim.animationa);


       ImageView imageanimation = (ImageView) findViewById(R.id.bell1);
        ImageView imageanim = (ImageView) findViewById(R.id.bell12);
       final ImageView ghanta = (ImageView) findViewById(R.id.ghanta);


        imageanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    mediaPlayer1.start();

                    mPendulum.startAnimation(mAnimation);


            }
        });

        imageanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer12.start();
                mPendulum2.startAnimation(mAnimation);

            }

        });
        ghanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayerghanta.start();

                ghanta.startAnimation(gAnimation);

            }
        });


        //*********************************   Seekbar ***************************** *//*



       play = (Button) findViewById(R.id.play123);

        /*********************************   Main media player ***************************** */

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();

                    play.setBackgroundResource(R.drawable.bestplay);
                }
                else {
                   // counter = 0;
                    mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                    mediaPlayer.start();
                    play.setBackgroundResource(R.drawable.bestpause);
                }
            }
        });



        /*********************************   Next button ***************************** */
        btnNext = (ImageView) findViewById(R.id.btnNext);
        btnPrev = (ImageView) findViewById(R.id.btnPrev);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    counter++;
                    if (counter > songarry.length-1) {
                        counter = 0;
                    }
                    mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                    mediaPlayer.start();
                }
            }
        });

        /********************************* Prev button *********************************/
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    counter--;
                    if (counter <0) {
                        counter=songarry.length-1;
                    }
                    mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                    mediaPlayer.start();
                }

            }
        });

        /********************************************************************************/

        /*********************************   Text of Hanumanchalisa  ***************************** */

      Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });


        pressed=false;
      final MediaPlayer mp = MediaPlayer.create(HomeActivity.this,R.raw.shankh_sound);

        imageViewshankh= (ImageView) findViewById(R.id.shankh);

        final Animation zoom = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.zoom);
        final Animation shrink = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.shrink);


        imageViewshankh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                imageViewshankh.startAnimation(zoom);
                duration =mp.getDuration();
                mp.start();
                zoom.setDuration(duration/2);
                zoom.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        shrink.setDuration(duration/2);
                        imageViewshankh.startAnimation(shrink);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


            }

        });
        //page selection callback listner
        viewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                //Here you can set the wallpaper
               position =arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @SuppressLint({"ResourceType", "NewApi"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hanuman:


                /*********************************     Set as Wallpaper    ***************************** */
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
               try {
                   myWallpaperManager.setResource(sliderImageId[position]);
                   Toast.makeText(this, " Wallpaper set successfully", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;

            case R.id.menu_item_share:
                shareIt();
                break;

            case R.id.hanumanwiki:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Hanuman"));
                startActivity(intent);
                break;
            case R.id.about:
                new AlertDialog.Builder(this).setMessage("Hanuman Chalisa 5.0 by Animesh Chakraborty.").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show().setCancelable(false);


            default:
                break;
        }
        return true;
    }

    private void playSong(int index) {
        try {
            mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[index]);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /*********************************    Back space alert dialog  ***************************** */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)

                .setCancelable(false)
                .setIcon(R.drawable.hanumanbest)
                .setTitle("Exit?")
                .setMessage("Do you really want to exit this application?")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                       // Toast.makeText(HomeActivity.this, "You clicked on 'YES' button", Toast.LENGTH_SHORT).show();
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        finish();
                        //close();
                    }





                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                })
                .show();
    }

    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hanuman Chalisa (HD Audio)-");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey! Check out this app Hanuman Chalisa app!https://play.google.com/store/apps/details?id=com.durga.bumba.hanumanchalisa ");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}



