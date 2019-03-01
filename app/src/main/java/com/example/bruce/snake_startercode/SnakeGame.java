package com.example.bruce.snake_startercode;


import java.util.ArrayList;
import java.util.List;

public class SnakeGame {
  private int mSpriteDim, mBOARD_WIDTH, mBOARD_HEIGHT, mScore, mLevel, mCountdown, mMillisDelay;
  private int[] mAppleCoord, mPappleCoord;
  private List<SnakeSegment> mSnake;
  private boolean mGameOver;
  private int mXMax, mYMax;
  private List<PivotPoint> mPivotPoints;


  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height) {
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mXMax = mBOARD_WIDTH / beginningSpriteDim;
    mYMax = mBOARD_HEIGHT / beginningSpriteDim;
    mScore = 0;
    mLevel = 1;
    mCountdown = 15;
    mMillisDelay = 250;
    mAppleCoord = new int[2];
    mPappleCoord = new int[2];
    mSnake = new ArrayList<>();
    mSnake.add(new SnakeSegment(SnakeSegment.Body.HEAD, beginningDirection, beginningX, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.Body.BODY, beginningDirection, beginningX - 1, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.Body.TAIL, beginningDirection, beginningX - 2, beginningY));
    mGameOver = false;
    setAppleCoord();
    mPivotPoints = new ArrayList<>();
  }

  protected void touched(float xTouched, float yTouched) {
    int snakeHeadX = mSnake.get(0).getXLoc();
    int snakeHeadY = mSnake.get(0).getYLoc();
    int direction = mSnake.get(0).getDegrees();
    if (direction == 0 || direction == 180) {
      if (snakeHeadY * mSpriteDim > yTouched) {
        direction = 270;
      } else {
        direction = 90;
      }
    } else {
      if (snakeHeadX * mSpriteDim > xTouched) {
        direction = 180;
      } else {
        direction = 0;
      }
    }
    mPivotPoints.add(new PivotPoint(snakeHeadX, snakeHeadY, direction));
  }

  protected void eatApple() {
    if (mAppleCoord[0] == mSnake.get(0).getXLoc()*getSpriteDim() && mAppleCoord[1] == mSnake.get(0).getYLoc()*getSpriteDim()){
      growSnake();
      updateScore();
      setAppleCoord();
    }
  }
  protected void eatPapple(){
    if (mPappleCoord[0] == mSnake.get(0).getXLoc()*getSpriteDim() && mPappleCoord[1] == mSnake.get(0).getYLoc()*getSpriteDim()){
      mSnake.remove(mSnake.size() - 2);;
      mMillisDelay = mMillisDelay - 20;
      mCountdown = mCountdown * 2;
      setPappleCoord();
    }
  }

  private void updateScore(){
    mScore++;
    mCountdown--;
    if (mCountdown == 0)
      mGameOver = true;
    mSpriteDim-=2;
    //new level
  }

  protected boolean play() {
    SnakeSegment.Body seg;
    int xLoc, yLoc, degrees;

    // increments through segments
    for (int i = 0; i < mSnake.size(); i++) {
      seg = mSnake.get(i).getBodyPart();
      xLoc = mSnake.get(i).getXLoc();
      yLoc = mSnake.get(i).getYLoc();
      degrees = mSnake.get(i).getDegrees();


      // checks if segment is on pivot
      for (int p = 0; p < mPivotPoints.size(); p++) {
        int xPivot = mPivotPoints.get(p).getXCoord();
        int yPivot = mPivotPoints.get(p).getYCoord();
        int degPivot = mPivotPoints.get(p).getDegree();

        // is segment i at a pivot point
        if (mSnake.get(i).getXLoc() == mPivotPoints.get(p).getXCoord() && mSnake.get(i).getYLoc() == mPivotPoints.get(p).getYCoord()) {

          // code to turn segment
          if (xLoc == mPivotPoints.get(p).getXCoord() && yLoc == mPivotPoints.get(p).getYCoord()) {
            mSnake.get(i).setDegrees(mPivotPoints.get(p).getDegree());
            if (mSnake.get(mSnake.size() - 1).getXLoc() == mPivotPoints.get(p).getXCoord() && mSnake.get(mSnake.size() - 1).getYLoc() == mPivotPoints.get(p).getYCoord()) {
              mPivotPoints.remove(p);
            }
          }
        }
      }

      // move a segment in increments
      switch (degrees) {
        case 180:
          mSnake.get(i).setXLoc(--xLoc);
          break;

        case 90:
          mSnake.get(i).setYLoc(++yLoc);
          break;

        case 0:
          mSnake.get(i).setXLoc(++xLoc);
          break;

        case 270:
          mSnake.get(i).setYLoc(--yLoc);
      }
      eatApple();
      eatPapple();

      // did snake die
      for( int b = 1; b < mSnake.size(); b++ ){
        if ((mSnake.get(0).getXLoc() > mXMax || mSnake.get(0).getXLoc() < 0 || mSnake.get(0).getYLoc() > mYMax || mSnake.get(0).getYLoc() < 0) || (mSnake.get(0).getXLoc()== mSnake.get(b).getXLoc() && mSnake.get(0).getYLoc()== mSnake.get(b).getYLoc()))
          mGameOver = true;
      }
    }
    return mGameOver;
  }

  private void growSnake(){
    SnakeSegment currentTail = mSnake.get(mSnake.size() - 1);
    mSnake.add(mSnake.size() - 1, new SnakeSegment(SnakeSegment.Body.BODY, currentTail.getDegrees(), currentTail.getXLoc(), currentTail.getYLoc()));

    switch(currentTail.getDegrees()){
      case 0:
        mSnake.get(mSnake.size() - 1).setXLoc(mSnake.get(mSnake.size() - 1).getXLoc() - 1);

        break;

      case 90:
        mSnake.get(mSnake.size() - 1).setYLoc(mSnake.get(mSnake.size() - 1).getYLoc() - 1);

        break;

      case 180:
        mSnake.get(mSnake.size() - 1).setXLoc(mSnake.get(mSnake.size() - 1).getXLoc() + 1);

        break;

      case 270:
        mSnake.get(mSnake.size() - 1).setYLoc(mSnake.get(mSnake.size() - 1).getYLoc() + 1);


        break;
    }
  }

  // getters and Setters

  protected int getSpriteDim () {
    return mSpriteDim;
  }

  protected int getBOARD_WIDTH () {
    return mBOARD_WIDTH;
  }

  protected int getBOARD_HEIGHT () {
    return mBOARD_HEIGHT;
  }

  protected int getScore () {
    return mScore;
  }

  protected int getLevel () {
    return mLevel;
  }

  protected int getCountdown () {
    return mCountdown;
  }

  protected int getMillisDelay () {
    return mMillisDelay;
  }

  protected boolean getGameOver () {
    return mGameOver;
  }

  protected List<SnakeSegment> getSnake () {
    return mSnake;
  }

  protected int[] getAppleCoord () {
    return mAppleCoord;
  }

  private void setAppleCoord () {
    do{
      mAppleCoord[0] = (int) ((mXMax - 1) * Math.random() + 1) * mSpriteDim;
      mAppleCoord[1] = (int) ((mYMax - 1) * Math.random() + 1) * mSpriteDim;
    }while(mAppleCoord[0] == mSnake.get(0).getXLoc() && mAppleCoord[1] == mSnake.get(0).getYLoc());
  }

  protected int[] getPappleCoord(){
    return mPappleCoord;
  }

  private void setPappleCoord () {
    do{
      mPappleCoord[0] = (int) ((mXMax - 1) * Math.random() + 1) * mSpriteDim;
      mPappleCoord[1] = (int) ((mYMax - 1) * Math.random() + 1) * mSpriteDim;
    }while((mPappleCoord[0] == mSnake.get(0).getXLoc() && mPappleCoord[1] == mSnake.get(0).getYLoc()) || (mPappleCoord[0] == mAppleCoord[0] && mPappleCoord[1] == mAppleCoord[1]) );
  }
}

