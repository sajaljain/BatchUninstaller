package hours.com.batchuninstaller.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Sajal on 31-Aug-16.
 */
public class AppDetails implements Serializable {
    private String appName;
    private Drawable appLogo;
    private String pkgName;
    private boolean isSelected;

    public AppDetails(Drawable appLogo,String appName,String pkgName){
        this.appName = appName;
        this.appLogo = appLogo;
        this.pkgName = pkgName;

    }
    public AppDetails(Drawable appLogo,String appName,String pkgName,boolean isSelected){
        this.appName = appName;
        this.appLogo = appLogo;
        this.pkgName = pkgName;
        this.isSelected = isSelected;
    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(Drawable appLogo) {
        this.appLogo = appLogo;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
