# Custom_Alert
Library project to create custom alertboxes


I created this library as an experiment.

To include this in your project,
Add the following line to your app level build.gradle file<br>


     compile 'clasher.customalert:custom-alert:0.1.2
 

To create custom alert with default theme,
create an object of CustomAlert class, and pass appropriate parameters

Eg: 

    CustomAlert customAlert=new CustomAlert(Activity.this,"Your alert Title","Your alert message","button text");
    customAlert.show();

## ScreenShot

Custom alert with default theme

![img](https://image.ibb.co/ipDoLa/Screen.png)


To Create custom alert with your color choice,

Follow below steps

    CustomAlert customAlert=new CustomAlert(this)
                .setTitle("title")
                .setMessage("message")
                .setButtonText("alert button")
                .setTitleBlockColor("#1465e8")
                .setTitleColor("#ffffff")
                .setMessageColor("#6b2f2f")
                .setButtonColor("#0015ff")
                .setButtonTextColor("#e6e6e6")
                .show();
               
               
## ScreenShot

customized Custom alert

![img](https://image.ibb.co/fGhXDv/Screenshot_20170316_131545.png)


You can replace color code with appropriate values.
To add your own button click listner for alert button,do the following


     Button b=(Button) customAlert.getAlertButton();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                BUTTON CLICK LOGIC HERE
                 */
                customAlert.close();
            }
        });
