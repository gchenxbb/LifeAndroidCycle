
### Activity生命周期

正常情况下，用户全程参与所经历的状态的改变，如启动，暂停，停止，销毁等。
异常情况下，系统回收不是用户参与的，系统配置改变如转屏幕导致的销毁重建等。

生命周期方法
onCreate(),Activity正在被创建,生命周期第一个方法，初始化setContentView加载布局资源。
onStart(),Activity正在启动，即将开始，可以理解此方法为Activity已经活动，但是用户看不到，还在后台，未到前台。
onRestart(),Activity正在重新启动，一般是用户行为导致，如Home或启动新组件使之到后台后被唤起。
onResume(),Activity显示到前台并获得焦点，用户可以看见，此时可以做开启动画和独占设备的操作。
onPause(),Activity正在停止，可以存储数据，停止动画，不能太耗时，否则会影响新Activity的Resume。
onStop(),Activity即将停止，且处于不可见状态，对象未销毁，做一些资源回收
onDestory(),Activity即将被销毁，生命周期最后一个方法。

第一种情况：第一次启动Activity
onCreate—>onStart—>onResume

第二种情况：Back退出Activity
onPause—>onStop—>onDestory

第三种情况：Home退到后台
onPause—>onStop

第四种情况：后台唤起Activity
onRestart—>onStart—>onResume

第五种情况：B组件压入，压住第一个A
A：onPause—>onStop
B: onCreate—>onStart—>onResume
顺序
(A)onPause→(B)onCreate→(B)onStart→(B)onResume→(A)onStop

第六种情况：B组件弹出，恢复第一个A
A: onRestart—>onStart—>onResume
B：onPause—>onStop—> onDestory
顺序
(B)onPause→(A)onRestart→(A)onStart→(A)onResume→(B)onStop→(B) onDestory

在第五种情况中，若B采用透明主题，则A不会触发onStop。当然，在第六种情况时，A恢复时，也不会触发onRestart和onStart。因为Activity压根没有onStop停止。

OnStart和onStop是从Activity是否活动来回调的，onResume和onPause从用户是可见来区分触发的。

A的onPause和B的onResume到底谁先执行。需要从源码角度分析，在源码的栈中，B启动之前，栈顶的需要先onPause，B才会进入生命周期开始。因此， onPause 不能做太耗时操作，否则会影响新Activity的启动。不可耗时要求500ms执行完毕，如果实在需要操作，尽量在onStop中完成，onStop在B的onResume后才会触发。

异常情况下生命周期
两种异常情况，资源配置改变如转屏导致Activity重建和内存不足导致Activity回收。
两种情况下数据存储与恢复的步骤完全一致。

系统会根据当前设备区加载合适的Resource，如drawable，根据分辨率不同加载不同的图片，如横竖屏时从drawable-land-xxhdpi中加载，竖屏时，从普通drawable中加载图片，若系统配置改变，默认会重建Activity。

异常情况销毁时，onPause—>onSaveInstanceState—>onStop—> onDestory
onSaveInstanceState保存状态，包括视图结构，文本框数据，ListView滚动位置等，注意，此方法在onStop前触发，异常终止才会调用。
异常情况重建时，onCreate—>onRestoreInstanceState—>onStart—> onResume
OnRestoreInstanceState恢复状态。在onStart方法之后调动，传递Bundle。
异常情况重建启动时，生命周期和第一种情况一样，不同的地方在于数据恢复。
记住一点，两个方法分别在onStop前与onStart后触发。

Activity重建时恢复保存的数据时，委派给Window，窗体再委派给View，每个View也有这两个方法。RecycleView在转屏时保存与恢复的到滚动位置。
除了系统自动保存的数据，我们自己的数据也需要保存和恢复，用字符串验证。

仅异常终止的Activity组件才会调用onSaveInstanceState和onRestoreInstanceState方法，其他情况不会发生。

内存不足时，低优先级的Activity所在进程会被杀掉，前台活动Activity优先级最高，onStop处于后台的Activity优先级最低。
若进程中无组件，很容易被杀掉，因此，后台工作最好放在Service组件中，让其有一定优先级。

