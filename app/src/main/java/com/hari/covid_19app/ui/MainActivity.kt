package com.hari.covid_19app.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ActivityMainBinding
import com.hari.covid_19app.model.NightMode
import com.hari.covid_19app.model.NightMode.YES
import com.hari.covid_19app.utils.ext.assistedActivityViewModels
import com.hari.covid_19app.utils.ext.getThemeColor
import com.hari.covid_19app.utils.ext.stringRes
import com.hari.covid_19app.utils.pref.ThemePrefs
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.view.*
import javax.inject.Inject
import javax.inject.Provider


class MainActivity : DaggerAppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    @Inject
    lateinit var systemViewModelProvider: Provider<SystemViewModel>
    private val systemViewModel: SystemViewModel by assistedActivityViewModels {
        systemViewModelProvider.get()
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val navController: NavController by lazy {
        Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolbar()
        setUpNavigation()
        setUpAppTheme()

        systemViewModel.errorLiveData.observe(this, Observer { appError ->
            Snackbar
                .make(
                    findViewById(R.id.nav_host_fragment),
                    appError.stringRes(),
                    Snackbar.LENGTH_LONG
                )
                .show()
        })
    }

    private fun setUpAppTheme() {
        val nightMode = ThemePrefs(this).getNightMode().toNightMode()
        (binding.navView.menu.findItem(R.id.nav_dark_mode).actionView as SwitchCompat).isChecked =
            nightMode == YES
        systemViewModel.setNightMode(nightMode)

        systemViewModel.uiModel.observe(this, Observer { uiModel ->
            AppCompatDelegate.setDefaultNightMode(uiModel.nightMode.platformValue)
            ThemePrefs(this).setNightMode(uiModel.nightMode.toNightModeValue)
        })

    }

    private fun setUpNavigation() {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            PageConfiguration.values().filter { it.isTopLevel }.map { it.id }.toSet(),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            onDestinationChange(destination)
        }

        binding.navView.setNavigationItemSelectedListener { item ->
            handleNavigation(item)
        }

        binding.navView.getHeaderView(0).findViewById<ImageView>(R.id.image_close)
            .setOnClickListener {
                binding.drawerLayout.closeDrawers()
            }
    }

    private fun handleNavigation(item: MenuItem): Boolean {
        binding.drawerLayout.closeDrawers()

        if (item.itemId == R.id.nav_dark_mode) {
            val switch = item.actionView as SwitchCompat
            systemViewModel.toggleNightMode()
            switch.toggle()
            return true
        }

        return try {
            if (navController.currentDestination?.id == item.itemId) return false
            val builder = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(R.id.nav_home, false)
            val options = builder.build()
            navController.navigate(item.itemId, null, options)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.appBarMain.toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun onDestinationChange(destination: NavDestination) {

        val config =
            PageConfiguration.getConfiguration(
                destination.id
            )

        if (!config.hasTitle) {
            supportActionBar?.title = ""
        }

        binding.appBarMain.logo_layout.isVisible = config.isShowLogoImage

        binding.appBarMain.toolbar.navigationIcon = if (config.isTopLevel) {
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_menu
            )
        } else {
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_baseline_arrow_back_ios_24
            )
        }.apply {
            this?.setTint(getThemeColor(R.attr.colorOnSurface))
        }
    }



    private val NightMode.toNightModeValue: String
        get() = when (this) {
            YES -> getString(R.string.pref_theme_value_dark)
            NightMode.NO -> getString(R.string.pref_theme_value_light)
        }

    private val NightMode.platformValue: Int
        get() = when (this) {
            YES -> AppCompatDelegate.MODE_NIGHT_YES
            NightMode.NO -> AppCompatDelegate.MODE_NIGHT_NO
        }

    private fun Int.toNightMode(): NightMode {
        return when (this) {
            AppCompatDelegate.MODE_NIGHT_YES -> {
                YES
            }
            else -> {
                NightMode.NO
            }
        }

    }

}




