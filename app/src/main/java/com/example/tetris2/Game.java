package com.example.tetris2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    public Tetris thread;
    private Board tetrisboard;
    private Shape tempshape;
    private TShape tshape;
    private IShape ishape;
    private int xcoord=0,ycoord=0;
    int score = 0;
    int counter=0;
    int number=1;
    int Sleeptime=600;
    ArrayList<Shape> shapelist=new ArrayList<Shape>();
    ArrayList<Bitmap>bitmaplist=new ArrayList<Bitmap>();

    Bitmap nextshape;
    Paint paint=new Paint();
    int rotate=1;

    public Game(Context context) {

        super(context);
        getHolder().addCallback(this);
        thread = new Tetris(this);



        tetrisboard=new Board(10,13);


        ishape=new IShape(tetrisboard);
        //tshape=new TShape(tetrisboard);
        shapelist.add(ishape);

        //tempshape=Random();
        tempshape=Random();



        shapelist.add(tempshape);
        System.out.println("LIST SIZE"+shapelist.size());

        setFocusable(true);

        //nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.squarepic);


            }

    public Game(Context context, AttributeSet attrs) {

        super(context,attrs);
        getHolder().addCallback(this);
        thread = new Tetris(this);


        tetrisboard=new Board(10,13);

        ishape=new IShape(tetrisboard);
        shapelist.add(ishape);
        //tshape=new TShape(tetrisboard);
        //tempshape=Random();
        tempshape=Random();


        //tempshape=Random();

       shapelist.add(tempshape);

        setFocusable(true);

       // nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.squarepic);


    }



    public void endgame(Canvas canvas){
       // Boolean result=false;
        Paint textpaint=new Paint();
        textpaint.setTextSize(300);
        textpaint.setColor(Color.WHITE);
        for(int i=3;i<7;i++){
            if(tetrisboard.paintArray[i][2]!=tetrisboard.BOARDCOLOR){
                canvas.drawText("Game Over!", 500, 500, textpaint);
               // result=true;
                thread.interrupt();

            }
        }
      //  thread.interrupt();
        //System.out.println("BOOLEAN VALUE"+ result);
        //return result;
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Tetris( this);
        thread.setRunning(true);
        thread.start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        thread.interrupt();
      /*  boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry=false;
        }*/


    }


   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
      //  return super.onTouchEvent(event);
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                x=(int)(event.getX());
                y=(int)(event.getY());
                //playerpoint.set((int)event.getX(),(int)event.getY());
                System.out.println("MOVEEE");
                System.out.println("x"+x);
                System.out.println("y"+y);

               break;
        }

        return true;
    }*/

    public void update(){


        if(shapelist.get(number).clear==0){
       shapelist.get(number).update(xcoord,ycoord,rotate);}
     // if(shapelist.get(number).clear==1){
       //shapelist.get(number+1).update(xcoord,ycoord,rotate);}


    }













            //if isFilled is still true then current row is filled




    //have random that would provide a new random shape
    //store that shape in the array list
    //draw the previous shape


    public Shape Random() {

        int randomnum;

        String NextPiece=new String();

        Random random = new Random();

        Shape piece=null;

        randomnum = random.nextInt(7);

       /* if(shapelist.size()==0){

            System.out.println("MEEEEE");

            SquareShape square=new SquareShape(tetrisboard);

            shapelist.add(square);



        }*/

        //  else {

        //piece=new SquareShape(tetrisboard);

        if (randomnum == 0) {

            NextPiece = "SQUARE";

            if(shapelist.size() != 1)

                nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.squarepic);

            else

                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            SquareShape square = new SquareShape(tetrisboard);

            shapelist.add(square);

            piece = shapelist.get(number - 1);

            // return square;

            //square.draw(canvas);



        } else if (randomnum == 1) {

            NextPiece = "ISHAPE";

            nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            IShape ishape = new IShape(tetrisboard);

            shapelist.add(ishape);

            piece = shapelist.get(number - 1);

            //return ishape;

            //ishape.draw(canvas);

        } else if (randomnum == 2) {

            if(shapelist.size() != 1)

                nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.tshapepic);

            else

                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            TShape tshape = new TShape(tetrisboard);

            shapelist.add(tshape);

            piece = shapelist.get(number - 1);

        } else if (randomnum == 3) {

            if(shapelist.size() != 1)

                nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.zshapepic);

            else

                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            ZShape zshape = new ZShape(tetrisboard);

            shapelist.add(zshape);

            piece = shapelist.get(number - 1);

        } else if (randomnum == 4) {

            if(shapelist.size() != 1)

                nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.sshapepic);

            else

                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            SShape sshape = new SShape(tetrisboard);

            shapelist.add(sshape);

            piece = shapelist.get(number - 1);

        } else if (randomnum == 5) {

            if(shapelist.size() != 1)

                nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.lshapepic1);

            else

                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            LShape lshape = new LShape(tetrisboard);

            shapelist.add(lshape);

            piece = shapelist.get(number - 1);

        } else if (randomnum == 6) {

            if(shapelist.size() != 1)

                nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.lshapepic2);

            else

                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);

            JShape jshape = new JShape(tetrisboard);

            shapelist.add(jshape);



            piece = shapelist.get(number - 1);

        }



        // }

        return piece;







    }

   /* public Shape Random() {
        int randomnum;
        String NextPiece=new String();
        Random random = new Random();
        Shape piece=null;
        randomnum = random.nextInt(7);
       /* if(shapelist.size()==0){
            System.out.println("MEEEEE");
            SquareShape square=new SquareShape(tetrisboard);
            shapelist.add(square);

        }*/
      //  else {
            //piece=new SquareShape(tetrisboard);
            /*if (randomnum == 0) {

                NextPiece = "SQUARE";
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.squarepic);
                SquareShape square = new SquareShape(tetrisboard);
                shapelist.add(square);
                piece = shapelist.get(number - 1);
                // return square;
                //square.draw(canvas);

            } else if (randomnum == 1) {
                NextPiece = "ISHAPE";
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.ishapepic);
                IShape ishape = new IShape(tetrisboard);
                shapelist.add(ishape);
                piece = shapelist.get(number - 1);
                //return ishape;
                //ishape.draw(canvas);
            } else if (randomnum == 2) {
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.tshapepic);
                TShape tshape = new TShape(tetrisboard);
                shapelist.add(tshape);
                piece = shapelist.get(number - 1);
            } else if (randomnum == 3) {
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.zshapepic);
                ZShape zshape = new ZShape(tetrisboard);
                shapelist.add(zshape);
                piece = shapelist.get(number - 1);
            } else if (randomnum == 4) {
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.sshapepic);
                SShape sshape = new SShape(tetrisboard);
                shapelist.add(sshape);
                piece = shapelist.get(number - 1);
            } else if (randomnum == 5) {
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.lshapepic1);
                LShape lshape = new LShape(tetrisboard);
                shapelist.add(lshape);
                piece = shapelist.get(number - 1);
            } else if (randomnum == 6) {
                nextshape = BitmapFactory.decodeResource(getResources(), R.drawable.lshapepic2);
                JShape jshape = new JShape(tetrisboard);
                shapelist.add(jshape);

                piece = shapelist.get(number - 1);
            }

       // }
            return piece;



    }
*/
    //pick random piece
    //call random function and put it in the array for the next piece
    //increment the array and draw the next piece
    //call random function again

    public void shiftRight() {



            if (shapelist.get(number).xcoord < shapelist.get(number).xbound1 &&
                    shapelist.get(number).rightCheck(shapelist.get(number).xlist, shapelist.get(number).ylist)) {
                //if(shapelist.get(number).checkbool==1)
                shapelist.get(number).xcoord++;
                xcoord=shapelist.get(number).xcoord;
                if(shapelist.get(number).clear==1){
                    xcoord=0;
                }

            //    shapelist.get(number).boolvar=xcoord-1;
            }



    }
    public void Down(){
        Sleeptime=300;
        try{
        thread.sleep(400);} catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sleeptime=600;




    }
    public void rotate(){
        rotate++;
        if(shapelist.get(number).clear==1){
            rotate=1;
        }
        if (rotate==5){
            rotate=1;
        }


    }

    public void shiftLeft(){
        //change so it accounts for different shapes
        if(shapelist.get(number).xcoord > shapelist.get(number).xbound2 &&
                shapelist.get(number).leftCheck(shapelist.get(number).xlist, shapelist.get(number).ylist)) {
            shapelist.get(number).xcoord--;
            xcoord=shapelist.get(number).xcoord;
            if (shapelist.get(number).clear == 1) {
                xcoord = 0;
            }
        }



    }






    public int updateScore(){

        if(shapelist.get(number).clear==1)

            score += 1000;

        return score;

    }




    @Override
    public void draw(Canvas canvas){
        endgame(canvas);
        super.draw(canvas);



        Paint textpaint=new Paint();
        Shape newshape = null;
        textpaint.setTextSize(50);
        textpaint.setColor(Color.WHITE);
        textpaint.setStyle(Paint.Style.FILL_AND_STROKE);



        canvas.drawColor(Color.TRANSPARENT);

        tetrisboard.draw1(canvas);

        System.out.println(shapelist.size());

        //shapelist.get(number).draw(canvas);
        System.out.println("clear="+ shapelist.get(number).clear);


       if(shapelist.get(number).clear==1){
           number++;
           newshape=Random();
           xcoord=0;
           ycoord=0;
           score+=1000;
           rotate=1;
           Sleeptime=600;
           //shapelist.add(newshape);
           }
        //shapelist.get(number-1).draw(canvas);
        System.out.println("SHAPE:"+shapelist.get(shapelist.size()-2));
       shapelist.get(shapelist.size()-2).draw(canvas);
      // canvas.drawRect(newshape,paint);
       /* for(int i=0;i<=number;i++){
            shapelist.get(i).draw(canvas);
        }*/


        //if(tetrisboard.newshape==1){
          //  Random(canvas);
       // }

       // ishape.draw(canvas);

     //   for(int i=0;i<10;i++){
       //     for(int j=0;j<14;j++){
         //       if(tetrisboard.boolarr[i][j]==true){
           //         canvas.drawRect(tetrisboard.tetrisboard[i][j],paint);

             //   }
            //}
       // }

        canvas.drawText("Score: ", 500, 1320, textpaint);

        canvas.drawText(Integer.toString(score), 500, 1400, textpaint);
        System.out.println("score:"+score);
        canvas.drawText("Next Piece:", 710, 1320, textpaint);
        canvas.drawBitmap(nextshape,710,1400,paint);

        //tshape.draw(canvas);
        System.out.println("xcoordinate:"+xcoord);
        System.out.println("YCOORD:"+ ycoord);

        //tetrisboard.draw2(canvas);



        postInvalidate();
    }


}

