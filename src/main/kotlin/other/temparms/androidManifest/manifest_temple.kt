package other.temparms.androidManifest

fun manifestTemplateXml(
    packageName: String,
    activityClass: String
) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application>
	    <activity 
            android:name="${packageName}.ui.activity.${activityClass}" />
    </application>
</manifest>
"""