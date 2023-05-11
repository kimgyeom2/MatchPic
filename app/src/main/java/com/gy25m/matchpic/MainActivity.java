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
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView start,how,board,iv1,iv2,iv3,iv4,iv5;

    SoundPool sp;
    int sdStart,sdAgain,sdGood,sdSelect;

    ArrayList<Integer> arr=new ArrayList<>();
    ArrayList<Integer> arr2=new ArrayList<>();
    ArrayList<ImageView> ivs=new ArrayList<>();
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

        ivs.add(iv1);
        ivs.add(iv2);
        ivs.add(iv3);
        ivs.add(iv4);
        ivs.add(iv5);

        SoundPool.Builder builder2=new SoundPool.Builder();
        sp=builder2.build();

        sdStart=sp.load(this,R.raw.s_sijak,0);
        sdAgain=sp.load(this,R.raw.s_again,0);
        sdGood=sp.load(this,R.raw.s_goodjob,0);
        sdSelect=sp.load(this,R.raw.s_select,0);

        arr.add(R.drawable.a_ele);
        arr.add(R.drawable.a_lion);
        arr.add(R.drawable.a_monkey);
        arr.add(R.drawable.a_pig);
        arr.add(R.drawable.a_frog);
        arr2.add(R.drawable.b_ele);
        arr2.add(R.drawable.b_lion);
        arr2.add(R.drawable.b_monkey);
        arr2.add(R.drawable.b_pig);
        arr2.add(R.drawable.b_frog);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdSelect,1,1,1,0,1);
                if(true) {

                    sp.play(sdGood,1,1,1,0,1);


                }else{
                    sp.play(sdAgain,1,1,1,0,1);
                }
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(arr);
                Collections.shuffle(arr2);
                for (int a=0;a<5;a++){
                    ivs.get(a).setImageResource(arr.get(a));
                }
                iv1.setTag(arr.get(0));
                iv2.setTag(arr.get(1));
                iv3.setTag(arr.get(2));
                iv4.setTag(arr.get(3));
                iv5.setTag(arr.get(4));



                board.setImageResource(arr2.get(0));
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