package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var makeMul = true
        var makePlus = true
        var makeDiv = true
        var makeMinus = true

        //WRITE NUMBERS IN EDITTEXT
        binding.apply {
            val numberButtons = listOf(one, two, three, four, five, six, seven, eight, nine, zero,mul)

            numberButtons.forEach { button ->
                button.setOnClickListener {
                    edForCalNumbers.append(button.text)
                }
            }
        }

        //CLEAR
        binding.allClear.setOnClickListener{
            binding.edForCalNumbers.setText("")
            binding.tvForCalculationShow.text = ""
            makeMul = true
            makeDiv = true
            makePlus = true
            makeMinus = true
        }

        //MUL
        binding.mul.setOnClickListener {
            val takeFirstNumber = binding.edForCalNumbers.text.toString()

            if (takeFirstNumber.isEmpty()) {
                Snackbar.make(it, "Enter number please!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!makeMul) {
                Snackbar.make(it, "Operation is already picked!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Set first number in the text view
            binding.tvForCalculationShow.text = takeFirstNumber

            // Disable further multiplication clicks
            makeMul = false

            // Clear input field
            binding.edForCalNumbers.setText("")
        }

        //DIV
        binding.div.setOnClickListener {
            val takeFirstNumber = binding.edForCalNumbers.text.toString()

            if (takeFirstNumber.isEmpty()) {
                Snackbar.make(it, "Enter number please!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!makeDiv) {
                Snackbar.make(it, "Operation is already picked!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Set first number in the text view
            binding.tvForCalculationShow.text = takeFirstNumber

            // Disable further multiplication clicks
            makeDiv = false

            // Clear input field
            binding.edForCalNumbers.setText("")
        }

        //PLUS
        binding.plus.setOnClickListener {
            val takeFirstNumber = binding.edForCalNumbers.text.toString()

            if (takeFirstNumber.isEmpty()) {
                Snackbar.make(it, "Enter number please!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!makePlus) {
                Snackbar.make(it, "Operation is already picked!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Set first number in the text view
            binding.tvForCalculationShow.text = takeFirstNumber

            // Disable further multiplication clicks
            makePlus = false

            // Clear input field
            binding.edForCalNumbers.setText("")
        }

        //MINUS
        binding.minus.setOnClickListener {
            val takeFirstNumber = binding.edForCalNumbers.text.toString()

            if (takeFirstNumber.isEmpty()) {
                Snackbar.make(it, "Enter number please!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!makeMinus) {
                Snackbar.make(it, "Operation is already picked!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Set first number in the text view
            binding.tvForCalculationShow.text = takeFirstNumber

            // Disable further multiplication clicks
            makeMinus = false

            // Clear input field
            binding.edForCalNumbers.setText("")
        }

        binding.goCalculate.setOnClickListener{

            if(binding.edForCalNumbers.text.isEmpty())
            {
                Snackbar.make(it,"Enter number please!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val fNum = binding.tvForCalculationShow.text.toString().toInt()
            val sNum = binding.edForCalNumbers.text.toString().toInt()


            if(!makeMul) {
                val res = fNum*sNum
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMul = true
            }
            else if (!makeDiv)
            {
                if(fNum == 0 && sNum == 0)
                {
                    Snackbar.make(it,"Result is undefined",Snackbar.LENGTH_SHORT).show()
                    binding.tvForCalculationShow.text = ""
                    binding.edForCalNumbers.setText("")
                    return@setOnClickListener
                }

                val res = fNum/sNum
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMul = true
            }
            else if (!makePlus)
            {
                val res = fNum+sNum
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makePlus = true
            }
            else if(!makeMinus)
            {
                val res = fNum-sNum
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMinus = true
            }
        }
    }
}