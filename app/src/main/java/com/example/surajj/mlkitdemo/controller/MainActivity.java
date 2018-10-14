package com.example.surajj.mlkitdemo.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.method.TextKeyListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surajj.mlkitdemo.R;
import com.example.surajj.mlkitdemo.TextListener;
import com.example.surajj.mlkitdemo.vision.TextExtractor;
import com.google.firebase.ml.vision.text.FirebaseVisionText;

public class MainActivity extends AppCompatActivity implements TextListener {

    private final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView mImageView;

    private TextExtractor mTextExtractor;

    private TextView resultView;
    private Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.imageView);
        resultView = findViewById(R.id.textView);
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            mTextExtractor = new TextExtractor(imageBitmap);
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    public void analyzeText(View view) {
        if (imageBitmap != null) {
            mTextExtractor.getTextFromImage(this);
        } else {
            Toast.makeText(this, "Please capture an image to analyze first.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTextExtracted(String data) {
        if(data != null) {
           this.resultView.setText(data);
        } else {
            Toast.makeText(this, "Couldn\'t recognize any text.", Toast.LENGTH_SHORT).show();
        }
    }
}
