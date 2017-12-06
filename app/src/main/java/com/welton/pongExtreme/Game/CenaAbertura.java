package com.welton.pongExtreme.Game;

import com.silvano.AndGraph.AGGameManager;
import com.silvano.AndGraph.AGInputManager;
import com.silvano.AndGraph.AGScene;
import com.silvano.AndGraph.AGSprite;
import com.silvano.AndGraph.AGScreenManager;

import br.com.hellmets.motocerol.R;

public class CenaAbertura extends AGScene
{
    AGSprite botao = null;

    public CenaAbertura(AGGameManager manager)
    {
        super(manager);
    }

    @Override
    public void init()
    {
        setSceneBackgroundColor(1,0,0);

        botao = this.createSprite(R.mipmap.btnjogar, 2,1);
        botao.setScreenPercent(25,15);

        //Altura e Largura
        botao.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        botao.vrPosition.setY(AGScreenManager.iScreenHeight/2);
    }

    @Override
    public void restart()
    {

    }

    @Override
    public void stop()
    {

    }
    @Override
    public void loop()
    {
        if (AGInputManager.vrTouchEvents.screenClicked())
        {
            if (botao.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {
                this.vrGameManager.setCurrentScene(1);
            }
        }
    }
}
