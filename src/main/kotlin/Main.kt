open class Elemento(val nome : String)
{
    open fun Particula.reage(nome : String) : Unit
    {
        println("$nome reage com uma partícula.")
    }
    open fun Eletron.reage(nome : String) : Unit
    {
        println("$nome é elemento reativo, portanto, doa ou recebe elétrons.")
    }
    fun reage(particula: Particula) : Unit
    {
        particula.reage(nome)
    }
    open fun reage(eletron: Eletron)
    {
        eletron.reage(nome)
    }
    class GasNobre(nome : String) : Elemento(nome)
    {
        override fun Particula.reage(nome : String) : Unit
        {
            println("$nome é um gás nobre, não reage com demais elementos.")
        }
        override fun Eletron.reage(nome : String) : Unit
        {
            println("$nome é umg gás nobre, portanto, nem recebe nem doa elétrons.")
        }
        override fun reage(particula : Eletron) : Unit {
            particula.reage(nome)
        }
    }
}

class Eletron {

}

class Particula {

}

fun main()
{
    val calcio = Elemento("Cálcio")
    calcio.reage(Particula())
    calcio.reage(Eletron())

    val argonio = Elemento.GasNobre("Argonio")
    argonio.reage(Particula())
    argonio.reage(Eletron())
}