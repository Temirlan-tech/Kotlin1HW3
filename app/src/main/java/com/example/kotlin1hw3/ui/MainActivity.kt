package com.example.kotlin1hw3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.kotlin1hw3.R
import com.example.kotlin1hw3.ui.Adapters.MenuAdapter
import com.example.kotlin1hw3.ui.first_fragment.FirstFragment
import com.example.kotlin1hw3.ui.second_fragment.SecondFragment
import com.example.kotlin1hw3.ui.third_fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var previewMenuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)


        val menuAdapter = MenuAdapter(initFragments(), supportFragmentManager)
        view_pager.adapter = menuAdapter

        navigation_view.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.menuOption1 ->{
                    view_pager.currentItem = 0
                }

                R.id.menuOption2 ->{
                    view_pager.currentItem = 1
                }

                R.id.menuOption3 ->{
                    view_pager.currentItem = 2
                }

            }

            true
        }

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                if (::previewMenuItem.isInitialized){
                    previewMenuItem.isChecked = false

                } else {
                    navigation_view.menu.getItem(0).isChecked = false
                }

                navigation_view.menu.getItem(position).isChecked = true
                previewMenuItem = navigation_view.menu.getItem(position)
            }

        })
    }


    private fun initFragments() : ArrayList<Fragment>{
        return arrayListOf(
            FirstFragment.newInstance(),
            SecondFragment.newInstance(),
            ThirdFragment.newInstance()
        )
    }
}

//- Добавить ViewPager из 3 фрагментов в MainActivity
//- 1 фрагмент кнопки ‘+’ и ‘-’, при нажатии вызывать соответствующие методы у ViewModel и выполнять необходимую логику
//- 2 фрагмент отображает текущее значение LiveData счетчика
//- 3 фрагмент отображает список выполненных операций (просто список строковых значений, который наблюдаются у ViewModel-a)
//- Для всех задач использовать один ViewModel
//- Добавить BottomNav, связать с основным ViewPager-ом