package com.example.bruce.snake_startercode;

public class SnakeSegment {
    private int mXLoc;
    private int mYLoc;
    private int mLengthOfSnake;
    private Body mBodyParts;
    private int mDegree;

    public enum Body {

        HEAD, BODY, TAIL;
    }

    /*************************************************
     * Getters and Setters
     **************************************************/

    public int getmXLoc() {
        return mXLoc;
    }

    public int getmYLoc() {
        return mYLoc;
    }

    public int getmLengthOfSnake() {
        return mLengthOfSnake;
    }

    public void setmLengthOfSnake(int mLengthOfSnake) {
        this.mLengthOfSnake = mLengthOfSnake;
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
