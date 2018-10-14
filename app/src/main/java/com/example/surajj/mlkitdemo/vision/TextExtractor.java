package com.example.surajj.mlkitdemo.vision;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.surajj.mlkitdemo.TextListener;
import com.example.surajj.mlkitdemo.controller.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import java.util.List;

public class TextExtractor {
    private Bitmap mBitmap;

    public  TextExtractor (Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public void getTextFromImage (final TextListener mListener) {
        if (this.mBitmap == null) {
            this.mBitmap = mBitmap;
        }

        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(this.mBitmap);

        FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();

        textRecognizer.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText result) {
                        // Task completed successfully
                        // ...
                        extractInfo(mListener ,result);

                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Task failed with an exception
                                // ...
                                mListener.onTextExtracted(null);
                            }
                        });
    }

    private void extractInfo (TextListener listener, FirebaseVisionText result) {
       if(result != null && result.getTextBlocks().size()>0) {
           List<FirebaseVisionText.TextBlock> textBlocks = result.getTextBlocks();
           for (int i = 0; i < textBlocks.size(); i++) {
               FirebaseVisionText.TextBlock block = textBlocks.get(i);
               for (FirebaseVisionText.Line line : block.getLines()) {
                    listener.onTextExtracted(line.getText());
               }
           }
       } else {
           listener.onTextExtracted(null);
       }
    }

}
