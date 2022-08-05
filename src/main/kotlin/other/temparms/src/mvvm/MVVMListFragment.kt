package other.temparms.src.mvvm

fun mvvmFragmentListKt(
    rootPackageName: String,
    fragmentPackageName: String,
    dataBindingName: String,
    viewModelPackageName: String,
    viewModelName: String,
    time: String,
    fragmentClassName: String,
    layoutResName: String
) = """
package $fragmentPackageName

import android.os.Bundle
import android.view.View
import com.alvin.mvvm.base.fragment.BaseListFragment
import $viewModelPackageName.$viewModelName


/**
 * <h3> 作用类描述：</h3>
 *
 * @Package :        $fragmentPackageName
 * @Date :           $time
 * @author            
 */
class $fragmentClassName : 
    BaseListFragment<$viewModelName,$dataBindingName>(R.layout.$layoutResName) {
    
    /**
     * 在initView中执行View初始化的任务，不要做逻辑的处理
     */
    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
    }
    
    /**
     * Fragment懒加载数据
     */
    override fun lazyLoadData() {
        setTitleName("标题")
        loadData()
    }

    /**
     * 在obtainData中做逻辑处理，不要做View初始化
     */
    override fun obtainData() {
    }
    
    /**
     * 初始化LiveData数据观察者
     */
    override fun registerObserver(){
    }

    /**
     * 加载List刷新和加载更多的数据
     * 
     * 数据请求成功后调用 `rootRefresh.finish(list,adapter)` 结束刷新，
     * 内部会自行处理数据的添加和不同状态的视图。
     */
    override fun loadData() {
    }
}    
"""