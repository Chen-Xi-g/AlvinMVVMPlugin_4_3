package other.temparms.src.mvvm


fun mvvmActivityListKt(
    rootPackageName: String,
    activityPackageName: String,
    dataBindingName: String,
    viewModelPackageName: String,
    viewModelName: String,
    time: String,
    moduleName: String,
    activityName: String,
    layoutResName: String
) = """
package $activityPackageName

import android.os.Bundle
import com.alvin.mvvm.base.activity.BaseListActivity
import $viewModelPackageName.$viewModelName


/**
 * <h3> 作用类描述：</h3>
 *
 * @Package :        $activityPackageName
 * @Date :           $time
 * @author   
 *
 */
class $activityName : 
    BaseListActivity<$viewModelName,$dataBindingName>(R.layout.$layoutResName) {
    
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setTitleName("标题")
    }
    
    /**
     * 在obtainData中做逻辑处理，不要做View初始化
     */
    override fun obtainData() {
        loadData()
    }
    
    /**
     * 初始化LiveData数据观察者
     */
    override fun registerObserver() {
    }
    
    /**
     * 加载List刷新和加载更多的数据
     * 
     * 数据请求成功后调用 `rootRefresh.finish(list,adapter)` 结束刷新，
     * 内部在下拉刷新或上拉加载时调用loadData
     * 可以根据需求, 在initView中调用 `refreshLoadMoreListener` 定义刷新监听
     */
    override fun loadData() {
    }

}

"""