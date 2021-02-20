package com.pa.chen.appipc.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lifecycle.launchmode.R;
import com.pa.chen.appipc.bean.People;
import com.pa.chen.appipc.bean.User;
import com.pa.chen.appipc.constants.Constants;
import com.pa.chen.appipc.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//主页面
public class MainActivity extends Activity {
    public String className = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcmain);
        // 检查读写权限
        if (!Utils.checkPermission(this)) {
            ActivityCompat.requestPermissions(MainActivity.this, Utils.permissions, 0);
        } else {
            fileOutput();
        }
        //修改一个静态变量值
        Constants.id = 20;
        Log.d(Constants.TAG, className + ":" + Constants.id);

        initView();

    }

    private void initView(){
        TextView mTvIpc = findViewById(R.id.tv_ipc);
        TextView mTvSec = findViewById(R.id.tv_sec);
        mTvIpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, IPCActivity.class);
                People mPe = new People("chen", "male", "faddsscc2d9v92");
                Log.d(Constants.TAG, className + ":People:" + mPe.toString());
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.BUNDLE_PARCE, mPe);
                mIntent.putExtra(Constants.INTENT_BUNDLE, bundle);
                startActivity(mIntent);

            }
        });
        mTvSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecActivity.class));
            }
        });
    }

    //序列化与反序列化User类，输出到文件
    private void fileOutput() {
        User mUser = new User("3ddw34s234d33", "chen", "male");
        Log.d(Constants.TAG, "User:" + mUser.toString());
        if (!TextUtils.isEmpty(Utils.getSDPath())) {
            try {
                File file = new File(Utils.getSDPath() + "/ipccache.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                objectOutputStream.writeObject(mUser);
                objectOutputStream.close();
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                User mNewUser = (User) objectInputStream.readObject();
                Log.d(Constants.TAG, "NewUser:" + mNewUser.toString());//与源对象不是同一个对象
            } catch (FileNotFoundException e) {
                Log.d(Constants.TAG, className + ":FileNotFoundException");
            } catch (IOException e) {
                Log.d(Constants.TAG, className + ":IOException");
            } catch (ClassNotFoundException e) {
                Log.d(Constants.TAG, className + ":ClassNotFoundException");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0) { //当设置了小米(25api)读写文件为拒绝后，申请，结果回调这里参数是空，需要弹框提示用户去设置
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fileOutput();
                    Toast.makeText(this, "权限申请成功!", Toast.LENGTH_SHORT).show();
                } else {
                    // 如果应用之前请求过此权限但用户拒绝了请求，此方法将返回true。
                    // 如果用户在过去拒绝了权限请求，并在权限请求系统对话框中选择了 Don't ask again 选项，
                    // 此方法将返回 false，并且如果设备规范禁止应用具有该权限，此方法也会返回false。
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                            Utils.permissionSTORAGE)) {
                        new AlertDialog.Builder(this)
                                .setTitle("您一定要申请读写权限才继续下去哦!")
                                .setPositiveButton("继续申请吧!", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //继续申请
                                        ActivityCompat.requestPermissions(MainActivity.this, Utils.permissions, 0);
                                    }
                                })
                                .setNegativeButton("取消~", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                }).show();
                    } else {
                        //说明已经拒绝且不再弹出询问，这时去引导用户直接去权限页面设置
                        popAlertRefuseDialog();
                    }
                }
            } else {//<23api申请了也没成功，参数是0,这时去引导用户直接去权限页面设置
                popAlertRefuseDialog();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    //引导用户直接去权限页面设置
    private void popAlertRefuseDialog() {
        new AlertDialog.Builder(this)
                .setTitle("您一定要申请读写权限才继续下去哦!您已经拒绝并不在询问啦，那只能跳转到权限设置页面申请啦!")
                .setPositiveButton("OK!我自己去!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton("算了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
    }

}
