package org.phash.gamingmvvmproject

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.phash.gamingmvvmproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var b: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController
        window.statusBarColor = getColor(R.color.blue_dark)
        window.navigationBarColor = getColor(R.color.blue_dark)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        b.bnvMain.itemIconTintList = null;
    }

    private fun fragmentIsNotOpened(fragment: Int): Boolean {
        val currentDestination = navController.currentBackStackEntry?.destination
        return currentDestination?.id != fragment
    }
}