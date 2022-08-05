package other.temparms.src.mvvm

fun mvvmActivityKt(
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
import com.alvin.mvvm.base.activity.BaseMVVMActivity
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
    BaseMVVMActivity<$viewModelName,$dataBindingName>(R.layout.$layoutResName) {
    
    /**
     * 在initView中执行View初始化的任务，不要做逻辑的处理
     */
    override fun initView(savedInstanceState: Bundle?) {
        setTitleName("标题")
    }

    /**
     * 在obtainData中做逻辑处理，不要做View初始化
     */
    override fun obtainData() {
    }
    
    /**
     * 初始化LiveData数据观察者
     */
    override fun registerObserver() {
    }

}

"""