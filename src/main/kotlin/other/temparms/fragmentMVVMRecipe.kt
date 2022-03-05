package other.temparms


import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.temparms.res.layout.mvvmListXml
import other.temparms.res.layout.mvvmTemplateXml
import other.temparms.src.mvvm.mvvmFragmentKt
import other.temparms.src.mvvm.mvvmFragmentListKt
import other.temparms.src.mvvm.mvvmViewModel
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun RecipeExecutor.fragmentMVVMRecipe(
    moduleData: ModuleTemplateData,
    moduleName: String,
    fragmentName: String,
    rootPackageName: String,
    generateFragment: Boolean,
    fragmentLayoutName: String,
    generateListFragment: Boolean
) {
    val (projectData, srcOut, resOut, manifestOut) = moduleData

    val ktOrJavaExt = projectData.language.extension

    // 类名
    val fragmentClass = "${moduleName}${fragmentName}Fragment"
    val viewModelClass = "${moduleName}${fragmentName}ViewModel"

    // 所有用的的包名
    val fragmentPackageName = "${rootPackageName}.ui.fragment"
    val viewModelPackageName = "${rootPackageName}.view_model.fragment"
    val dataBindingName =
        "${moduleName.first().toUpperCase() + moduleName.substring(1, moduleName.length)}Fragment${
            fragmentName.first().toUpperCase() + fragmentName.substring(
                1,
                fragmentName.length
            )
        }Binding"

    // 生成时间
    val time =
        LocalDateTime.ofEpochSecond(System.currentTimeMillis() / 1000L, 0, ZoneOffset.ofHours(8))
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    // 生成Fragment布局
    if (generateFragment) {
        if (generateListFragment) {
            save(mvvmListXml(), resOut.resolve("layout/${fragmentLayoutName}.xml"))
        } else if (generateFragment && !generateListFragment) {
            save(mvvmTemplateXml(), resOut.resolve("layout/${fragmentLayoutName}.xml"))
        }
    }
    if (generateListFragment) {
        save(
            mvvmFragmentListKt(
                rootPackageName,
                fragmentPackageName,
                dataBindingName,
                viewModelPackageName,
                viewModelClass,
                time,
                fragmentClass,
                fragmentLayoutName
            ), srcOut.resolve("ui/fragment/${fragmentClass}.kt")
        )
    } else {
        save(
            mvvmFragmentKt(
                rootPackageName,
                fragmentPackageName,
                dataBindingName,
                viewModelPackageName,
                viewModelClass,
                time,
                fragmentClass,
                fragmentLayoutName
            ), srcOut.resolve("ui/fragment/${fragmentClass}.kt")
        )
    }
    open(srcOut.resolve("ui/fragment/${fragmentClass}.kt"))

    save(
        mvvmViewModel(viewModelPackageName, fragmentPackageName, viewModelClass, time),
        srcOut.resolve("view_model/fragment/${viewModelClass}.kt")
    )

    open(srcOut.resolve("view_model/fragment/${viewModelClass}.kt"))

}