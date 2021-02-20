package com.pa.chen.appipc.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.io.File;

public class Utils {
    public static String permissionSTORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,//文件存储
    };

    public static boolean checkPermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//>=23
            if ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {//小米手机
                String permissionToOp = AppOpsManagerCompat.permissionToOp(permissionSTORAGE);
                if (permissionToOp == null) {
                    return true;
                }
                int noteOp = AppOpsManagerCompat.noteOp(context, permissionToOp, Process.myUid(), context.getPackageName());
                int systemCheckPermiss = ContextCompat.checkSelfPermission(context, permissionSTORAGE);
                if (noteOp == AppOpsManagerCompat.MODE_ALLOWED
                        && systemCheckPermiss == PackageManager.PERMISSION_GRANTED) {
                    return true;
                } else {
                    return false;
                }
            }
            if (ContextCompat.checkSelfPermission(context, permissionSTORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }

}
