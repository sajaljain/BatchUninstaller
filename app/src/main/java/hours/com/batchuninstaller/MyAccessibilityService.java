package hours.com.batchuninstaller;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by Sajal on 29-Aug-16.
 */
public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = MyAccessibilityService.class
            .getSimpleName();


    /*@Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        final int eventType = event.getEventType();
        Log.i(TAG,"The event type is"+eventType);

        switch (eventType)
        {
            case AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE :
                break;
        }
*/
        /*AccessibilityNodeInfo nodeInfo = event.getSource();
        Log.i(TAG, "1 onAccessibilityEvent nodeInfo=" + nodeInfo);
        if (nodeInfo == null) {
            return;
        }
        List<AccessibilityNodeInfo> list = null;
        String eventText = null;
        switch (eventType) {
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                eventText = "Focused: ";
                break;
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                eventText = "Focused: ";
                break;
            *//*case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                eventText = "Window Changed: ";
                list = nodeInfo.findAccessibilityNodeInfosByViewId("hours.com.batchuninstaller:id/button");
                for (AccessibilityNodeInfo node : list) {
                    Log.i(TAG, "2 onAccessibilityEvent: button " + node);
                    node.performAction(AccessibilityNodeInfo.ACTION_CLICK);

                    Log.i(TAG, "3 I have clicked on the button");
                }

                break;*//*
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                eventText = "Window Changed: ";
                break;
            default:
                eventText = "Some event that I have not considered ";
        }
        eventText = eventText + event.getContentDescription();
        Log.i(TAG, "4 "+eventText);*/

    //}
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i(TAG, "ACC::onAccessibilityEvent: " + event.getEventType());

        //TYPE_WINDOW_STATE_CHANGED == 32
        if (AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED == event
                .getEventType()) {
            AccessibilityNodeInfo nodeInfo = event.getSource();
            Log.i(TAG, "ACC::onAccessibilityEvent: nodeInfo=" + nodeInfo);
            if (nodeInfo == null) {
                return;
            }
            Log.i(TAG,"BC1");
            List<AccessibilityNodeInfo> list = nodeInfo
                    .findAccessibilityNodeInfosByViewId("com.android.settings:id/left_button");
            for (AccessibilityNodeInfo node : list) {
                Log.i(TAG,"BC2");
                Log.i(TAG, "ACC::onAccessibilityEvent: left_button " + node);
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }



            list = nodeInfo
                    .findAccessibilityNodeInfosByViewId("android:id/button1");
            Log.i(TAG,"BC3");

            for (AccessibilityNodeInfo node : list) {
                Log.i(TAG, "ACC::onAccessibilityEvent: button1 " + node);
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                Log.i(TAG,"BC4");
            }
            Log.i(TAG,"BC5");

        }

        else if(AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE == event.getEventType()){
            AccessibilityNodeInfo nodeInfo = event.getSource();
            Log.i(TAG,"BC6");
            Log.i(TAG, "ACC::onAccessibilityEvent: nodeInfo=" + nodeInfo);
            if (nodeInfo == null) {
                return;
            }
        }
        else{

        }

    }



    @Override
    public void onInterrupt() {

    }
}
