package com.example.app.HanTu;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.app.Question.Question;
import com.example.app.Question.QuestionController;
import com.example.app.R;
import com.example.app.Slide.CheckAnswerAdapter;
import com.example.app.Slide.ScreenSlideActivity;
import com.example.app.Slide.ScreenSlidePageFragment;
import com.example.app.Slide.TestDoneActivity;
import com.example.app.ui.OnTap.OnTapFragment;
import com.example.app.ui.TestKanjiN5.TestKanjiN5Fragment;
import com.example.app.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class HanTuSlideActivity extends FragmentActivity {

    private static final int NUM_PAGES = 10;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    TextView tvLuyenTap, tvThoat;

    String subject;
    int num_exam;

    String test="";

    //CSDL
    HanTuController hanTuController;
    ArrayList<HanTu> arr_Ques;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_han_tu_slide);



        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new HanTuSlideActivity.HanTuScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new HanTuSlideActivity.DepthPageTransformer());


        Intent intent = getIntent();
        subject = intent.getStringExtra("subject");
        num_exam = intent.getIntExtra("num_exam", 0);
        test= intent.getStringExtra("test");


        hanTuController = new HanTuController(this);
        arr_Ques = new ArrayList<HanTu>();


        if(test.equals("yes")==true) {
            arr_Ques = hanTuController.getKanji(num_exam, subject);
        }else{
            arr_Ques= (ArrayList<HanTu>) intent.getExtras().getSerializable("arr_Ques");
        }

        tvLuyenTap = (TextView) findViewById(R.id.tvLuyenTap);
        tvThoat = (TextView) findViewById(R.id.tvExit);

        tvLuyenTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getSupportFragmentManager().beginTransaction().replace(R.id.container2,new TestKanjiN5Fragment()).commit();
            }
        });

        tvThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialogExit();
            }
        });


    }

    public ArrayList<HanTu> getData() {
        return arr_Ques;
    }

    @Override
    public void onBackPressed() {       //ham tuong tu nut back quay ve
        if (mPager.getCurrentItem() == 0) {
            dialogExit(); //quay ve trang 0 maf back nua thi thoat
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void dialogExit(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(HanTuSlideActivity.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }

    private class HanTuScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public HanTuScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return HanTuSlideFragment.create(position); //kiem tra cau tra loi khac 0
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }






}