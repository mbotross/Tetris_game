package com.example.tetris2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public  class Shape {

    Board board;
    int z=0;
    Paint paint=new Paint();
    int color;
    int clear;
    int xcoord=0,ycoord=0;
    int xbound1,xbound2;
    int ybound;
    int boolvar, old;
    int xlist[]=new int [4];
    int ylist[]=new int [4];
    int xlist2[]=new int [4];
    int ylist2[]=new int [4];

    ArrayList<Integer> xcoordarr=new ArrayList<Integer>();
    public Shape(int color, Board board){
        this.board=board;
        this.paint=paint;
        this.color=color;

    }


    public Rect[] store=new Rect [4];
    public Boolean[] checkbool=new Boolean[4];



    public void draw(Canvas canvas) {
        //Paint paint=new Paint();
       // Paint paint2=new Paint();
        paint.setColor(color);
        //paint2.setColor(Color.GRAY);



        if(z==0){
            init();

            canvas.drawRect(store[0], paint);
            canvas.drawRect(store[1], paint);
            canvas.drawRect(store[2], paint);
            canvas.drawRect(store[3], paint);}




        if (z>0 && z<13) {

            /*for (int i = 0; i < 4; i++) {
                canvas.drawRect(store[i], paint2);
            }*/


            for (int i = 0; i < 4; i++) {
                //  canvas.drawRect(store[i],paint2);
                canvas.drawRect(store[i], paint);
            }




        }








    }
    public Boolean rightCheck(int xlist[],int ylist[]){
        int check=0;
        int tempx;
        int tempy;
        Boolean val=false;

        for(int i=0;i<4;i++) {
            tempx = xlist[i] + 1;
            tempy = ylist[i];

            System.out.println("right check:" + tempx);
            System.out.println("right check2" + ylist[0]);
            if (board.paintArray[tempx][tempy] == board.BOARDCOLOR) {
                check++;
            }

        }
            if(check==4){
                val=true;

            }
            else{
                val=false;
            }






        return val;
    }



    public Boolean leftCheck(int xlist[],int ylist[]){
        int check=0;
        int tempx;
        int tempy;
        Boolean val=false;

        for(int i=0;i<4;i++) {
            tempx = xlist2[i] - 1;
            tempy = ylist2[i];


            System.out.println("right check:" + tempx);
            System.out.println("right check2" + ylist[0]);
            if (board.paintArray[tempx][tempy] == board.BOARDCOLOR) {
                check++;
            }

        }
        if(check==4){
            val=true;

        }
        else{
            val=false;
        }






        return val;
    }


    int checkrotate(Boolean[] x){
        int check=0;




        return check;


    }



    public void update(int xcoord,int ycoord,int rotate){

    }
    public void init(){




    }



}
