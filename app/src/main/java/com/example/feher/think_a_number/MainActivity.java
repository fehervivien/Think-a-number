package com.example.feher.think_a_number;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button_plus, button_minus, button_send;
    private TextView number;
    private ImageView imgV_1,imgV_2,imgV_3,imgV_4,imgV_5;
    private int kitalalando_szam = 0, tippeltszam = 0;
    private int eletek = 5;

    private AlertDialog.Builder alert_vege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        alert_vege = new AlertDialog.Builder(MainActivity.this);


        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(50) + 1;

        button_plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (tippeltszam < 50) {
                    tippeltszam++;
                }
                number.setText("" + tippeltszam);
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                if (tippeltszam > 0) {

                    tippeltszam--;
                }
                number.setText("" + tippeltszam);
            }

        });


        button_send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (tippeltszam == kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Nyertél! *-*", Toast.LENGTH_SHORT).show();
                    jatek_vege_nyertel();

                } else if (tippeltszam > kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Lejjebb!", Toast.LENGTH_SHORT).show();
                    elet();

                } else if (tippeltszam < kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Feljebb!", Toast.LENGTH_SHORT).show();
                    elet();
                }

            }

        });

    }

    private void init() {
        button_plus = (Button) findViewById(R.id.button_plus);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_send = (Button) findViewById(R.id.button_send);

        number = (TextView) findViewById(R.id.textView_szam);
        imgV_1 = (ImageView) findViewById(R.id.imageView1);
        imgV_2 = (ImageView) findViewById(R.id.imageView2);
        imgV_3 = (ImageView) findViewById(R.id.imageView3);
        imgV_4 = (ImageView) findViewById(R.id.imageView4);
        imgV_5 = (ImageView) findViewById(R.id.imageView5);

    }

    public void elet() {

        eletek--;

        switch (eletek) {

            case 0:
                imgV_1.setImageResource(R.drawable.heart1);
                jatek_vege_vesztettel();
                break;

            case 1:
                imgV_2.setImageResource(R.drawable.heart1);
                break;

            case 2:
                imgV_3.setImageResource(R.drawable.heart1);
                break;

            case 3:
                imgV_4.setImageResource(R.drawable.heart1);
                break;

            case 4:
                imgV_5.setImageResource(R.drawable.heart1);
                break;
        }
    }

    public void new_game() {
        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(50) + 1;
        tippeltszam = 0;
        number.setText("" + tippeltszam);
        eletek = 5;
        imgV_1.setImageResource(R.drawable.heart2);
        imgV_2.setImageResource(R.drawable.heart2);
        imgV_3.setImageResource(R.drawable.heart2);
        imgV_4.setImageResource(R.drawable.heart2);
        imgV_5.setImageResource(R.drawable.heart2);
    }


    public void jatek_vege_vesztettel() {
        alert_vege.setTitle("Vesztettél! :(")
                .setMessage("Újra akarod kezdeni a játékot? :)")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();
                    }
                })
                .setCancelable(false)
                .create();
        alert_vege.show();
    }
    public void jatek_vege_nyertel() {
        alert_vege.setTitle("Ez az nyertél! :D ")
                .setMessage("Újra akarod kezdeni a játékot? :)")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();
                    }
                })
                .setCancelable(false)
                .create();
        alert_vege.show();
    }
}
