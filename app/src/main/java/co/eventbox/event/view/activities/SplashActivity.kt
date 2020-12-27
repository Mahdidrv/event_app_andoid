package co.eventbox.event.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.event.R
import co.eventbox.event.utilities.gone
import co.eventbox.event.utilities.visible
import co.eventbox.event.viewModel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_splash.*


class SplashActivity : AppCompatActivity(), Observer<Boolean> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)
        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashViewModel.cacheData().observe(this, this)

        btnTryAgain.setOnClickListener {
            btnTryAgain.visibility = View.INVISIBLE
            progressBar.visible()
            splashViewModel.cacheData().observe(this, this)
        }
    }

    override fun onChanged(t: Boolean?) {
        if (t != null && t) {
            finish()
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        } else {
            btnTryAgain.visible()
            progressBar.gone()
        }
    }




}
