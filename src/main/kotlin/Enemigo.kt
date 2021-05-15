import java.lang.Math.abs
import java.lang.Math.random
import java.lang.Thread.sleep


class Enemigo (x:Int, y:Int, movimiento:Int, agro:Int, rango:Int, hitboxX:Int, hitboxY:Int,daño:Int,vision:Int):Objetos(x,y,"Enemigo",true,hitboxX,hitboxY){

    val SpawnX=x
    val SpawnY=y

    val solido=true
    val vision=vision
    val daño= daño

    val radioMovimiento=movimiento
    val radioAgro=agro
    val rangoAtaque=rango
    var detectado:Boolean=false


    fun moverse(jugador: Jugador){

        sleep(250)
        println("E(${this.x}, ${this.y})")

        if (jugador.x in this.x-vision..this.x+vision && jugador.y in this.y-vision.. this.y+vision) {
            detectado=true
        }


        if (detectado==false){
            if(this.x in 1 .. longitudNivel){

                when((Math.floor(random() * (5 - 0)) + 0).toInt()){
                    0->if (SpawnX+radioAgro>this.x++){this.x++}
                    1->if (SpawnX-radioAgro<this.x--){this.x--}
                    2->if (SpawnY+radioAgro>this.y++){this.y++}
                    3->if (SpawnY-radioAgro<this.y--){this.y--}
                    4-> println("enemigo no hizo nada")
            }
        }
    }else if (detectado==true){
        atacar(jugador)

    }
}

    fun atacar(jugador: Jugador){

        if (abs(jugador.x-this.x)<rangoAtaque && abs(jugador.y-this.y)<rangoAtaque){
            jugador.vida=jugador.vida-this.daño

        }else if (jugador.x in SpawnX+radioAgro..SpawnX-radioAgro && jugador.y in SpawnY+radioAgro..SpawnY-radioAgro){
            if(jugador.x-this.x>0){
                this.x++
            }else if (jugador.x-this.x<0){
                this.x--
            }
            if (jugador.y-this.y>0){
                this.y++
            }else if (jugador.y-this.y<0){
                this.y--
            }
        }

    }
}