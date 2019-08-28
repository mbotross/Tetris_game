package com.example.tetris2;

import android.graphics.Color;

public class IShape extends Shape {


    Board board;





  //  Shape shape=new Shape(5,5,5,5,0,1,2,3,Color.BlUE);

    public IShape(Board board){

        super(Color.rgb(149,200,206),board);
        color=Color.rgb(149,200,206);


        this.board=board;
    }




    @Override
    public void update(int x,int y, int rotate){

        //top of the board cases set equal to one if there is no more space for blocks to be put

            if (rotate == 2 || rotate == 4) {

                xbound1 = 4;
                xbound2 = -5;
                ybound=9;
                if((z)<ybound && board.paintArray[5+x][3+z+1]==board.BOARDCOLOR) {

                    //xcoordarr.add(x);
                    //if (board.paintArray[5 + x][3 + z + 1] == false) {

                    z = z + 1;
                    for(int i=0;i<4;i++){
                        xlist[i]=5+x;
                        xlist2[i]=5+x;
                    }
                    int k=0;
                    for(int i=0;i<4;i++){
                        ylist[i]=k+z;
                        ylist2[i]=k+z;
                        k++;
                        
                    }
                    store[0] = board.tetrisboard[5 + x][0 + z];
                    store[1] = board.tetrisboard[5 + x][1 + z];
                    store[2] = board.tetrisboard[5 + x][2 + z];
                    store[3] = board.tetrisboard[5 + x][3 + z];

                    }

                    if ((z) >= 9 || board.paintArray[5 + x][3 + z + 1 + y] !=board.BOARDCOLOR) {
                        board.paintArray[5 + x][0 + z] = color;
                        board.paintArray[5 + x][1 + z] = color;
                        board.paintArray[5 + x][2 + z] = color;
                        board.paintArray[5 + x][3 + z] = color;

                        clear = 1;
                    }


                //else if(board.paintArray[5 + x][3 + z + 1] !=board.BOARDCOLOR){
                //clear=1;}
            } else if (rotate == 1 || rotate == 3) {
                xbound1 = 2;
                xbound2 = -4;
                ybound = 12;
                if ((z) < ybound) {
                    //  if (board.paintArray[4 + x][0 + z + 1] == false && board.paintArray[5 + x][0 + z + 1] == false
                    //        && board.paintArray[6 + x][0 + z + 1] == false && board.paintArray[7 + x][0 + z + 1] == false) {

                    z++;
                    for(int i=0;i<4;i++){
                        xlist[i]=7+x;
                    }
                    for(int i=0;i<4;i++){
                        xlist2[i]=4+x;
                    }
                    for(int i=0;i<4;i++){
                        ylist[i]=z;
                        ylist2[i]=z;
                    }
                    store[0] = board.tetrisboard[4 + x][0 + z];
                    store[1] = board.tetrisboard[5 + x][0 + z];
                    store[2] = board.tetrisboard[6 + x][0 + z];
                    store[3] = board.tetrisboard[7 + x][0 + z];
                }


                    if ((z)>= 12 || board.paintArray[4 + x][0 + z + 1] !=board.BOARDCOLOR || board.paintArray[5 + x][0 + z + 1] !=board.BOARDCOLOR
                            || board.paintArray[6 + x][0 + z + 1] !=board.BOARDCOLOR || board.paintArray[7 + x][0 + z + 1] !=board.BOARDCOLOR) {
                        board.paintArray[4 + x][0 + z] = color;
                        board.paintArray[5 + x][0 + z] = color;
                        board.paintArray[6 + x][0 + z] = color;
                        board.paintArray[7 + x][0 + z] = color;
                        clear = 1;
                    }

                }
            }


       //    else if( board.paintArray[4 + x][0 + z + 1] !=board.BOARDCOLOR || board.paintArray[5 + x][0 + z + 1] !=board.BOARDCOLOR
         //           || board.paintArray[6 + x][0 + z + 1] !=board.BOARDCOLOR || board.paintArray[7 + x][0 + z + 1] !=board.BOARDCOLOR){
           //    clear=1;
             //   }







    @Override
    public void init() {
            store[0]=board.tetrisboard[4][0];
            store[1]=board.tetrisboard[5][0];
            store[2]=board.tetrisboard[6][0];
            store[3]=board.tetrisboard[7][0];



    }
}
