abstract class Objetos (x:Int,y:Int,tipo:String){
    var x=x
    var y=y
    val tipo=tipo
    fun getPosition():Array<Int>{
        return arrayOf(x,y)
    }
}