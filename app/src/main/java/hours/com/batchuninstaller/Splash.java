package hours.com.batchuninstaller;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import hours.com.batchuninstaller.adapter.AppInfoAdapter;
import hours.com.batchuninstaller.model.AppDetails;

public class Splash extends AppCompatActivity {
    private Button uninstall;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private final String TAG = "Splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        uninstall = (Button) findViewById(R.id.uninstall);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        int flags = PackageManager.GET_META_DATA |
                PackageManager.GET_SHARED_LIBRARY_FILES;


        PackageManager pm = getPackageManager();
        final List<ApplicationInfo> applications = pm.getInstalledApplications(flags);
        List<AppDetails> userInstalled = new ArrayList<>();

        for (ApplicationInfo app : applications) {
            if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 1) {
                AppDetails apkDetails = new AppDetails(app.loadIcon(pm), app.loadLabel(pm).toString(), app.packageName, false);
                userInstalled.add(apkDetails);

            }
        }
        mAdapter = new AppInfoAdapter(userInstalled);

        mRecyclerView.setAdapter(mAdapter);



/*
Uri packageURI = Uri.parse("package:" + app.packageName);
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        uninstallIntent.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startActivity(uninstallIntent);
*/

        uninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri packageURI;
                String data = "";
                List<AppDetails> apps = ((AppInfoAdapter) mAdapter)
                        .getToBeUninstalled();

                for (int i = 0; i < apps.size(); i++) {
                    AppDetails app = apps.get(i);
                    if (app.isSelected() == true) {

                        data = data + "\n" + app.getAppName().toString();

                        //here we pop up

                        packageURI = Uri.parse("package:" + app.getPkgName());
                        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                        uninstallIntent.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
                        startActivity(uninstallIntent);


                    }

                }


                Toast.makeText(Splash.this,
                        "Selected Students: \n" + data, Toast.LENGTH_LONG)
                        .show();



            }
        });


    }
}