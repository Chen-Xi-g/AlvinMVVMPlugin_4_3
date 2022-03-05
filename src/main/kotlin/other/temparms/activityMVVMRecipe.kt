package other.temparms

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.temparms.androidManifest.manifestTemplateXml
import other.temparms.res.layout.mvvmListXml
import other.temparms.res.layout.mvvmTemplateXml
import other.temparms.src.mvvm.mvvmActivityKt
import other.temparms.src.mvvm.mvvmActivityListKt
import other.temparms.src.mvvm.mvvmViewModel
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun RecipeExecutor.activityMVVMRecipe(
    moduleData: ModuleTemplateData,
    moduleName: String,
    activityName: String,
    rootPackageName: String,
    generateActivity: Boolean,
    generateListActivity: Boolean,
    activityLayoutName: String
) {
    val (projectData, srcOut, resOut, manifestOut) = moduleData

    val ktOrJavaExt = projectData.language.extension

    // 类名
    val activityClass = "${moduleName}${activityName}Activity"
    val viewModelClass = "${moduleName}${activityName}ViewModel"

    // 所有用的的包名
    val activityPackageName = "${rootPackageName}.ui.activity"
    val viewModelPackageName = "${rootPackageName}.view_model.activity"
    val dataBindingName =
        "${moduleName.first().toUpperCase() + moduleName.substring(1, moduleName.length)}Activity${
            activityName.first().toUpperCase() + activityName.substring(
                1,
                activityName.length
            )
        }Binding"


    // 生成时间
    val time =
        LocalDateTime.ofEpochSecond(System.currentTimeMillis() / 1000L, 0, ZoneOffset.ofHours(8))
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    if (generateActivity) {
        mergeXml(
            manifestTemplateXml(rootPackageName, activityClass),
            manifestOut.resolve("AndroidManifest.xml")
        )
    }

    // 生成Activity布局
    if (generateActivity) {
        if (generateListActivity) {
            save(mvvmListXml(), resOut.resolve("layout/${activityLayoutName}.xml"))
        } else if (!generateListActivity) {
            save(mvvmTemplateXml(), resOut.resolve("layout/${activityLayoutName}.xml"))
        }
    }

    // 生成Activity
    if (generateActivity) {
        if (generateListActivity) {
            save(
                mvvmActivityListKt(
                    rootPackageName,
                    activityPackageName,
                    dataBindingName,
                    viewModelPackageName,
                    viewModelClass,
                    time,
                    moduleName,
                    activityClass,
                    activityLayoutName
                ), srcOut.resolve("ui/activity/${activityClass}.kt")
            )
        } else {
            save(
                mvvmActivityKt(
                    rootPackageName,
                    activityPackageName,
                    dataBindingName,
                    viewModelPackageName,
                    viewModelClass,
                    time,
                    moduleName,
                    activityClass,
                    activityLayoutName
                ), srcOut.resolve("ui/activity/${activityClass}.kt")
            )
        }
    }

    save(
        mvvmViewModel(viewModelPackageName, activityPackageName, viewModelClass, time),
        srcOut.resolve("view_model/activity/${viewModelClass}.kt")
    )

}