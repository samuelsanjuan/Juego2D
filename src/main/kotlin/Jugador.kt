class Jugador (x:Int, y:Int):Objetos(x,y,"Jugador",true,hitboxX = 1,hitboxY = 1){

    var enMovimiento=false

    fun actualizar(){

        ControlesTeclado.actualizar()

        var desplazamientoX=0
        var desplazamientoY=0

        if(ControlesTeclado.arriba == true){
            desplazamientoY-=1
        }
        if (ControlesTeclado.abajo== true){
            desplazamientoY+=1
        }
        if (ControlesTeclado.izquierda== true){
            desplazamientoX-=1
        }
        if (ControlesTeclado.derecha==true){
            desplazamientoX+=1
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