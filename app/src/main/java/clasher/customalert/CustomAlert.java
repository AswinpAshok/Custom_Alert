package clasher.customalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by PC4 on 3/14/2017.
 */

public class CustomAlert extends Activity {
    TextView title_view,message_view;
    public static final String TAG="lib###";
    Button alertButton;
    String title,message,ButtonText;
    Activity activity;
    Dialog dialog;
    public CustomAlert(Activity activity,String title, String message, String buttonText) {
        this.title = title;
        this.message = message;
        ButtonText = buttonText;
        this.activity = activity;
        dialog=new Dialog(activity);
        dialog.setContentView(R.layout.alert_layout);
        alertButton=(Button) dialog.findViewById(R.id.AlertButton);
        title_view=(TextView) dialog.findViewById(R.id.title);
        message_view=(TextView) dialog.findViewById(R.id.AlertMessage);
        alertButton.setText(buttonText);
        title_view.setText(title);
        message_view.setText(message);
        Typeface titleface=getFontFromRes(R.raw.roboto_regular,activity);
        title_view.setTypeface(titleface);
        Typeface alertface=getFontFromRes(R.raw.roboto_light,activity);
        alertButton.setTypeface(alertface);
        message_view.setTypeface(alertface);
        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    public void show(){
        dialog.show();
    }

    private Typeface getFontFromRes(int resource, Context context)
    {
        Typeface tf = null;
        InputStream is = null;
        try {
            is = context.getResources().openRawResource(resource);
        }
        catch(Resources.NotFoundException e) {
            Log.e(TAG, "Could not find font in resources!");
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
            Log.e(TAG, "Error reading in font!");
            return null;
        }

        Log.d(TAG, "Successfully loaded font.");

        return tf;
    }


}
