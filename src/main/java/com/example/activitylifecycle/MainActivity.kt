package com.example.activitylifecycle

import android.app.ActivityManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.activitylifecycle.ui.theme.ActivityLifecycleTheme


open class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyObserver())
    }

    var activityManager: ActivityManager? = null
    fun getAppTaskState(): String {
        val stringBuilder = StringBuilder()

        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val recentTasks = activityManager.getRunningTasks(10)
        stringBuilder.append("\nTotal Number of Tasks: ${recentTasks.size}\n\n")

        activityManager.getRunningTasks(10)?.forEach { info ->
            stringBuilder.append("Task Id: ${info.id}, Number of Activities: ${info.numActivities}\n")
            stringBuilder.append("Top Activity: ${info.topActivity?.className.toString()}\n")
            stringBuilder.append("Base Activity: ${info.baseActivity?.className.toString()}\n\n")
        }
        Log.i("Message",stringBuilder.toString())
        return stringBuilder.toString()
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivityLifecycleTheme {
        Greeting("Android")
    }
}


class MyObserver : DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        // Handle ON_RESUME event here
        Log.i("MESSAGE","MY Observer DefaultLifecycle")
    }
}