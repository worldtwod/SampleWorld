package com.campino.sampleworld;

import android.os.Bundle;

import com.campino.sampleworld.theater.SampleWorld2D;
import com.titicolab.nanux.core.SceneLauncher;
import com.titicolab.puppeteer.GraphicActivity;


public class MainActivity extends GraphicActivity implements SceneLauncher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sFlagFullScreen=true;
        sFlagSensorLandscape=true;
        sFlatDisplayFPS=true;
        super.onCreate(savedInstanceState);
        setSceneLauncher(this);
        setContentView(getGLGameView());
    }

    @Override
    public SampleWorld2D onLaunchScene() {
        return new SampleWorld2D();
    }
}