若在Manifest中配置android：configChanges，对应配置改变时，便不会重建Activity。例如android:configChanges=orientation|keyboardHidden,这种情况就是屏幕方向与键盘弹出时，不重建Activity。

### 启动模式

##### standard标准模式，默认，

每个Activity都创建实例，按照正常生命周期流程。
与启动它的Activity在同一个任务栈。
启动它的应该是Activity组件的Context，不能是Application的Context，否则无法找到栈。
解决方案是可以用新栈，设置FLAG_ACTIVITY_NEW_TASK标志。

##### singleTop栈顶复用模式
若被启动的Activity已位于栈顶，不会再创建实例，复用栈顶的Activity。
回调onNewIntent方法，传入新Intent，因已经活动，因此，onCreate和onStart方法不会调用，若不在栈顶，同标准模式。

standard和singleTop都是在原有任务栈中创建Activity实例，不会启用新Task，taskAffinity对他们没有影响。

##### singleTask栈内复用模式
若被启动Activity实例已存在栈中(即使不在栈顶)，复用Activity，且该Activity上面的所有实例全部出栈。
回调onNewIntent方法，传入新的Intent。

1，	查看被启动Activity所属栈是否存在，不存在，创建栈，创建A，放置栈中。
2，	查看栈中是否已有A的实例，不存在，创建A，放置栈顶。
3，	栈中存在A的实例，经A调到栈顶，A先前上面的组件全部出栈。回调onNewIntent。

##### singleInstance全局唯一模式
该模式具备singleTask的所有模式外，还会单独占一个Task栈，具有系统唯一的Activity实例。
再次启动Activity时，根据栈内唯一性，复用。


##### taskAffinity 代表任务栈名字
1，taskAffinit不设置，默认是包名，只和singleTask一起用才起作用，若与standard和singleTop一起用，不起作用。
2，SingleTask模式，不设置taskAffinity， Activity的taskAffinity相同，都为应用的包名，不会开启一个新任务栈。
3，SingleTask模式，设置taskAffinit与包名不同的值，查找当前是否存在一个与taskAffinity名字一致的任务栈，不存在，新建任务栈，TaskId会改变。
4，存在，作为被启动Activity的目标任务栈，按照SingleTask的普通流程操作。
5，两个不同App中的Activity设置为相同的taskAffinity，这样虽然在不同的应用中，但是Activity会被分配到同一个Task中去 
总之，设置TaskAffinity和singleTask的组合，任务栈与普通不设置TaskAffinity的Activity的不同

6：设置SingleTask，B进程ActivityB被A进程的ActivityA启动，
若ActivityB在任务栈的顶部，启动后B进程的任务栈最前台，若返回，回到的是ActivityB所在任务战的上一个页面。
ActivityB是被A进程启动的，只需要返回这一个ActivityB，回到ActivityA就行了。需要回到A进程。因此，这样不合理。
解决方案是ActivityB独占一个任务栈，配置taskAffinit不同于B进程包名即可，或者一直在ActivityB在栈底部，会杀掉中间的组件。


allowTaskReparenting只与singleTop和standard模式有关
如果设置为true
两个应用A和B，A的ActivityA启动B的ActivityB(android:exported="true")，ActivityA和ActivityB在同一个任务栈，如果A应用到后台(Home)，打开B应用，ActivityB的任务栈从A应用的任务栈移动到B应用的任务栈。再打开A应用就不会有ActivityB，应用如在APP调用打开浏览器。浏览器应用的Activity设置为android:allowTaskReparenting="true"
如果设置为false
ActivityB不会移动，而是在B应用的任务栈中重建Activity的实例

allowTaskReparenting标志的Activity会自动回到与TaskAffinity一样的住宿任务栈中。看一下newIntent后获取到当前任务栈


Flag标记
FLAG_ACTIVITY_SINGLE_TOP，singleTop模式，与xml设置一样
FLAG_ACTIVITY_NEW_TASK，singleTask模式，与xml设置一样
FLAG_ACTIVITY_CLEAR_TOP，singleTask默认具有此标志位效果。
