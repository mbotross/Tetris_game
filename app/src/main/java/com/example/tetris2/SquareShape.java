package com.example.tetris2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SquareShape extends Shape {

    Paint paint=new Paint();



   public Board board;
   int color;
   public Rect [] store=new Rect [4];


   //Rect test=new Rect(100,100,200,200);
    int x=0, y=0;
    int z=0,i=0;


    public SquareShape(Board board){
        super(Color.YELLOW,board);

        color=Color.YELLOW;
        xbound1=4;
        xbound2=-4;
        ybound=11;

        this.board=board;

    }



    public void init(){

        store[0]=board.tetrisboard[4][0];
        store[1]=board.tetrisboard[5][0];
        store[2]=board.tetrisboard[4][1];
        store[3]=board.tetrisboard[5][1];




    }



    @Override
    public void draw(Canvas canvas) {


        paint.setColor(Color.YELLOW);




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







    @Override
    public void update(int x,int y, int rotate){


        if(z<ybound &&  board.paintArray[4 + x][1 + z +1]==board.BOARDCOLOR &&
        board.paintArray[5 + x][1 + z + 1]==board.BOARDCOLOR) {

            System.out.println("Z:"+z);
            z = z + 1;
            System.out.println("HEREEEEEE");
            System.out.println("xcoord" + xcoord);

            System.out.println("OLD:" + old);

            //checking right
            for(int i=0;i<4;i++){
                xlist[i]=5+x;
            }

            ylist[0]=z;
            ylist[1]=1+z;
            ylist[2]=z;
            ylist[3]=1+z;
            //checking left
            for(int i=0;i<4;i++){
                xlist2[i]=4+x;
            }
            ylist2[0]=z;
            ylist2[1]=1+z;
            ylist2[2]=z;
            ylist2[3]=1+z;


            store[0] = board.tetrisboard[4 + x][z ];
            store[1] = board.tetrisboard[5 + x][z ];
            store[2] = board.tetrisboard[4 + x][1 + z ];
            store[3] = board.tetrisboard[5 + x][1 + z ];





        }

        if (z== ybound || (board.paintArray[5 + x][z + 2] != board.BOARDCOLOR || board.paintArray[4 + x][2 + z ] != board.BOARDCOLOR)) {

            board.paintArray[4 + x][z]=color;
            board.paintArray[5 + x][z ]=color;
            board.paintArray[4 + x][1 + z ]=color;
            board.paintArray[5 + x][1 + z ]=color;
            clear = 1;
        }


        }







    }

