package com.example.tetris2;


import android.graphics.Color;

public class LShape extends Shape {

    public LShape(Board board){
        super(Color.BLUE,board);
        color=Color.BLUE;
        this.board=board;

    }

    @Override
    public void update(int x, int y,int rotate) {

        if (rotate == 1) {
            ybound=11;
            xbound1 = 4;
            xbound2 = -3;

            if((z)<ybound){
                z++;


             for(int i=0;i<3;i++){
                 xlist[i]=5+x;
                 ylist[i]=1+z;

             }
             xlist[3]=3+x;
             ylist[3]=z;
             for(int i=0;i<4;i++){
                 xlist2[i]=3+x;
             }


             ylist2[0]=z;
             ylist2[1]=1+z;
             ylist2[2]=z;
             ylist2[3]=1+z;


            store[0] = board.tetrisboard[3 + xcoord][0 + z];
            store[1] = board.tetrisboard[3 + xcoord][1 + z];
            store[2] = board.tetrisboard[4 + xcoord][1 + z];
            store[3] = board.tetrisboard[5 + xcoord][1 + z];}

            if((z)==ybound || board.paintArray[3+xcoord][1+z+1]!=board.BOARDCOLOR|| board.paintArray[4+xcoord][1+z+1]!=board.BOARDCOLOR||board.paintArray[5+xcoord][1+z+1]!=board.BOARDCOLOR){
                board.paintArray[3 + xcoord][0 + z]=color;
                board.paintArray[3 + xcoord][1 + z]=color;
                board.paintArray[4 + xcoord][1+ z]=color;
                board.paintArray[5 + xcoord][1 + z]=color;
                clear=1;

            }


        } else if (rotate == 2) {
            ybound=10;
            xbound1 = 5;
            xbound2 = -3;
            if((z)<ybound){
                z++;

             xlist[0]=4+x;
             xlist[1]=3+x;
             xlist[2]=3+x;
             xlist[3]=4+x;

             ylist[0]=z;
             ylist[1]=1+z;
             ylist[2]=2+z;
             ylist[3]=z;

                for(int i=0;i<4;i++){
                    xlist2[i]=3+x;
                }
                int k=0;
                for(int i=0;i<3;i++){
                    ylist2[i]=k+z;
                    k++;
                }
                ylist2[3]=z;

            store[0] = board.tetrisboard[4 + xcoord][0 + z];
            store[1] = board.tetrisboard[3 + xcoord][0 + z];
            store[2] = board.tetrisboard[3 + xcoord][1 + z];
            store[3] = board.tetrisboard[3 + xcoord][2 + z];}

            if((z)==ybound || board.paintArray[4+xcoord][0+z+1]!=board.BOARDCOLOR|| board.paintArray[3+xcoord][2+z+1]!=board.BOARDCOLOR){
                board.paintArray[4 + xcoord][0 + z]=color;
                board.paintArray[3 + xcoord][0 + z]=color;
                board.paintArray[3 + xcoord][1+ z]=color;
                board.paintArray[3 + xcoord][2 + z]=color;
                clear=1;

            }



        } else if (rotate == 3) {
            ybound=11;
            xbound1 = 4;
            xbound2 = -3;

            if((z)<ybound){
                z++;

             for(int i=0;i<4;i++){
                 xlist[i]=5+x;
             }

             ylist[0]=z;
             ylist[1]=z+1;
             ylist[2]=z;
             ylist[3]=z+1;

             xlist2[0]=3+x;
             xlist2[1]=5+x;
             xlist2[2]=3+x;
             xlist2[3]=5+x;

                ylist2[0]=z;
                ylist2[1]=z+1;
                ylist2[2]=z;
                ylist2[3]=z+1;

            store[0] = board.tetrisboard[3 + xcoord][0 + z];
            store[1] = board.tetrisboard[4 + xcoord][0 + z];
            store[2] = board.tetrisboard[5 + xcoord][0 + z];
            store[3] = board.tetrisboard[5 + xcoord][1 + z];}

            if((z)==ybound || board.paintArray[3+xcoord][0+z+1]!=board.BOARDCOLOR|| board.paintArray[4+xcoord][0+z+1]!=board.BOARDCOLOR|| board.paintArray[5+xcoord][1+z+1]!=board.BOARDCOLOR){
                board.paintArray[3 + xcoord][0 + z]=color;
                board.paintArray[4 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][0+ z]=color;
                board.paintArray[5 + xcoord][1 + z]=color;
                clear=1;

            }



        } else if (rotate == 4) {
            ybound=10;

            xbound1 = 4;
            xbound2 = -4;
            if((z)<ybound){
                z++;



             for(int i=0;i<4;i++){
                 xlist[i]=5+x;
             }
             int k=0;
             for(int i=0;i<3;i++){
                 ylist[i]=k+z;
                 k++;
             }


                xlist2[0]=5+x;
                xlist2[1]=5+x;
                xlist2[2]=4+x;
                xlist2[3]=5+x;

                ylist2[0]=z;
                ylist2[1]=z+1;
                ylist2[2]=z+2;
                ylist2[3]=z;

            store[0] = board.tetrisboard[5 + xcoord][0 + z];
            store[1] = board.tetrisboard[5 + xcoord][1 + z];
            store[2] = board.tetrisboard[5 + xcoord][2 + z];
            store[3] = board.tetrisboard[4 + xcoord][2 + z];}

            if((z)==ybound || board.paintArray[5+xcoord][2+z+1]!=board.BOARDCOLOR|| board.paintArray[4+xcoord][2+z+1]!=board.BOARDCOLOR){
                board.paintArray[5 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][1 + z]=color;
                board.paintArray[5 + xcoord][2+ z]=color;
                board.paintArray[4 + xcoord][2 + z]=color;
                clear=1;

            }


        }
    }



    @Override
    public void init() {
        store[0]=board.tetrisboard[3][0];
        store[1]=board.tetrisboard[3][1];
        store[2]=board.tetrisboard[4][1];
        store[3]= board.tetrisboard[5][1];


    }
    }
