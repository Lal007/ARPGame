package com.arpg.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public enum Direction {
    UP(0, 1, 90.0f, 2), DOWN(0, -1, 270.0f, 3), LEFT(-1, 0, 180.0f, 0), RIGHT(1, 0, 0.0f, 1);

    private int x;
    private int y;
    private int imageIndex;
    private float angle;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public float getAngle() {
        return angle;
    }

    Direction(int x, int y, float angle, int imageIndex) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.imageIndex = imageIndex;
    }

    public static Direction getDirectionByVector2(Vector2 vector2){
        int x = MathUtils.round(vector2.x);
        int y = MathUtils.round(vector2.y);
        if (x == 0 && y == 1) return UP;
        else if (x == 0 && y == -1) return DOWN;
        else if (x == -1 && y == 0) return LEFT;
        else if (x == 1 && y == 0) return RIGHT;
        else if (x == -1 && y == -1) return LEFT;
        else if (x == -1 && y == 1) return LEFT;
        else if (x == 1 && y == -1) return RIGHT;
        else if (x == 1 && y == 1) return RIGHT;
        else {
            return UP;
        }
    }
}
