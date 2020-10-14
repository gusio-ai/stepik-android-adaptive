package org.stepik.android.adaptive.util

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor

object DebugToolsHelper {
    private val networkPlugin = NetworkFlipperPlugin()

    fun initDebugTools(app: Application) {
        if (FlipperUtils.shouldEnableFlipper(app)) {
            Stetho.initializeWithDefaults(app)

            SoLoader.init(app, false)

            val client = AndroidFlipperClient.getInstance(app)
            client.addPlugin(InspectorFlipperPlugin(app, DescriptorMapping.withDefaults()))
            client.addPlugin(DatabasesFlipperPlugin(app))
            client.addPlugin(SharedPreferencesFlipperPlugin(app))
            client.addPlugin(NavigationFlipperPlugin.getInstance())
            client.addPlugin(networkPlugin)

            client.start()
        }
    }

    fun getDebugInterceptors(): Set<Interceptor> =
        setOf(
            StethoInterceptor(),
            FlipperOkhttpInterceptor(networkPlugin)
        )
}
