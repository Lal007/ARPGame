package com.arpg.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameCharacter {
    private ArpgGame game;
    private Texture texture;
    private Vector2 position;
    private Vector2 tmp;
    private float speed;

    public GameCharacter(ArpgGame game, Texture texture, Vector2 position, Vector2 tmp, float speed) {
        this.game = game;
        this.texture = texture;
        this.position = position;
        this.tmp = tmp;
        this.speed = speed;
    }

    abstract void render(SpriteBatch batch);
    abstract void update(float dt);
    abstract Vector2 createRandomPosition();

}
