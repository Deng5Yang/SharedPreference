package deng.com.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

//import下面這個就不用像java一樣用findViewById了
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit 檢查是否初始化,var 變量
    private lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEventListener()

    }

    private fun saveData(){
        settings = getSharedPreferences(DATA,0) //讀取 DATA 第0個的儲存位置
        settings.edit() //開始編輯,寫入DATA 第0個的儲存位置
                //editText裡面的text可以直接用.text取出後再用toString()轉成字串
                .putString(NAME,name.text.toString())
                .putString(PHONE,phone.text.toString())
                .putString(SEX,sex.text.toString())
                .apply() //編輯完成送出
        Toast.makeText(this,"save success",Toast.LENGTH_SHORT).show()
    }

    private fun readData(){
        settings = getSharedPreferences(DATA,0) //讀取 DATA 第0個的儲存位置
        name.setText(settings.getString(NAME,""))
        phone.setText(settings.getString(PHONE,""))
        sex.setText(settings.getString(SEX,""))
        Toast.makeText(this,"read success",Toast.LENGTH_SHORT).show()
    }

    private fun setEventListener() {

        save.setOnClickListener {
            saveData()
        }

        read.setOnClickListener {
            readData()
        }

        clear.setOnClickListener {
            name.setText("");
            phone.setText("");
            sex.setText("");
        }
    }

    companion object{
        //const = public final static
        //val = private final
        private const val DATA = "DATA"
        private const val NAME = "NAME"
        private const val PHONE = "PHONE"
        private const val SEX = "SEX"
    }
}
