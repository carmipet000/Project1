package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;
import android.widget.TextView

// Zachary Baker is my partner

class MainActivity : AppCompatActivity() {

    /**
     * onCreate() creates buttons for the calculator.
     * Describes what happens when buttons are pressed.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * The main variable for what is displayed on the screen
         */
        var display = ""

        /**
         * The backlog of information, that is compressed and calculated upon
         */
        var backlog = ""



        val write: TextView=findViewById(R.id.numDisplay)


        /**
         * The 1 button's functionality
         */
        val click1: Button=findViewById(R.id.button1)
        click1.setOnClickListener {
            display += "1"
            write.text=display
        }

        /**
         * The 2 button's functionality
         */
        val click2: Button=findViewById(R.id.button2)
        click2.setOnClickListener {
            display += "2"
            write.text=display
        }

        /**
         * The 3 button's functionality
         */
        val click3: Button=findViewById(R.id.button3)
        click3.setOnClickListener {
            display += "3"
            write.text=display
        }

        /**
         * The 4 button's functionality
         */
        val click4: Button=findViewById(R.id.button4)
        click4.setOnClickListener {
            display += "4"
            write.text=display
        }

        /**
         * The 5 button's functionality
         */
        val click5: Button=findViewById(R.id.button5)
        click5.setOnClickListener {
            display+="5"
            write.text=display
        }

        /**
         * The 6 button's functionality
         */
        val click6: Button=findViewById(R.id.button6)
        click6.setOnClickListener {
            display+="6"
            write.text=display
        }

        /**
         * The 7 button's functionality
         */
        val click7: Button=findViewById(R.id.button7)
        click7.setOnClickListener {
            display+="7"
            write.text=display
        }

        /**
         * The 8 button's functionality
         */
        val click8: Button=findViewById(R.id.button8)
        click8.setOnClickListener {
            display+="8"
            write.text=display
        }

        /**
         * The 9 button's functionality
         */
        val click9: Button=findViewById(R.id.button9)
        click9.setOnClickListener {
            display += "9"
            write.text = display
        }

        /**
         * The 0 button's functionality
         */
        val click0: Button=findViewById(R.id.button0)
        click0.setOnClickListener {
            if (display != "") {
                display += "0"
                write.text = display
            }
        }

        /**
         * The C button's functionality
         */
        val clickC: Button=findViewById(R.id.buttonC)
        clickC.setOnClickListener {
            display = ""
            backlog = ""
            write.text = "0"
        }

        /**
         * The + button's functionality
         */
        val clickAdd: Button=findViewById(R.id.buttonAdd)
        clickAdd.setOnClickListener {
            if (display != "") {
                backlog += display
                backlog = compressBacklog(backlog)
                write.text = backlog
                backlog += "+"
                display = ""
            }
        }

        /**
         * The - button's functionality
         */
        val clickSubtract: Button=findViewById(R.id.buttonSubtract)
        clickSubtract.setOnClickListener {
            if (display != "") {
                backlog += display
                backlog = compressBacklog(backlog)
                write.text = backlog
                backlog += "_"
                display = ""
            }
        }

        /**
         * The X button's functionality
         */
        val clickMultiply: Button=findViewById(R.id.buttonMultiply)
        clickMultiply.setOnClickListener {
            if (display != "") {
                backlog += display
                backlog = compressBacklog(backlog)
                write.text = backlog
                backlog += "x"
                display = ""
            }
        }

        /**
         * The / button's functionality
         */
        val clickDivide: Button=findViewById(R.id.buttonDivide)
        clickDivide.setOnClickListener {
            if (display != "") {
                backlog += display
                backlog = compressBacklog(backlog)
                write.text = backlog
                backlog += "/"
                display = ""
            }
        }


        /**
         * The . button's functionality
         */
        val clickDot: Button=findViewById(R.id.buttonDecimal)
        clickDot.setOnClickListener {
            if (!(display.contains("."))) {
                if(display.length==0){
                    display+="0."
                }
                else{
                    display += "."
                }
                write.text = display
            }
        }

        /**
         * The % button's functionality
         */
        val clickPercent: Button=findViewById(R.id.buttonPercent)
        clickPercent.setOnClickListener {
            if (display != "") {
                backlog += display
                backlog = compressBacklog(backlog)
                write.text = backlog
                backlog += "/"
                display = ""
                display += "100"
            }
        }

        /**
         * The = button's functionality
         */
        val clickEqual: Button=findViewById(R.id.buttonEquals)
        clickEqual.setOnClickListener {
            if (display != "") {
                backlog += display
                backlog = compressBacklog(backlog)
                write.text = backlog
                backlog += "+"
                display = ""
                display += "0"
            }
        }

        /**
         * The +/- button's functionality
         */
        val clickSign: Button=findViewById(R.id.buttonSign)
        clickSign.setOnClickListener {
            if (display != "") {
                if (display.first() == '-') {
                    display = display.drop(1)
                } else {
                    display = "-" + display
                }
                write.text = display
            }
        }


    }

    /**
     * Compresses the backlog from two elements to one, so that
     * elements are calculated
     */
    fun compressBacklog(backLog: String): String {
        var num1 = 0.0
        var backStr = ""
        val numArr = backLog.split("+", "_", "/", "x").toTypedArray()
        if (backLog.contains("+") || backLog.contains("_") || backLog.contains("x") || backLog.contains(
                "/"
            )
        ) {
            if (backLog.contains("+")) {
                num1 = numArr[0].toDouble() + numArr[1].toDouble()
            } else if (backLog.contains("_")) {
                num1 = numArr[0].toDouble() - numArr[1].toDouble()
            } else if (backLog.contains("/")) {
                num1 = numArr[0].toDouble() / numArr[1].toDouble()
            } else if (backLog.contains("x")) {
                num1 = numArr[0].toDouble() * numArr[1].toDouble()
            }

            if (num1.toString().substring(num1.toString().length - 2, num1.toString().length)
                    .equals(".0")
            ) {
                backStr = num1.toString().substring(0, num1.toString().length - 2)
            } else {
                backStr = num1.toString()

            }
            return backStr
        } else {
            if (backLog.length == 1) {
                return backLog
            }
            backStr = backLog
            if (backLog.substring(backLog.length - 2, backLog.length).equals(".0")) {
                backStr = backLog.substring(0, backLog.length - 2)
            }
            return backStr
        }
    }
}