import java.lang.Math.abs
import java.lang.Math.random
import java.lang.Thread.sleep


class Enemigo (x:Int, y:Int, movimiento:Int, agro:Int, rango:Int, hitboxX:Int, hitboxY:Int, var damage: Int, val vision: Int, val nombre: String
):Objetos(x,y,"Enemigo",true,hitboxX,hitboxY){

    val spawnX=x
    val spawnY=y

    val solido=true

    val radioMovimiento=movimiento
    val radioAgro=agro
    val rangoAtaque=rango
    var detectado:Boolean=false


    fun moverse(jugador: Jugador){

        println("$nombre(${x}, ${y})")

        if (jugador.x in x-vision..x+vision && jugador.y in y-vision.. y+vision) {
            detectado=true
        }

        if (detectado==false){
            if(x in 1 .. longitudNivel && y in 1..longitudNivel){

                when((Math.floor(random() * (5 - 0)) + 0).toInt()){
                    0->if (spawnX+radioMovimiento>(x+1)){
                        x++
                    }
                    1->if (spawnX-radioMovimiento<(x-1)){
                        x--
                    }
                    2->if (spawnY+radioMovimiento>(y+1)){
                        y++
                    }
                    3->if (spawnY-radioMovimiento<(y-1)){
                        y--
                    }
                    4-> print("")
            }
        }

    }else if (detectado==true){
        atacar(jugador)

    }
}

    fun atacar(jugador: Jugador){

        if (abs(jugador.x-x)<rangoAtaque && abs(jugador.y-y)<rangoAtaque){
            jugador.vida=jugador.vida-damage

        }else if (jugador.x in spawnX-radioAgro..spawnX+radioAgro && jugador.y in spawnY-radioAgro..spawnY+radioAgro){
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
            println("persiguiendo")
        }

    }
}