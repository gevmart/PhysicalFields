package com.davkhech.physicalfields;

public class Particle {
    private float xCoordinate = 200;
    private float yCoordinate = 300;

    private float xVelocity = 0f;
    private float yVelocity = 0f;

    private float xAcceleration = 0.00f;
    private float yAcceleration = 0.00f;

    protected double mass;
    protected double charge;

    protected float getxCoordinate() {
        return xCoordinate;
    }

    protected float getyCoordinate() {
        return yCoordinate;
    }


    protected void update() {
        if (false) {
            xCoordinate += xVelocity * Constants.STEP_TIME;
            yCoordinate += yVelocity * Constants.STEP_TIME;

            xVelocity += xAcceleration * Constants.STEP_TIME;
            yVelocity += yAcceleration * Constants.STEP_TIME;

            xAcceleration = getAcceleration(Constants.X);
            yAcceleration = getAcceleration(Constants.Y);

            if (yCoordinate < 10) {
                yVelocity = abs(yVelocity);
            }
        } else {
            xCoordinate += xVelocity * Constants.STEP_TIME;
            yCoordinate += yVelocity * Constants.STEP_TIME;

//            float velocity = (float) Math.sqrt(xVelocity * xVelocity + yVelocity * yVelocity);
            xVelocity += xAcceleration * Constants.STEP_TIME;
            yVelocity += yAcceleration * Constants.STEP_TIME;
//            xVelocity /= velocity;
//            yVelocity /= velocity;


            xAcceleration = yVelocity / 100;
            yAcceleration = -xVelocity / 100 + 0.004f;

//            float acc;
//            acc = (float) Math.sqrt(xAcceleration * xAcceleration + yAcceleration * yAcceleration);
//            xAcceleration /= acc / 0.01;
//            yAcceleration /= acc / 0.01;
        }
    }

    private float getAcceleration(int direction) {
        float acceleration;

        switch (direction) {
            case Constants.X:
                acceleration = 0;
                break;
            case Constants.Y:
                acceleration = -0.001f;
                break;
            default:
                acceleration = 0;
        }
        return acceleration;
    }

    private float abs(float a) {
        return a > 0 ? a : -a;
    }

}
