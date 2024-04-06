package com.example.movie_compose

import java.text.DecimalFormat

/**
 * Created by Mohammad Kashif Ansari on 05,April,2024
 */


fun getTipAmount(userAmount:String,tipPercentage:Float):String{
    return when{
        userAmount.isEmpty()->{
            "0"
        }
        else->{
            val amount=userAmount.toFloat()
            (amount*tipPercentage.div(100)).toString()
        }
    }
}
fun getTotalHeaderAmount(amount:String,personCounter:Int,tipPercentage:Float):String{
    return when{
        amount.isEmpty()->{
            "0"
        }else->{
            val userAMount=amount.toFloat()
            val tipAmount=userAMount*tipPercentage.div(100)
            val perHeadAMount=(userAMount+tipAmount).div(personCounter)
            perHeadAMount.toString()
        }
    }
}
fun decimalPoint(str:String):String{
    return if(str.isEmpty())""
    else{
        val format= DecimalFormat("######################.##")
        format.format(str.toFloat())
    }
}