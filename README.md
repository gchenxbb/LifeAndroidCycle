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



