/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\Users\\CHENGUANG491\\Desktop\\AppIPCDemo\\app\\src\\main\\aidl\\com\\pa\\chen\\appipc\\IAppThreadCallBack.aidl
 */
package com.life.ipc.ipcinterface;
//ipc进程回调主进程
public interface IAppThreadCallBack extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements IAppThreadCallBack {
        private static final String DESCRIPTOR = "com.pa.chen.appipc.IAppThreadCallBack";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.pa.chen.appipc.IAppThreadCallBack interface,
         * generating a proxy if needed.
         */
        public static IAppThreadCallBack asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IAppThreadCallBack))) {
                return ((IAppThreadCallBack) iin);
            }
            return new Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_implementAction: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.implementAction(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_scheduleHandleActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0;
                    _arg0 = data.readString();
                    this.scheduleHandleActivity(_arg0);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IAppThreadCallBack {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void implementAction(int counts) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(counts);
                    mRemote.transact(Stub.TRANSACTION_implementAction, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void scheduleHandleActivity(String isActivity) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(isActivity);
                    mRemote.transact(Stub.TRANSACTION_scheduleHandleActivity, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_implementAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_scheduleHandleActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    public void implementAction(int counts) throws android.os.RemoteException;

    public void scheduleHandleActivity(String isActivity) throws android.os.RemoteException;
}
