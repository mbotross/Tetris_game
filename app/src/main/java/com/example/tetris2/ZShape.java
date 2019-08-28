package com.example.tetris2;

import android.graphics.Color;

public class ZShape extends Shape {


    public ZShape(Board board){
        super(Color.RED,board);
        color=Color.RED;

        this.board=board;

    }


    public void init(){

        store[0]=board.tetrisboard[4][0];
        store[1]=board.tetrisboard[5][0];
        store[2]=board.tetrisboard[5][1];
        store[3]=board.tetrisboard[6][1];



    }


    @Override
    public void update(int x,int y, int rotate){





        if(rotate==1 || rotate==3 ) {
            ybound=11;
            xbound1=3;
            xbound2=-4;
            if((z)<ybound){
                z++;


                xlist[0]=5+x;
                xlist[1]=6+x;
                xlist[2]=5+x;
                xlist[3]=6+x;

                ylist[0]=z;
                ylist[1]=z+1;
                ylist[2]=z;
                ylist[3]=z+1;

                xlist2[0]=4+x;
                xlist2[1]=5+x;
                xlist2[2]=4+x;
                xlist2[3]=5+x;

                ylist2[0]=z;
                ylist2[1]=z+1;
                ylist2[2]=z;
                ylist2[3]=z+1;


                store[0] = board.tetrisboard[4 + xcoord][0 + z];
            store[1] = board.tetrisboard[5 + xcoord][0 + z];
            store[2] = board.tetrisboard[5 + xcoord][1 + z];
            store[3] = board.tetrisboard[6 + xcoord][1 + z];}


            if((z)==ybound || board.paintArray[5+xcoord][1+z+1]!=board.BOARDCOLOR|| board.paintArray[6+xcoord][1+z+1]!=board.BOARDCOLOR||board.paintArray[4+xcoord][0+z+1]!=board.BOARDCOLOR){
                board.paintArray[4 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][1+ z]=color;
                board.paintArray[6 + xcoord][1 + z]=color;
                clear=1;


            }



        }

        else if(rotate==2 ||rotate ==4){
            ybound=10;
            xbound1=4;
            xbound2=-4;
            if((z)<ybound){
                z++;

                xlist[0]=5+x;
                xlist[1]=5+x;
                xlist[2]=4+x;
                xlist[3]=5+x;

                ylist[0]=z;
                ylist[1]=z+1;
                ylist[2]=z+2;
                ylist[3]=z;

                xlist2[0]=5+x;
                xlist2[1]=4+x;
                xlist2[2]=4+x;
                xlist2[3]=5+x;

                ylist2[0]=z;
                ylist2[1]=z+1;
                ylist2[2]=z+2;
                ylist2[3]=z;

            store[0] = board.tetrisboard[5 + xcoord][0 + z];
            store[1] = board.tetrisboard[5 + xcoord][1 + z];
            store[2] = board.tetrisboard[4 + xcoord][1 + z];
            store[3] = board.tetrisboard[4 + xcoord][2 + z];}

            if((z)==ybound || board.paintArray[5+xcoord][1+z+1]!=board.BOARDCOLOR|| board.paintArray[4+xcoord][2+z+1]!=board.BOARDCOLOR){
                board.paintArray[5 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][1 + z]=color;
                board.paintArray[4 + xcoord][1+ z]=color;
                board.paintArray[4 + xcoord][2 + z]=color;
                clear=1;

            }






        }


    }


}
