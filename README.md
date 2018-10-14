# AndroidMLKitDemo
Android application for leveraging Machine Learning Kit from Firebase.

##### Application Overview:
Its a very basic head start for using Machine learning kit from firebase in android applications.
For now, it has a very simple one screen interface from where a picture can be captured and then the text can be
analyzed from the captured image.

##### Currently this project is consisting only the following ML kit features:
1. Text Recognition (using on device model)

##### Dependencies:
1. Firebase ML Vision. 
   Docs [here](https://firebase.google.com/docs/ml-kit/android/recognize-text)

##### Project Setup
1. Clone this project using this clone [URL](https://github.com/surajj2223/MLKitDemo.git)
2. Make a Firebase project from the firebase [console](https://console.firebase.google.com/)
3. Initialize firebase in the project using your Firebase project's `google-services.json` file. **DON'T FORGET TO PLACE THIS FILE IN `android/app/` directory.**
4. Once done, sync gradle and hit run to test the app on an external device(as camera feature can only be used on a real device).
You should have the internet connected with your device at the first launch of the application as the on device model of text
 recognition downloads the machine learning model upon installation.
 
 ##### Demo
 
 
 
 
 
