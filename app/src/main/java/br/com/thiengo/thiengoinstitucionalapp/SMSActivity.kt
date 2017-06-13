package br.com.thiengo.thiengoinstitucionalapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.content_sms.*
import org.jetbrains.anko.sendSMS

class SMSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        et_mensagem.text = Editable
                .Factory
                .getInstance()
                .newEditable( intent.getStringExtra("inicio_texto") )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    fun enviarSms( view: View? ){
        sendSMS("999887766", et_mensagem.text.toString())
    }
}
