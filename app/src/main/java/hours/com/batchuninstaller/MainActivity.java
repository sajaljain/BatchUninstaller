package hours.com.batchuninstaller;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Uri packageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Hi there",Toast.LENGTH_LONG).show();
                /*try {
                    //Open the specific App Info page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + "com.monkporter.zafran"));
                    startActivity(intent);

                } catch ( ActivityNotFoundException e ) {
                    //e.printStackTrace();

                    //Open the generic Apps page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                    startActivity(intent);

                }*/
         packageURI = Uri.parse("package:" + "com.monkporter.zafran");
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        uninstallIntent.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startActivity(uninstallIntent);

            }
        });


       /* packageURI = Uri.parse("package:" + "com.monkporter.zafran");
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        uninstallIntent.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startActivity(uninstallIntent);*/


     /*   TextView logger = (TextView) findViewById(R.id.log);
        logger.setMovementMethod(new ScrollingMovementMethod());
        String apks="";
        int flags = PackageManager.GET_META_DATA |
                PackageManager.GET_SHARED_LIBRARY_FILES;

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> applications = pm.getInstalledApplications(flags);


        for (int i = 0; i < 50; i++) {

            ApplicationInfo appInfo = applications.get(i);
            apks = apks+appInfo.packageName+"\n";
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1) {

            } else {
                packageURI = Uri.parse("package:" + appInfo.packageName);
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                uninstallIntent.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
                startActivity(uninstallIntent);
            }
        }

        logger.setText(apks);*/
    }

}

