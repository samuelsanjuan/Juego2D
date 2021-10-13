import javax.swing.ImageIcon

class Jugador (x:Int, y:Int):Objetos(x,y,"Jugador",true,hitboxX = 16,hitboxY = 16){

    var enMovimiento=false
    var textura=ImageIcon("src/main/resources/Player.png")

    //stats

    val vidaMaxima=100
    var vida=vidaMaxima
    var damaged= false


    fun actualizar(){

        if (!damaged && vida>0){
            textura=ImageIcon("src/main/resources/Player.png")

        }else if (damaged){
            textura=ImageIcon("src/main/resources/playerdmg.png")

        }else if (!damaged && vida<=0){
            textura=ImageIcon("src/main/resources/Enemy.png")
        }

        var desplazamientoX=0
        var desplazamientoY=0

        if(ControlesTeclado.arriba == true){
            desplazamientoY-=1
            println(desplazamientoY)
        }
        if (ControlesTeclado.abajo== true){
            desplazamientoY+=1
            println(desplazamientoY)
        }
        if (ControlesTeclado.izquierda== true){
            desplazamientoX-=1
            println(desplazamientoX)
        }
        if (ControlesTeclado.derecha==true){
            desplazamientoX+=1
            println(desplazamientoX)
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

        println("J:($x , $y) $nivelActual, $vida")


    }

}