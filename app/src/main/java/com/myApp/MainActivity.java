package com.myApp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    CameraManager cm;
    String cameraId;
    boolean state = true;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            cameraId = cm.getCameraIdList()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (state){
                    try {
                        cm.setTorchMode(cameraId, true);
                        state = false;
                        btn.setText("Off");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else{
                    try {
                        cm.setTorchMode(cameraId, false);
                        state = true;
                        btn.setText("On");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });

    }

}
