package com.example.tetris2;

import android.graphics.Color;

public class TShape extends Shape {

    Board board;



    public TShape(Board board){
        super(Color.MAGENTA,board);
        color=Color.MAGENTA;

        this.board=board;
    }



    @Override
    public void update(int x, int y,int rotate) {

        if(rotate==1 ) {
            ybound=11;
            xbound1=4;
            xbound2=-3;
            if((z)<ybound){
                z=z+1;
                //right check
                xlist[0]=5+xcoord;
                xlist[1]=4+xcoord;
                xlist[2]=5+xcoord;
                xlist[3]=4+xcoord;

                ylist[0]=z;
                ylist[1]=1+z;
                ylist[2]=z;
                ylist[3]=1+z;

                //left check
                xlist2[0]=3+xcoord;
                xlist2[1]=4+xcoord;
                xlist2[2]=3+xcoord;
                xlist2[3]=4+xcoord;

                ylist2[0]=z;
                ylist2[1]=1+z;
                ylist2[2]=z;
                ylist2[3]=1+z;

            store[0] = board.tetrisboard[3 + xcoord][0 + z];
            store[1] = board.tetrisboard[4 + xcoord][0 + z];
            store[2] = board.tetrisboard[5 + xcoord][0 + z];
            store[3] = board.tetrisboard[4 + xcoord][1 + z];}

            if((z)==ybound || board.paintArray[3+xcoord][0+z+1]!=board.BOARDCOLOR|| board.paintArray[5+xcoord][0+z+1]!=board.BOARDCOLOR||board.paintArray[4+xcoord][1+z+1]!=board.BOARDCOLOR){
                board.paintArray[3 + xcoord][0 + z]=color;
                board.paintArray[4 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][0 + z]=color;
                board.paintArray[4 + xcoord][1 + z]=color;
                clear=1;


            }

        }

        else if(rotate==2){
            ybound=10;
            xbound1=4;
            xbound2=-4;
            if((z)<ybound){


            z=z+1;
            //right check
            for(int i=0;i<4;i++){
                xlist[i]=5+xcoord;
            }
            int k=0;
            for(int i=0;i<3;i++){

                ylist[i]=k+z;
            }

            ylist[3]=z;

            //left check
                xlist2[0]=5+xcoord;
                ylist2[0]=z;
                xlist2[1]=4+xcoord;
                ylist2[1]=1+z;
                xlist2[2]=5+xcoord;
                ylist2[2]=2+z;
                xlist[3]=5+xcoord;
                ylist[3]=z;

            store[0] = board.tetrisboard[5+ xcoord][0 + z];
            store[1] = board.tetrisboard[5 + xcoord][1+ z];
            store[2] = board.tetrisboard[5 + xcoord][2 + z];
            store[3] = board.tetrisboard[4 + xcoord][1 + z];}

            if((z)==ybound || board.paintArray[4+xcoord][1+z+1]!=board.BOARDCOLOR|| board.paintArray[5+xcoord][2+z+1]!=board.BOARDCOLOR){
                board.paintArray[5 + xcoord][0 + z]=color;
                board.paintArray[5 + xcoord][1 + z]=color;
                board.paintArray[5 + xcoord][2 + z]=color;
                board.paintArray[4 + xcoord][1 + z]=color;
                clear=1;


            }





        }

        else if(rotate==3){
            ybound=11;

            xbound1=4;
            xbound2=-3;
            if((z)<ybound){
                z=z+1;

                xlist[0]=4+ xcoord;
                xlist[1]=5+xcoord;
                xlist[2]=4+xcoord;
                xlist[3]=5+xcoord;
                ylist[0]=z;
                ylist[1]=1+z;
                ylist[2]=z;
                ylist[3]=1+z;

                xlist2[0]=4+ xcoord;
                xlist2[1]=3+xcoord;
                xlist2[2]=4+xcoord;
                xlist2[3]=3+xcoord;
                ylist2[0]=z;
                ylist2[1]=1+z;
                ylist2[2]=z;
                ylist2[3]=1+z;


            store[0] = board.tetrisboard[4+ xcoord][0 + z];
            store[1] = board.tetrisboard[3 + xcoord][1+ z];
            store[2] = board.tetrisboard[4 + xcoord][1 + z];
            store[3] = board.tetrisboard[5 + xcoord][1 + z];}

            if((z)==ybound || board.paintArray[3+xcoord][1+z+1]!=board.BOARDCOLOR|| board.paintArray[5+xcoord][1+z+1]!=board.BOARDCOLOR||board.paintArray[4+xcoord][1+z+1]!=board.BOARDCOLOR){
                board.paintArray[4 + xcoord][0 + z]=color;
                board.paintArray[3 + xcoord][1 + z]=color;
                board.paintArray[4 + xcoord][1 + z]=color;
                board.paintArray[5 + xcoord][1 + z]=color;
                clear=1;

            }






        }
        else if(rotate==4){
            ybound=10;

            xbound1=5;
            xbound2=-3;
            if(z<ybound){
                z=z+1;
                for(int i=0;i<3;i++){
                    xlist[i]=3+xcoord;
                }
                xlist[3]=4+xcoord;

                ylist[0]=z;
                ylist[1]=1+z;
                ylist[2]=z;
                ylist[3]=1+z;

                for(int i=0;i<4;i++){
                    xlist2[i]=3+xcoord;
                }
                int k=0;
                for(int i=0;i<4;i++){
                    ylist2[i]=k+z;
                }

            store[0] = board.tetrisboard[3+ xcoord][0 + z];
            store[1] = board.tetrisboard[3 + xcoord][1+ z];
            store[2] = board.tetrisboard[3 + xcoord][2 + z];
            store[3] = board.tetrisboard[4 + xcoord][1 + z];}


            if((z)==ybound || board.paintArray[3+xcoord][2+z+1]!=board.BOARDCOLOR|| board.paintArray[4+xcoord][1+z+1]!=board.BOARDCOLOR ){
                board.paintArray[3 + xcoord][0 + z]=color;
                board.paintArray[3 + xcoord][1 + z]=color;
                board.paintArray[3 + xcoord][2 + z]=color;
                board.paintArray[4 + xcoord][1 + z]=color;
                clear=1;
            }


        }






    }

    @Override
    public void init() {
        store[0]=board.tetrisboard[3][0];
        store[1]=board.tetrisboard[4][0];
        store[2]=board.tetrisboard[5][0];
        store[3]= board.tetrisboard[4][1];

    }
}
