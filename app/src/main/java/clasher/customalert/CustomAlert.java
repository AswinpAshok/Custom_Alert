package clasher.customalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by PC4 on 3/15/2017.
 */

public class CustomAlert {
    private TextView title_view,message_view;
    private Button alertButton;
    Activity activity;
    private Dialog dialog;
    private RelativeLayout title_block;
    CustomAlert alert;

    public CustomAlert(Activity activity) {
        this.activity = activity;
        dialog=new Dialog(activity);
        dialog.setContentView(R.layout.alert_layout);
        alertButton=(Button) dialog.findViewById(R.id.AlertButton);
        title_view=(TextView) dialog.findViewById(R.id.title);
        message_view=(TextView) dialog.findViewById(R.id.AlertMessage);
        title_block=(RelativeLayout) dialog.findViewById(R.id.title_block);

        Typeface titleface=getFontFromRes(R.raw.roboto_regular,activity);
        title_view.setTypeface(titleface);
        Typeface alertface=getFontFromRes(R.raw.roboto_light,activity);
        alertButton.setTypeface(alertface);
        message_view.setTypeface(alertface);
        alert=this;
    }

    public clasher.customalert.CustomAlert show(){
        alert.dialog.show();
        return alert;
    }

    public View getAlertButton(){
        return alertButton;
    }

    public void close(){
        dialog.dismiss();
    }

    public clasher.customalert.CustomAlert setTitle(String title){
        try {
            alert.title_view.setText(title);

        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }

    public clasher.customalert.CustomAlert setMessage(String message){
        try {
            alert.message_view.setText(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }

    public clasher.customalert.CustomAlert setButtonText(String buttonText){
        try {
            alert.alertButton.setText(buttonText);
        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }

    public clasher.customalert.CustomAlert setTitleBlockColor(String color){
        try {
            alert.title_block.setBackgroundColor(Color.parseColor(color));
        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public clasher.customalert.CustomAlert setButtonColor(String color) {
        try {
//            alert.alertButton.setBackgroundColor(Color.parseColor(color));
//            Drawable drawable=alert.alertButton.getBackground();
//            drawable.setColorFilter(0,PorterDuff.Mode.CLEAR);
//            drawable.setColorFilter(Color.parseColor(color), PorterDuff.Mode.MULTIPLY);
//            alertButton.setBackground(drawable);
            GradientDrawable drawable=(GradientDrawable) alertButton.getBackground();
            drawable.setColor(Color.parseColor(color));
            alertButton.setBackground(drawable);

        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }


    public clasher.customalert.CustomAlert setButtonTextColor(String color) {
        try {
            alert.alertButton.setTextColor(Color.parseColor(color));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alert;
    }

    public clasher.customalert.CustomAlert setTitleColor(String color){
        try {
            alert.title_view.setTextColor(Color.parseColor(color));
        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }

    public clasher.customalert.CustomAlert setMessageColor(String color){
        try {
            alert.message_view.setTextColor(Color.parseColor(color));
        }catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }

    private Typeface getFontFromRes(int resource, Context context) {
        Typeface tf = null;
        InputStream is = null;
        try {
            is = context.getResources().openRawResource(resource);
        }
        catch(Resources.NotFoundException e) {
        }

        String outPath = context.getCacheDir() + "/tmp" + System.currentTimeMillis() +".raw";

        try
        {
            byte[] buffer = new byte[is.available()];
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));

            int l = 0;
            while((l = is.read(buffer)) > 0)
                bos.write(buffer, 0, l);

            bos.close();

            tf = Typeface.createFromFile(outPath);

            // clean up
            new File(outPath).delete();
        }
        catch (IOException e)
        {
            return null;
        }

        return tf;
    }

}
