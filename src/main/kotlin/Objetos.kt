abstract class Objetos (x:Int,y:Int,tipo:String,solido:Boolean,hitboxX:Int,hitboxY:Int){
    var x=x
    var y=y
    val tipo=tipo
    val hitboxX=hitboxX
    val hitboxY=hitboxY

    fun moverse(xFinal:Int,yFinal: Int){
        if ((xFinal-1==x||xFinal+1==x||xFinal==x)&&(yFinal+1==y||yFinal==y||yFinal-1==y)){
            x=xFinal
            y=yFinal
        }
    }

    override fun toString(): String {
        return "Posicion = ("+x+","+y+")-("+(hitboxX+x)+","+(hitboxY+y)+") Tipo : "+tipo
    }
}