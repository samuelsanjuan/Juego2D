import java.lang.Thread.sleep
import kotlin.random.Random

class Enemigo (x:Int, y:Int, movimiento:Int, agro:Int, rango:Int):Objetos(x,y,"Enemigo"){

    val SpawnX=x
    val SpawnY=y

    //val solido=true

    val radioMovimiento=movimiento
    //val radioAgro=agro
    //val rangoAtaque=rango


    fun booleanMovimiento(coordenada:Int,Spawn:Int,valor:Int):Boolean{
        if (valor>0){
            return (coordenada+1 < 100 && (coordenada+1 < Spawn+radioMovimiento ))
        }
        else {
            return (coordenada-1 > 100 && (coordenada-1 > Spawn-radioMovimiento ))
        }
    }


    fun moverse(){
        val movement=Random.nextInt(4)+1
        when(movement){

            1->{
                if (booleanMovimiento(x,SpawnX,1)) x++
            }
            2->{
                if (booleanMovimiento(y,SpawnY,1)) y++
            }
            3->{
                if (booleanMovimiento(x,SpawnX,-1)) x--
            }
            4->{
                if (booleanMovimiento(y,SpawnY,-1)) y--
            }
            5->{
                sleep(2000)
                println("sleep")
            }
            else -> println("wtf")
        }
        sleep(200)
    }
}