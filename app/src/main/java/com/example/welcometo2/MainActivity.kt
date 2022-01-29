package com.example.welcometo2

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welcometo2.databinding.ActivityMainBinding
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.EditText
import android.widget.Toast
import android.media.MediaPlayer


class MainActivity : AppCompatActivity() {

    public lateinit var binding:ActivityMainBinding;

    var deck = Deck()

    var actionFig = listOf<Int>(
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3,
        R.drawable.imagen4,
        R.drawable.imagen5,
        R.drawable.imagen6
    )

    var obj1Fig = listOf<Int>(
        R.drawable.obj1_1,
        R.drawable.obj1_2,
        R.drawable.obj1_3,
        R.drawable.obj1_4,
        R.drawable.obj1_5,
        R.drawable.obj1_6
    )

    var obj2Fig = listOf<Int>(
        R.drawable.obj2_1,
        R.drawable.obj2_2,
        R.drawable.obj2_3,
        R.drawable.obj2_4,
        R.drawable.obj2_5,
        R.drawable.obj2_6
    )

    var obj3Fig = listOf<Int>(
        R.drawable.obj3_1,
        R.drawable.obj3_2,
        R.drawable.obj3_3,
        R.drawable.obj3_4,
        R.drawable.obj3_5,
        R.drawable.obj3_6
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val  binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.draw?.setOnClickListener{
            var  drawSound: MediaPlayer = MediaPlayer.create(this, R.raw.draw)
            drawSound.start()
            deck.draw()
            printLayout(binding)
        }

        binding.back?.setOnClickListener{
            deck.back()
            printLayout(binding)
        }


        binding.restart?.setOnLongClickListener{

            Toast.makeText(this, "Long click detected", Toast.LENGTH_SHORT).show()
            true

        }

        binding.restart?.setOnClickListener {



            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)


            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to start a new game?")


                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()

                    var barajaSound : MediaPlayer= MediaPlayer.create(this, R.raw.baraja)
                    barajaSound.start()

                    deck=Deck()
                    deck.shuffle()

                    binding.Obj1?.setImageResource(obj1Fig.get(random(5)))
                    binding.Obj2?.setImageResource(obj2Fig.get(random(5)))
                    binding.Obj3?.setImageResource(obj3Fig.get(random(5)))

                    printLayout(binding)

                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()

            // show alert dialog
            alert.show()


        }



    }

    fun printLayout(binding: ActivityMainBinding) {

        binding.Card1?.setText(deck.numberAt(3).toString())
        binding.Card2?.setText(deck.numberAt(4).toString())
        binding.Card3?.setText(deck.numberAt(5).toString())

        binding.Card4?.setImageResource(actionFig.get(deck.actionAt(0)-1))
        binding.Card5?.setImageResource(actionFig.get(deck.actionAt(1)-1))
        binding.Card6?.setImageResource(actionFig.get(deck.actionAt(2)-1))

        binding.nDeck?.setText(deck.getSize().toString())

    }

    fun random(num:Int): Int {
        val random1 = (0..num).shuffled().last()
        return random1
    }





}