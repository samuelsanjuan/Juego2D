import java.lang.Math.abs
import java.lang.Math.random
import javax.swing.ImageIcon

class Enemigo (x:Int,y:Int, val movimiento: Int, val agro: Int, val rango: Int, hitboxX:Int, hitboxY:Int, var damage: Int, val vision: Int, val nombre: String,val textura:ImageIcon) :Objetos(x,y,"Enemigo",true,hitboxX,hitboxY){

    val spawnX=x
    val spawnY=y

    var detectado:Boolean=false


    fun moverse(jugador: Jugador){

        println("$nombre($x, $y) ${jugador.vida}")

        if (jugador.x in x-vision..x+vision+hitboxX && jugador.y in y-vision.. y+vision+hitboxY) {
            detectado=true
        }

        jugador.damaged=false

        if (detectado==false){
            if(x in 1 .. longitudNivel && y in 1..longitudNivel){

                when((Math.floor(random() * (5 - 0)) + 0).toInt()){
                    0->if (spawnX+movimiento>x){
                        x++
                    }
                    1->if (spawnX-movimiento<x){
                        x--
                    }
                    2->if (spawnY+movimiento>y){
                        y++
                    }
                    3->if (spawnY-movimiento<y){
                        y--
                    }
                    4-> print("")
            }
                     if (x>spawnX+movimiento)x--
                else if (x<spawnX-movimiento)x++
                else if (y>spawnY+movimiento)y--
                else if (y<spawnY-movimiento)y++
        }

    }
        else if (detectado==true){

            atacar(jugador)
        }
    }

    fun atacar(jugador: Jugador){

        if (abs(jugador.x-x)<rango && abs(jugador.y-y)<rango){
            jugador.vida=jugador.vida-damage
            jugador.damaged= true

        }else if (jugador.x in spawnX-agro..spawnX+agro && jugador.y in spawnY-agro..spawnY+agro){
            if(jugador.x-x>0){
                x++
            }else if (jugador.x-x<0){
                x--
            }
            if (jugador.y-y>0){
                y++
            }else if (jugador.y-y<0){
                y--
            }
        }
        if (!(jugador.x in spawnX-agro..spawnX+agro && jugador.y in spawnY-agro..spawnY+agro)){
            detectado=false
        }
    }
}