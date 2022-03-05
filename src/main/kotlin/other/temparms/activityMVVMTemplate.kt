package other.temparms

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import java.io.File

val activityMVVMTemplate
    get() = template {
        name = "Alvin MVVM Activity"
        description = "一键创建 MVVM Activity 页面所需要的类"
        minApi = MIN_API
        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val moduleName = stringParameter {
            name = "Module Name"
            default = "App"
            help = "请填写模块名称,如填写 App,会自动生成 AppMainActivity"
            constraints = listOf(Constraint.NONEMPTY, Constraint.UNIQUE)
        }

        val activityName = stringParameter {
            name = "Activity Name"
            default = "Main"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            help = "请填写页面名,如填写 Main,会自动生成 MainActivity, MainViewModel 等文件"
        }

        val rootPackageName = defaultPackageNameParameter

        val generateActivity = booleanParameter {
            name = "Generate Activity"
            default = true
            help = "是否需要生成 Activity ? 不勾选则不生成"
        }

        val generateListActivity = booleanParameter {
            name = "Generate List Activity"
            default = false
            help = "是否需要生成 List Activity ? 不勾选则不生成"
        }

        val activityLayoutName = stringParameter {
            name = "Activity Layout Name"
            default = "app_activity_main"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            help = "Activity 创建之前需要填写 Activity 的布局名,若布局已创建取消勾选,若还没创建此布局,请勾选下面的单选框"
            suggest =
                { moduleName.value.toLowerCase() + "_" + activityToLayout(activityName.value) }
        }


        widgets(
            TextFieldWidget(moduleName),
            TextFieldWidget(activityName),
            PackageNameWidget(rootPackageName),
            CheckBoxWidget(generateActivity),
            CheckBoxWidget(generateListActivity),
            TextFieldWidget(activityLayoutName)
        )



        thumb {
            File("template_empty_activity.png")
        }

        recipe = { data: TemplateData ->
            activityMVVMRecipe(
                data as ModuleTemplateData,
                moduleName.value,
                activityName.value,
                rootPackageName.value,
                generateActivity.value,
                generateListActivity.value,
                activityLayoutName.value
            )
        }
    }
