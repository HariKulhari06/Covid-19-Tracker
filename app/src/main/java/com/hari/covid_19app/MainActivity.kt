package com.hari.covid_19app

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hari.covid_19app.databinding.ActivityMainBinding
import com.hari.covid_19app.utils.ext.getThemeColor
import kotlinx.android.synthetic.main.app_bar_main.view.*


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolbar()
        setUpNavigation()

        lifecycleScope.launchWhenResumed {
            val database = Firebase.database.getReference("Preventions")

            database.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    val message = p0.message
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val value = p0.value
                }

            })
        }
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
            handleNavigation(item.itemId)
        }

        binding.navView.getHeaderView(0).findViewById<ImageView>(R.id.image_close)
            .setOnClickListener {
                binding.drawerLayout.closeDrawers()
            }
    }

    private fun handleNavigation(itemId: Int): Boolean {
        binding.drawerLayout.closeDrawers()

        if (itemId == R.id.nav_dark_mode) {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            return true
        }

        return try {
            if (navController.currentDestination?.id == itemId) return false
            val builder = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(R.id.nav_home, false)
            val options = builder.build()
            navController.navigate(itemId, null, options)
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

        val config = PageConfiguration.getConfiguration(destination.id)

        if (!config.hasTitle) {
            supportActionBar?.title = ""
        }

        binding.appBarMain.logo_layout.isVisible = config.isShowLogoImage

        binding.appBarMain.toolbar.navigationIcon = if (config.isTopLevel) {
            ContextCompat.getDrawable(this, R.drawable.ic_menu)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_ios_24)
        }.apply {
            this?.setTint(getThemeColor(R.attr.colorOnSurface))
        }
    }

}