package com.example.bruce.snake_startercode;

public class PivotPoint { private int mXCoord, mYCoord, mDegree;

    public PivotPoint (int xCoord, int yCoord, int degree){
        mXCoord = xCoord;
        mYCoord = yCoord;
        mDegree = degree;
    }

    protected int getXCoord() { return mXCoord; }

    protected int getYCoord() { return mYCoord; }

    protected int getDegree () { return mDegree; }

}
