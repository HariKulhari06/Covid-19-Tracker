package com.hari.covid_19app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hari.covid_19app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.app_bar_main.view.*

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolbar()
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            onDestinationChange(destination)
        }

    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.appBarMain.toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun onDestinationChange(destination: NavDestination) {

        val config = PageConfiguration.getConfiguration(destination.id)

        if (!config.hasTitle) {
            supportActionBar?.title = ""
        }

        binding.appBarMain.logo_layout.isVisible = config.isShowLogoImage

        binding.appBarMain.toolbar.navigationIcon = if (config.isTopLevel) {
            AppCompatResources.getDrawable(this, R.drawable.ic_menu)
        } else {
            AppCompatResources.getDrawable(this, R.drawable.ic_baseline_arrow_back_ios_24)
        }.apply {
            this?.setTint(R.attr.colorOnSurface)
        }

    }


}