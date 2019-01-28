package com.example.bruce.snake_startercode;

public class SnakeSegment {
    private int mXLoc;
    private int mYLoc;
    private Body mBodyPart;
    private int mDegrees;


    /*************************************************
     * Enumerations
     **************************************************/

    public enum Body {

        HEAD, BODY, TAIL;
    }

    public SnakeSegment (Body bodyPart, int degrees ,int XLoc, int YLoc){
        mBodyPart = bodyPart;
        mDegrees = degrees;
        mXLoc = XLoc;
        mYLoc = YLoc;

    }

    /*************************************************
     * Getters and Setters
     **************************************************/

    public int getXLoc() {
        return mXLoc;
    }

    public void setXLoc(int XLoc) {
        mXLoc = XLoc;
    }

    public int getYLoc() {
        return mYLoc;
    }

    public void setYLoc(int YLoc) {
        mYLoc = YLoc;
    }

    public Body getBodyPart() {
        return mBodyPart;
    }

    public int getDegrees() {
        return mDegrees;
    }

    public void setDegrees(int mDegree) {
        mDegrees = mDegree;
    }
}

