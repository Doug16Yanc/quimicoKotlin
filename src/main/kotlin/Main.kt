import java.util.Objects

fun interface isSubstance {
    fun defineSubstance(ph : Double, formula : String, solubility : Boolean) : String
}

val acido = isSubstance { ph, formula, solubility ->
    (if (ph < 6.9 && formula.contains("H") && solubility) {
        "$formula é um ácido."
    }
    else "$formula não é um ácido.")
}

val base = isSubstance {ph, formula, solubility ->
    (if (ph > 7.1 && formula.contains("OH") && solubility) {
        "$formula é uma base."
    } else "$formula não é uma base")
}

val sal = isSubstance { ph, formula, solubility ->
    (if (ph == 7.0 && formula.isNotEmpty() && solubility) {
        "$formula é um sal."
    }else "$formula não é um sal.")
}

val oxido = isSubstance { ph, formula, solubility ->
    (if ((ph != 0.0) && formula.contains("O") && !solubility) {
        "$formula é um óxido."
    } else "$formula não é um óxido.")
}

fun retornaSubstancia(substance: isSubstance, ph : Double, formula : String, solubility: Boolean) : String {
    return substance.defineSubstance(ph, formula, solubility)
}
enum class State {
    SOLIDO,
    LIQUIDO,
    GASOSO
}

data class Substance(
    val name : String = "",
    val formula : String = "",
    val ph : Double = 0.0,
    val state : State = State.SOLIDO,
    val solubility : Boolean = true)

fun main() {
    var substance = Substance("Cloreto de potássio", "KCl", 7.0, State.SOLIDO, true)

    println(retornaSubstancia(sal, substance.ph, substance.formula, substance.solubility))
}



