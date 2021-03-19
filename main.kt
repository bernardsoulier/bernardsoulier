import java.text.DecimalFormat

/* formula for conversions adapted from doi: 10.3949/ccjm.88a.19135
* note - for artifact .jar build in intellij, need to change manifest.mf dir \kotlin to \src
* include files tick, extroct to jar tick
*
* use: java -jar a1cTool number1 parameter2
* for default/without parameter2 # is converted to eAG
* parameter2 f -- number1 converted from fructosamine to A1c and eAG
* parameter2 g -- number1  converted from average glucose to A1c
*
* */

fun main(args: Array<String>) {
    val val1: Float = args[0].toFloat()
    fun eAG(a1cVal:Float) = "%.2f".format(28.7 * a1cVal -46.7)
    var param2 = "a1c"
    if (args.size > 1) param2 = args[1]
    val fructCalc = "%.2f".format(0.017 * val1 + 1.61)
    val estA1c = "%.2f".format((val1 + 46.7)/28.7)
    when(param2){
        "f" -> println("Fructosamine: $val1 is an A1c: $fructCalc and estimated avg glc: ${eAG(fructCalc.toFloat())}")
        "g" -> println("Average glucose: $val1 is an A1c of: $estA1c")
        else -> println("a1c: ${val1} is estimated average glucose of: ${eAG(val1)}")
    }
}