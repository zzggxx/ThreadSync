package com.l.thread;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String s1 = "筷子左";
    private static String s2 = "筷子右";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread() {
            public void run() {
                while (true) {
                    synchronized (s1) {
                        System.out.println(getName() + "...拿到" + s1 + "等待" + s2);
                        synchronized (s2) {
                            System.out.println(getName() + "...拿到" + s2 + "开吃");
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println(getName() + "...拿到" + s2 + "等待" + s1);
                        synchronized (s1) {
                            System.out.println(getName() + "...拿到" + s1 + "开吃");
                        }
                    }
                }
            }
        }.start();
    }
}