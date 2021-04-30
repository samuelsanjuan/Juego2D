class Jugador (x:Int, y:Int,teclado:ControlesTeclado):Objetos(x,y,"Jugador",true,hitboxX = 1,hitboxY = 1){

    val teclado =teclado
    var enMovimiento=false

    fun actualizar(){

        var desplazamientoX=0
        var desplazamientoY=0

        if(teclado.arriba!!){
            desplazamientoY-=2
        }
        if (teclado.abajo!!){
            desplazamientoY+=2
        }
        if (teclado.izquierda!!){
            desplazamientoX-=2
        }
        if (teclado.derecha!!){
            desplazamientoX+=2
        }
        if (desplazamientoX!=0||desplazamientoY!=0){
            enMovimiento=true
            mover(desplazamientoX,desplazamientoY)
        }else{
            enMovimiento=false
        }
    }

    fun mover(xMovimiento:Int,yMovimiento: Int){

        x+=xMovimiento
        y+=yMovimiento

        println(x)
        println(y)

    }

}