package com.example.calculator
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button;
import android.widget.TextView
import android.util.Log
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log
import kotlin.math.sin
import kotlin.math.tan

// Zachary Baker is my partner

class MainActivity : AppCompatActivity() {

    /**
     * The main variable for what is displayed on the screen
     */
    var display = ""

    /**
     * The backlog of information, that is compressed and calculated upon
     */
    var backlog = ""


    /**
     * onCreate() creates buttons for the calculator.
     * Describes what happens when buttons are pressed.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val write: TextView=findViewById(R.id.numDisplay)

        /**
         * The 1 button's functionality
         */
        val click1: Button=findViewById(R.id.button1)
        click1.setOnClickListener {
            display += "1"
            write.text=display
            Log.d("Button1", "clicked")
        }

        /**
         * The 2 button's functionality
         */
        val click2: Button=findViewById(R.id.button2)
        click2.setOnClickListener {
            display += "2"
            write.text=display
            Log.d("Button2", "clicked")
        }

        /**
         * The 3 button's functionality
         */
        val click3: Button=findViewById(R.id.button3)
        click3.setOnClickListener {
            display += "3"
            write.text=display
            Log.d("Button3", "clicked")
        }

        /**
         * The 4 button's functionality
         */
        val click4: Button=findViewById(R.id.button4)
        click4.setOnClickListener {
            display += "4"
            write.text=display
            Log.d("Button4", "clicked")
        }

        /**
         * The 5 button's functionality
         */
        val click5: Button=findViewById(R.id.button5)
        click5.setOnClickListener {
            display+="5"
            write.text=display
            Log.d("Button5", "clicked")
        }

        /**
         * The 6 button's functionality
         */
        val click6: Button=findViewById(R.id.button6)
        click6.setOnClickListener {
            display+="6"
            write.text=display
            Log.d("Button6", "clicked")
        }

        /**
         * The 7 button's functionality
         */
        val click7: Button=findViewById(R.id.button7)
        click7.setOnClickListener {
            display+="7"
            write.text=display
            Log.d("Button7", "clicked")
        }

        /**
         * The 8 button's functionality
         */
        val click8: Button=findViewById(R.id.button8)
        click8.setOnClickListener {
            display+="8"
            write.text=display
            Log.d("Button8", "clicked")
        }

        /**
         * The 9 button's functionality
         */
        val click9: Button=findViewById(R.id.button9)
        click9.setOnClickListener {
            display += "9"
            write.text = display
            Log.d("Button9", "clicked")
        }

        /**
         * The 0 button's functionality
         */
        val click0: Button=findViewById(R.id.button0)
        click0.setOnClickListener {
            if (display != "") {
                display += "0"
                write.text = display
                Log.d("Button0", "clicked")
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
            Log.d("ButtonC", "clicked")
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
                Log.d("ButtonAdd", "clicked")
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
                Log.d("ButtonSubtract", "clicked")
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
                Log.d("ButtonMultiply", "clicked")
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
                Log.d("ButtonDivide", "clicked")
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
                Log.d("ButtonDecimal", "clicked")
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
                Log.d("ButtonPercent", "clicked")
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
                Log.d("ButtonEquals", "clicked")
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
                Log.d("ButtonSign", "clicked")
            }
        }

        val orientation: Int = getResources().getConfiguration().orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape

            /**
             * The sine button's functionality
             */
            val clickSin: Button = findViewById(R.id.buttonSin)
            clickSin.setOnClickListener {
                if (display != "") {
                    backlog += display
                    backlog = compressBacklog(backlog)
                    write.text = backlog
                    backlog += "s"
                    display = ""
                    display += "1"
                    backlog = compressBacklog(backlog)
                    write.text = backlog
                    Log.d("ButtonSin", "clicked")
                }
            }


            /**
             * The cosine button's functionality
             */
            val clickCos: Button = findViewById(R.id.buttonCos)
            if (clickCos != null) {
                clickCos.setOnClickListener {
                    if (display != "") {
                        backlog += display
                        backlog = compressBacklog(backlog)
                        write.text = backlog
                        backlog += "c"
                        display = ""
                        display += "1"
                        backlog = compressBacklog(backlog)
                        write.text = backlog
                        Log.d("ButtonCos", "clicked")
                    }
                }
            }

            /**
             * The tangent button's functionality
             */
            val clickTan: Button = findViewById(R.id.buttonTan)
            if (clickTan != null) {
                clickTan.setOnClickListener {
                    if (display != "") {
                        backlog += display
                        backlog = compressBacklog(backlog)
                        write.text = backlog
                        backlog += "t"
                        display = ""
                        display += "1"
                        backlog = compressBacklog(backlog)
                        write.text = backlog
                        Log.d("ButtonTan", "clicked")
                    }
                }
            }

            /**
             * The Log of 10 button's functionality
             */
            val clickLog: Button = findViewById(R.id.buttonLog)
            if (clickLog != null) {
                clickLog.setOnClickListener {
                    if (display != "") {
                        backlog += display
                        backlog = compressBacklog(backlog)
                        write.text = backlog
                        backlog += "l"
                        display = ""
                        display += "10"
                        Log.d("ButtonLog", "clicked")
                    }
                }
            }

            /**
             * The natural log button's functionality
             */
            val clickLn: Button = findViewById(R.id.buttonLn)
            if (clickLn != null) {
                clickLn.setOnClickListener {
                    if (display != "") {
                        backlog += display
                        backlog = compressBacklog(backlog)
                        write.text = backlog
                        backlog += "l"
                        display = ""
                        display += Math.E.toString()
                        Log.d("ButtonLn", "clicked")
                    }
                }
            }
        }

    }
    /**
     * When screen flips, display and backlog are stored
     */

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key1", display)
        outState.putString("key2", backlog)
        val startScreen: TextView=findViewById(R.id.numDisplay)
        val text = startScreen.text.toString()
        outState.putString("key3", text)

    }

    /**
     * After screen flips, transfer saved variables back into relevant variables
     */

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        display = savedInstanceState.getString("key1", "")
        backlog = savedInstanceState.getString("key2", "")
        val text = savedInstanceState.getString("key3", "")
        val startScreen: TextView=findViewById(R.id.numDisplay)
        startScreen.text = text
    }

    /**
     * Compresses the backlog from two elements to one, so that
     * elements are calculated
     */
    fun compressBacklog(backLog: String): String {
        var num1 = 0.0
        var backStr = ""
        val numArr = backLog.split("+", "_", "/", "x", "s", "c", "t", "l").toTypedArray()
        if (backLog.contains("+") || backLog.contains("_") || backLog.contains("x") || backLog.contains(
                "/") || backLog.contains("s") || backLog.contains("c") || backLog.contains("t")
            || backLog.contains("l")) {
            if (backLog.contains("+")) {
                num1 = numArr[0].toDouble() + numArr[1].toDouble()
            } else if (backLog.contains("_")) {
                num1 = numArr[0].toDouble() - numArr[1].toDouble()
            } else if (backLog.contains("/")) {
                num1 = numArr[0].toDouble() / numArr[1].toDouble()
            } else if (backLog.contains("x")) {
                num1 = numArr[0].toDouble() * numArr[1].toDouble()
            } else if (backLog.contains("s")) {
                num1 = sin(numArr[0].toDouble());
            } else if (backLog.contains("c")) {
                num1 = cos(numArr[0].toDouble());
            } else if (backLog.contains("t")) {
                num1 = tan(numArr[0].toDouble());
            } else if (backLog.contains("l")) {
                num1 = log(numArr[0].toDouble(), numArr[1].toDouble());
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