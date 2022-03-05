package other.temparms

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

class MVVMPluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        activityMVVMTemplate,
        fragmentMVVMTemplate
    )
}