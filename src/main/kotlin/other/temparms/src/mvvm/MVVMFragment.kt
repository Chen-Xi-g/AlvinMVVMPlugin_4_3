package other.temparms.src.mvvm

fun mvvmFragmentKt(
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
import com.alvin.mvvm.base.fragment.BaseMVVMFragment
import $rootPackageName.R
import $rootPackageName.databinding.$dataBindingName
import $viewModelPackageName.$viewModelName


/**
 * <h3> 作用类描述：</h3>
 *
 * @Package :        $fragmentPackageName
 * @Date :           $time
 * @author            
 */
class $fragmentClassName : 
    BaseMVVMFragment<$viewModelName,$dataBindingName>(R.layout.$layoutResName){

    /**
     * 在initView中执行View初始化的任务，不要做逻辑的处理
     */
    override fun initView(view: View, savedInstanceState: Bundle?) {
        setTitleName("标题")
    }
    
    
    /**
     * Fragment懒加载数据
     */
    override fun lazyLoadData() {
    }
    
    /**
     * 初始化LiveData数据观察者
     */
    override fun registerObserver(){
    }

    /**
     * 在obtainData中做逻辑处理，不要做View初始化
     */
    override fun obtainData() {
    }

}    
"""