/*
 * Copyright  2017   Fredy Campiño
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.campino.sampleworld.theater;


import com.titicolab.puppet.map.MapWorld;
import com.titicolab.puppet.objects.World2D;
import com.titicolab.puppeteer.ui.JoystickLayer;

/**
 * Created by campino on 11/01/2018.
 *
 */

public class SampleWorld2D extends World2D implements JoystickLayer.OnClickJoystick {

    private static final int GROUND_LAYER = 1;
    private static final int JOYSTICK_LAYER = 2;
    private boolean flagTouchRight;
    private boolean flagTouchLeft;
    private boolean flagTouchUp;
    private boolean flagTouchDown;

    public SampleWorld2D() {
    }


    @Override
    protected MapWorld onDefineMapWorld(MapWorld.Builder builder) {
        return builder
                .setName("World")
                .setGridSize(40, 10)
                .setTileSize(84, 84)
                .setCameraSize(5,true)
                .setFocusedWindowSize(9,true)
                .layer(SampleTiledLayer.class,GROUND_LAYER,null)
                .layer(JoystickLayer.class,JOYSTICK_LAYER,null)
                .build();
    }

    @Override
    protected void onGroupLayersCreated() {
        JoystickLayer layer = (JoystickLayer) findLayer(JOYSTICK_LAYER);
        layer.setOnClickJoystickListener(this);
        setDrawBoundary(true);
        setDrawCamera(true);
    }

    @Override
    protected void updateLogic(){
        if(flagTouchLeft){
            getCamera2D().setPositionIj(getCamera2D().getI()-1,getCamera2D().getJ());
            flagTouchLeft=false;
        }else  if(flagTouchRight){
            getCamera2D().setPositionIj(getCamera2D().getI()+1,getCamera2D().getJ());
            flagTouchRight=false;
        }else if(flagTouchUp){
            getCamera2D().setPositionIj(getCamera2D().getI(),getCamera2D().getJ()+1);
            flagTouchUp=false;
        }else  if(flagTouchDown){
            getCamera2D().setPositionIj(getCamera2D().getI(),getCamera2D().getJ()-1);
            flagTouchDown=false;
        }



      super.updateLogic();
    }

    @Override
    public void onLeft() {
        flagTouchLeft = true;
    }

    @Override
    public void onRight() {
        flagTouchRight = true;
    }

    @Override
    public void onTop() {
        flagTouchUp = true;
    }

    @Override
    public void onBottom() {
        flagTouchDown = true;
    }
}
