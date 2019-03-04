package com.example.flutter_sample;

import android.os.Bundle;
import android.util.Log;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "samples.flutter.io/math";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);

    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
            (call, result) -> {
              if(call.method.equals("sin")) {
                  for(int i = 0; i < 1000000; i++){
                      Math.sin(i);
                  }

                  result.success(null);
              } else {
                  result.notImplemented();
              }
            });
  }
}
