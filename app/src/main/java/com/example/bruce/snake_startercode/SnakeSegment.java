package com.example.bruce.snake_startercode;

public class SnakeSegment {
    private int XLoc;
    private int YLoc;
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
        XLoc = XLoc;
        YLoc = YLoc;

    }

    /*************************************************
     * Getters and Setters
     **************************************************/

    public int getXLoc() {
        return XLoc;
    }

    public void setXLoc(int XLoc) {
        this.XLoc = XLoc;
    }

    public int getYLoc() {
        return YLoc;
    }

    public void setYLoc(int YLoc) {
        this.YLoc = YLoc;
    }

    public Body getBodyPart() {
        return mBodyPart;
    }

    public int getDegrees() {
        return mDegrees;
    }

    public void setDegrees(int mDegree) {
        this.mDegrees = mDegree;
    }
}

