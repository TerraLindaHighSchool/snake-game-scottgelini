package com.example.bruce.snake_startercode;

public class SnakeSegment {
    private int XLoc;
    private int YLoc;
    private Body mBodyParts;
    private int mDegree;


    /*************************************************
     * Enumerations
     **************************************************/

    public enum Body {

        HEAD, BODY, TAIL;
    }

    public SnakeSegment (Body bodyParts, int degree ,int XLoc, int YLoc){
        mBodyParts = bodyParts;
        mDegree = degree;
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

    public Body getmBodyParts() {
        return mBodyParts;
    }

    public int getmDegree() {
        return mDegree;
    }

    public void setmDegree(int mDegree) {
        this.mDegree = mDegree;
    }
}

