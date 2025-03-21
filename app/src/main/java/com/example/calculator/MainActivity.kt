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
            val numberButtons = listOf(one, two, three, four, five, six, seven, eight, nine, zero)

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
        binding.mul.setOnClickListener{

            //handle empty inputs
            if(binding.edForCalNumbers.text.toString().isEmpty())
            {
                Snackbar.make(binding.root,"Please enter number first!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //operator already picked and in use
            if(!makeMul)
            {
                Snackbar.make(binding.root,"Operator already picked!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //if validation cool do this 3 line of code
            val setEnteredNumberAfterMul = binding.edForCalNumbers.text.toString()
            binding.tvForCalculationShow.text = setEnteredNumberAfterMul
            binding.edForCalNumbers.setText("")

            //making operator false to forbid use second time after pick
            makeMul = false
        }

        //DIV
        binding.div.setOnClickListener{

            //handle empty inputs
            if(binding.edForCalNumbers.text.toString().isEmpty())
            {
                Snackbar.make(binding.root,"Please enter number first!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //operator already picked and in use
            if(!makeDiv)
            {
                Snackbar.make(binding.root,"Operator already picked!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //if validation cool do this 3 line of code
            val setEnteredNumberAfterMul = binding.edForCalNumbers.text.toString()
            binding.tvForCalculationShow.text = setEnteredNumberAfterMul
            binding.edForCalNumbers.setText("")

            //making operator false to forbid use second time after pick
            makeDiv = false
        }

        //PLUS
        binding.plus.setOnClickListener{

            //handle empty inputs
            if(binding.edForCalNumbers.text.toString().isEmpty())
            {
                Snackbar.make(binding.root,"Please enter number first!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //operator already picked and in use
            if(!makePlus)
            {
                Snackbar.make(binding.root,"Operator already picked!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //if validation cool do this 3 line of code
            val setEnteredNumberAfterMul = binding.edForCalNumbers.text.toString()
            binding.tvForCalculationShow.text = setEnteredNumberAfterMul
            binding.edForCalNumbers.setText("")

            //making operator false to forbid use second time after pick
            makePlus = false
        }


        //MINUS
        binding.minus.setOnClickListener{

            //handle empty inputs
            if(binding.edForCalNumbers.text.toString().isEmpty())
            {
                Snackbar.make(binding.root,"Please enter number first!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //operator already picked and in use
            if(!makeMinus)
            {
                Snackbar.make(binding.root,"Operator already picked!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //if validation cool do this 3 line of code
            val setEnteredNumberAfterMul = binding.edForCalNumbers.text.toString()
            binding.tvForCalculationShow.text = setEnteredNumberAfterMul
            binding.edForCalNumbers.setText("")

            //making operator false to forbid use second time after pick
            makeMinus = false
        }

        //CALCULATE
        binding.goCalculate.setOnClickListener{

            val numOneText = binding.tvForCalculationShow.text.toString()
            val numTwoText = binding.edForCalNumbers.text.toString()

            if(numOneText.length>4)
            {
                Snackbar.make(binding.root,"max",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(numTwoText.length>4)
            {
                Snackbar.make(binding.root,"max",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(numOneText.isEmpty() || numTwoText.isEmpty())
            {
                Snackbar.make(binding.root,"Please enter number first!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(makeMul && makeDiv && makePlus && makeMinus)
            {
                Snackbar.make(binding.root,"Please enter number first!!",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val numOne = numOneText.toInt()
            val numTwo = numTwoText.toInt()

            if(!makeMul)
            {
                val res = numOne*numTwo
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMul = true
                makeDiv = true
                makePlus = true
                makeMinus = true
            }
            else if(!makeDiv)
            {
                if(numTwo == 0)
                {
                    Snackbar.make(binding.root,"Undefined",Snackbar.LENGTH_SHORT).show()
                    binding.edForCalNumbers.setText("")
                    binding.tvForCalculationShow.text = ""
                    return@setOnClickListener
                }
                val res = numOne/numTwo
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMul = true
                makeDiv = true
                makePlus = true
                makeMinus = true
            }
            else if(!makePlus)
            {
                val res = numOne+numTwo
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMul = true
                makeDiv = true
                makePlus = true
                makeMinus = true
            }
            else if(!makeMinus)
            {
                val res = numOne-numTwo
                binding.tvForCalculationShow.text = "= $res"
                binding.edForCalNumbers.setText("")
                makeMul = true
                makeDiv = true
                makePlus = true
                makeMinus = true
            }
        }
    }
}