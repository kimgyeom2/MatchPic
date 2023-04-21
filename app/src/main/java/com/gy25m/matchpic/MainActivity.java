package com.gy25m.matchpic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView start,how,board,iv1,iv2,iv3,iv4,iv5,ele,mon,lion,pig,fro;

    SoundPool sp;
    int sdStart,sdAgain,sdGood,sdSelect;
    Integer p=0;
    ArrayList<Integer> nums=new ArrayList<>();
    int[] imgs2=new int[]{R.drawable.b_ele,R.drawable.b_frog,
            R.drawable.b_lion,R.drawable.b_monkey,R.drawable.b_pig};
    int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        how=findViewById(R.id.how);
        board=findViewById(R.id.board);
        iv1=findViewById(R.id.iv1);
        iv2=findViewById(R.id.iv2);
        iv3=findViewById(R.id.iv3);
        iv4=findViewById(R.id.iv4);
        iv5=findViewById(R.id.iv5);

        SoundPool.Builder builder2=new SoundPool.Builder();
        sp=builder2.build();

        sdStart=sp.load(this,R.raw.s_sijak,0);
        sdAgain=sp.load(this,R.raw.s_again,0);
        sdGood=sp.load(this,R.raw.s_goodjob,0);
        sdSelect=sp.load(this,R.raw.s_select,0);

        ImageView[] ivs=new ImageView[]{iv1,iv2,iv3,iv4,iv5};

        int[] imgs=new int[]{R.drawable.a_ele,R.drawable.a_frog,
                R.drawable.a_lion,R.drawable.a_monkey,R.drawable.a_pig};


        for(int n=0;n<=4;n++) {
            nums.add(n);

        }
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdSelect,1,1,1,0,1);
                if(p==view.getTag()) {
                    k++;
                    p++;
                    board.setImageResource(imgs2[k]);
                    sp.play(sdGood,1,1,1,0,1);
                    Collections.shuffle(nums);
                    for(int n=0;n<=4;n++) {
                        ivs[nums.get(n)].setTag(n);
                        ivs[nums.get(n)].setImageResource(imgs[n]);
                    }
                }else{
                    sp.play(sdAgain,1,1,1,0,1);
                }
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int n=0;n<=4;n++) {
                    ivs[nums.get(n)].setTag(n);
                    ivs[nums.get(n)].setImageResource(imgs[n]);
                    ivs[n].setOnClickListener(listener);
                }
                how.setVisibility(View.GONE);
                board.setImageResource(imgs2[k]);
                sp.play(sdStart,1,1,1,0,1);

            }
        });

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setView(R.layout.how);
        AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }

        });

    }

}