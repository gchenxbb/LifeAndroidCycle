Demo测试
1，2个组件间生命周期打印。
2，转屏保存状态测试。
3，启动流程分析。
4，Service生命周期打印。
5，启动模式，本app内各种模式，打开其他进程app时，不同启动模式下场景。
[Activity生命周期](https://www.jianshu.com/p/4ced02b11cf4)
[Activity启动模式及场景](https://www.jianshu.com/p/4ea4530ab847)

### IntentFilter
为某个组件向系统注册一些特性，一个组件可以注册多个IntentFilter，以便Intent找到对应的组件。

启动Activity
显式启动，包名+类名
隐式启动，不需要组件明确信息，Intent匹配目标组件的IntenFilter设置的信息
匹配信息包括data，action，category。

同时匹配过滤列表中的action，category，data信息。每一项可以由多个组成。一个intent同时匹配action类别，category类别，data类别时，才算完全匹配。

Intent必须指定至少一个action。
<intent-filter>中可定义多个action，Intent可指定多个action
Intent中指定的所有action(也可只有一个)，在<intent-filter>全部找到，匹配。

Intent如果有category，不管几个，都必须在IntentFilter中找到，才能匹配
可以没有category。
不管是否有category，系统都会默认加上DEFAULT的category。
因此，IntentFilter一定要加上DEFAULT这项category，否则无法支持隐式启动。

data 包括 mimeType和URI
Intent的mimeType必须在过滤规则中都存在才能匹配。
IntentFilter中存在的mimeType必须在Intent存在才能匹配。
在IntentFilter中设置mimeType是image/*，在Intent中设置同样的mimeType才能匹配。
IntentFilter没有配置URI，默认支持content和file。因此，IntentFilter中设置这种URI可匹配。
Intentfilter中带有URI和mimeType，匹配时，intent中要设置URI和mimeTye与其一致。

隐式启动Activity时，可以先进行intent判断，看能否找到匹配的，不做判断可能出现错误。



#ipc
Android对单个进程使用内存做了限制，多进程可以获取多分内存空间。
在一个应用中使用多进程，在四大组件的AndroidMenifest添加android :process属性。
或者在JNI的native层fork一个新进程。

默认进程名是包名，在android:process属性中可设置新进程名字。
以：开头的进程是当前应用私有进程，其他应用组件不能进入此进程。
不以：开头的进程是全局进程，其他应用可通过ShareUID的方式 和他在一个进程中。

每个应用分配一个UID，相同UID的应用可共享数据。通过shareUID的方式使得两个应用进入同一个进程是由要求的，需要应用的shareUID相同且签名相同，才可互访私有数据。Data目录，组件信息以及内存数据。

多进程组件之间，凡是需要通过内存共享数据的，都会失败。
主要影响比如
静态成员和单例，线程同步机制，SharedPreferences可靠性下降，Application多次创建等。
内存区不同，无法保证线程同步，锁的对象也不是一个。SharedPreferences不支持两个进程同时写操作，SharedPreferences底层利用xml文件读写实现，并发有问题。

运行在同一个进程的组件属于同一个虚拟机，Application仅创建一次，不同进程时，会再次创建一个Application。

不同进程组件拥有独立的虚拟机，Application和内存空间。

实现跨进程通信
Serializable和Parcelable实现对象序列化

Serializable序列化接口，序列化的变量仅限于对象变量，而不是类变量
实现序列化，需要实现Serializable接口，并声明一个serialVersionUID（仅对反序列化有影响）
不仅仅是文件，网络也需要序列化，java对象转换成json字符串的过程也是序列化过程，serialVersionUID对序列化与反序列化有用，serialVersionUID被写入序列化中的数据中，文件或网络，反序列时，系统会检测文件的该值，只有与反序列化类的serialVersionUID一样，才能正常的反序列化。

若不手动指定serialVersionUID值，反序列化时，当前类变量增加或删除（版本升级时），系统会自动根据当前类的内容计算serialVersionUID，肯定与序列化计算的数据的值不同，导致序列化失败而崩溃。因此，指定该值，可以避免反序列化的失败。

Parcelable
对象实现该接口就能在Intent之间进行传递。

两个接口都能实现对象的序列化，并在Intent间传递数据。
Serializable是Java的序列化接口，用法简单，开销较大，在序列化与反序列化过程中有大量的IO操作。
Parcelable是Android平台的序列化接口，使用麻烦，效率较高。Android平台推荐。主要用在对象内存序列化上，在进程间传输。序列化到文件或网络还是用Serializable较好。


