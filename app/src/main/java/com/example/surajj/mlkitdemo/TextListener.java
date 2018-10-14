package com.example.surajj.mlkitdemo;

import com.google.firebase.ml.vision.text.FirebaseVisionText;

public interface TextListener {
    public void onTextExtracted (String data);
}
