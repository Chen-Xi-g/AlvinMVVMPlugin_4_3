package other.temparms.src.mvvm

fun mvvmViewModel(
    viewModelPackageName: String,
    activityPackageName: String,
    viewModelName: String,
    time: String
) = """
package $viewModelPackageName
import com.alvin.mvvm.base.view_model.BaseViewModel

/**
 * <h3> 作用类描述：[$activityPackageName]的ViewModel</h3>
 *
 * ViewModel内部已经和生命周期绑定，无需关心与View的生命周期绑定问题。
 * 如果需要释放资源，请重写`onCleared()`释放。
 *
 * @Package :        $viewModelPackageName
 * @Date :           $time
 * @author           
 */
class $viewModelName : BaseViewModel() {

}
    
"""