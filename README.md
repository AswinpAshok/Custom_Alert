# Custom_Alert
Library project to create custom alertboxes


I created this library as an experiment.

To include this in your project,
Add the following line to your app level build.gradle file<br>


     compile 'clasher.customalert:custom-alert:0.1.1
 

To user this library,
create an object of CustomAlert class, and pass appropriate parameters

Eg: 

    CustomAlert customAlert=new CustomAlert(Activity.this,"Your alert Title","Your alert message","button text");
    customAlert.show();

## ScreenShot

![img](https://image.ibb.co/ipDoLa/Screen.png)
