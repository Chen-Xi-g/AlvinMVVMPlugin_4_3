package other.temparms

import com.android.tools.idea.wizard.template.*

import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import java.io.File

val fragmentMVVMTemplate
    get() = template {
        name = "Alvin MVVM Fragment"
        description = "一键创建 MVVM Fragment 页面所需要的类"
        minApi = MIN_API
        category = Category.Fragment
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
            help = "请填写模块名称,如填写 App, 会自动生成 AppMainFragment."
            constraints = listOf(Constraint.NONEMPTY, Constraint.UNIQUE)
        }

        val fragmentName = stringParameter {
            name = "Fragment Name"
            default = "Main"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            help = "请填写页面名,如填写 Main,会自动生成 AppMainFragment, AppMainPresenter 等文件"
        }

        val rootPackageName = defaultPackageNameParameter

        val generateFragment = booleanParameter {
            name = "Generate Fragment"
            default = true
            help = "是否需要生成 Fragment ? 不勾选则不生成"
        }


        val generateListFragment = booleanParameter {
            name = "Generate List Fragment"
            default = false
            visible = { generateFragment.value }
            help = "是否需要生成 List Activity ? 不勾选则不生成"
        }

        val fragmentLayoutName = stringParameter {
            name = "Fragment Layout Name"
            default = "app_fragment_main"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            help = "Fragment 创建之前需要填写 Fragment 的布局名,若布局已创建取消勾选,若还没创建此布局,请勾选下面的单选框"
            suggest =
                { moduleName.value.toLowerCase() + "_" + fragmentToLayout(fragmentName.value) }
        }


        widgets(
            TextFieldWidget(moduleName),
            TextFieldWidget(fragmentName),
            PackageNameWidget(rootPackageName),
            CheckBoxWidget(generateFragment),
            CheckBoxWidget(generateListFragment),
            TextFieldWidget(fragmentLayoutName),
        )



        thumb {
            if (generateListFragment.value) {
                File("template_list_fragment.png")
            } else {
                File("template_blank_fragment.png")
            }
        }

        recipe = { data: TemplateData ->
            fragmentMVVMRecipe(
                data as ModuleTemplateData,
                moduleName.value,
                fragmentName.value,
                rootPackageName.value,
                generateFragment.value,
                fragmentLayoutName.value,
                generateListFragment.value
            )
        }
    }
