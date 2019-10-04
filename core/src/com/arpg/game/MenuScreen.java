package com.arpg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen extends AbstractScreen {
    private Stage stage;
    public MenuScreen(SpriteBatch batch) {
        super(batch);
        stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
        init();
    }
    private void init(){
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin();
        skin.addRegions(Assets.getInstance().getAtlas());
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("smButton");
        textButtonStyle.font = ScreenManager.getInstance().getGameScreen().getFont24();
        skin.add("smallButtonStyle", textButtonStyle);

        Button newGameButton = new TextButton("New Game", skin, "smallButtonStyle");
        Button exitButton = new TextButton("Exit Game", skin, "smallButtonStyle");
        Group menuGroup = new Group();
        menuGroup.addActor(newGameButton);
        menuGroup.addActor(exitButton);
        newGameButton.setPosition(0, 50);
        exitButton.setPosition(0, 0);
        menuGroup.setPosition(500, 400);
        stage.addActor(menuGroup);
        skin.dispose();

        newGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.GAME);
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }
}

