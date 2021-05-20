abstract class Objetos (x:Int,y:Int,tipo:String,solido:Boolean,hitboxX:Int,hitboxY:Int){
    var x=x
    var y=y
    val tipo=tipo
    val hitboxX=hitboxX
    val hitboxY=hitboxY

    override fun toString(): String {
        return "Posicion = ("+x+","+y+")-("+(hitboxX+x)+","+(hitboxY+y)+") Tipo : "+tipo
    }
}