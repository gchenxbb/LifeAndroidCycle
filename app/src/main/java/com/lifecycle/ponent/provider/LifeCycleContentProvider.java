package com.lifecycle.ponent.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

//import com.spow.debug.database.FirewallDatabaseHelper;


/**
 * 内容提供者,其他进程访问
 */
public class LifeCycleContentProvider extends ContentProvider {
    static String TAG = LifeCycleContentProvider.class.getSimpleName();

    private final static UriMatcher mUriMatcher;
    private static final int MATCH_CODE_MOBILE = 1;
    private static final int MATCH_CODE_WIFI = 2;

    //ContentProvider唯一标识
    public static final String AUTHORITY = "com.lm.LifeCycleContentProvider";
    public static final Uri CONTENT_URI_MOBILE = Uri
            .parse("content://" + AUTHORITY + "/"
                    + "mobile");
    public static final Uri CONTENT_URI_WIFI = Uri.parse("content://"
            + AUTHORITY + "/" + "wifi");

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AUTHORITY, "mobile", MATCH_CODE_MOBILE);//匹配码
        mUriMatcher.addURI(AUTHORITY, "wifi", MATCH_CODE_WIFI);
    }

//    private FirewallDatabaseHelper mHelper;

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate()方法执行。");
//        mHelper = FirewallDatabaseHelper.getInstance(getContext()
//                .getApplicationContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "query()方法执行。");
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(TAG, "insert()方法执行。");
//        SQLiteDatabase db = mHelper.getWritableDatabase();
        long rowId;
        Uri result = null;
        switch (mUriMatcher.match(uri)) {
            case MATCH_CODE_MOBILE://判断匹配码

                Log.d(TAG, "insert(),mobile");
                // 插入后返回的是当前所在的行号
//                rowId = db.insert(FirewallDatabaseHelper.MOBILE_TABLE, null, values);
//                if (rowId > 0) {
//                    // 将行号添加到URI的末尾，做为结果返回
//                    result = ContentUris.withAppendedId(CONTENT_URI_FIREWALL_MOBILE, rowId);
//                    getContext().getContentResolver().notifyChange(uri, null);
//                }
                break;
            case MATCH_CODE_WIFI:
                Log.d(TAG, "insert(),wifi");
//                rowId = db.insert(FirewallDatabaseHelper.WIFI_TABLE, null, values);
//                if (rowId > 0) {
//                    result = ContentUris.withAppendedId(CONTENT_URI_FIREWALL_WIFI, rowId);
//                    getContext().getContentResolver().notifyChange(uri, null);
//                }
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        return result;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG, "delete()方法执行。");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.d(TAG, "update()方法执行。");
        return 0;
    }

}