package hours.com.batchuninstaller.adapter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hours.com.batchuninstaller.R;
import hours.com.batchuninstaller.model.AppDetails;

/**
 * Created by Sajal on 31-Aug-16.
 */
public class AppInfoAdapter extends
        RecyclerView.Adapter<AppInfoAdapter.ViewHolder> {
    List<AppDetails> data;


    public AppInfoAdapter(List<AppDetails> data) {

        this.data = data;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView appName;
        ImageView logo;
        CheckBox chkSelected;


        public ViewHolder(View itemView) {
            super(itemView);
            logo = (ImageView) itemView.findViewById(R.id.appImage);
            appName = (TextView) itemView.findViewById(R.id.appName);
            chkSelected = (CheckBox) itemView.findViewById(R.id.chkSelected);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.app_info_row,null );

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final int pos = position;
        AppDetails app = data.get(position);
        viewHolder.logo.setImageDrawable(app.getAppLogo());
        viewHolder.appName.setText(app.getAppName());

        viewHolder.chkSelected.setChecked(app.isSelected());
        viewHolder.chkSelected.setTag(app);
        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                AppDetails apk = (AppDetails) cb.getTag();

                apk.setSelected(cb.isChecked());
                data.get(pos).setSelected(cb.isChecked());
                notifyDataSetChanged();
            }

        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // method to access in activity after updating selection
    public List<AppDetails> getToBeUninstalled() {
        return data;
    }

}
