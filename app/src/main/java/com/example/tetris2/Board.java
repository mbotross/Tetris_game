package com.example.tetris2;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;


public class Board {

    public Rect tetrisboard[][];
    public static final int BOARDCOLOR=Color.BLACK;

    public boolean boolarr[][]=new boolean[10][13];

    Paint paint = new Paint();
    int paintArray[][]=new int [10][13];

    int color;

    public int score;



    public int newshape;

    private Rect square = new Rect();



    int left=100;

    int top=100;

    int right=185;

    int bottom=185;





    public Board(int width, int height) {

        this.tetrisboard = new Rect[width][height];
        for (int j = 0; j < 13; j++) { //can reduce this later for buttons etc

            for (int i = 0; i < 10; i++) {
                paintArray[i][j] = BOARDCOLOR;
                System.out.println("paint"+paintArray[i][j]);
            }


        }
    }




    public void draw2(Canvas canvas){

        ArrayList<Integer> cleared=new ArrayList<Integer>();
        BottomCheck();
        paint.setColor(BOARDCOLOR);
        for(int i=0;i<cleared.size();i++){
            for(int j=0;j<10;j++){
                canvas.drawRect(tetrisboard[j][cleared.get(i)],paint);
            }
        }



    }

    public void draw1(Canvas canvas) {


        paint.setColor(BOARDCOLOR);


        paint.setStyle(Paint.Style.FILL);
        BottomCheck();







        int left=100;

        int top=100;

        int right=185;

        int bottom=185;



        for(int j = 0; j < 13; j++){ //can reduce this later for buttons etc

            for(int i = 0; i<10; i++){



                //square.set(left,top,right,bottom);

                tetrisboard[i][j] = new Rect(left,top,right,bottom);
                color=paintArray[i][j];
                paint.setColor(color);

                canvas.drawRect(tetrisboard[i][j],paint);

                left=left+90;

                right=right+90;



                if (right>=canvas.getWidth()-70){

                    left=100;

                    right=185;

                    top=top+90;

                    bottom=bottom+90;

                }







            }

        }

    }
    public void BottomCheck() {

        int check = 0;
        int checkcount = 0;
        ArrayList<Integer> clearrow = new ArrayList<Integer>();

        //  isFilled = true;
        for (int j = 0; j < 13; j++) {
            for (int i = 0; i < 10; i++) {
                if (paintArray[i][j]!=BOARDCOLOR) {
                    checkcount++;
                    System.out.println("CHECKCOUNT:"+checkcount);
                }
                if (i == 9 && checkcount != 10) {
                    checkcount = 0;
                }
                if (i == 9 && checkcount == 10) {
                    System.out.println("IM HERE");
                    clearrow.add(j);

                    for(int l=0;l<clearrow.size();l++){
                        System.out.println("CLEAR ROW="+ clearrow.get(l));
                    }
                    checkcount = 0;
                }

            }
        }
       if(clearrow.size()!=0) {
           System.out.println("HEREEEE HELLOOOOOOO");
           for (int k = 0; k < clearrow.size(); k++) {
               int rownumber = clearrow.get(k);
               System.out.println("ROW NUMBER=" + rownumber);
               for (int j = rownumber; j > 0; j--) {
               // for (int j = rownumber; j > rownumber-2; j--){
                   for (int i = 0; i < 10; i++) {

                      paintArray[i][j] = paintArray[i][j - 1];
                       //System.out.println("Maybe?");
                   }
               }
           }


       }
        for(int i=0;i<clearrow.size();i++){
            clearrow.remove(i);
        }


       // return clearrow;
    }



    public boolean ClearRow(){

        //see if row is filled with 1's then clear the row

        int j = 0;

        int fullRow = 0;

        while (j < 10){

            for (int i = 0; i < 13; i++){

                if(boolarr[i][j] == true){

                    fullRow++;
                }
                if(fullRow == 13){

                    //'delete' row and shift everything above down one row
                }

            }

            j++;

        }



        return true;



    }





}