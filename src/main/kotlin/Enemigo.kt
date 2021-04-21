class Enemigo (x:Int, y:Int, movimiento:Int, agro:Int, rango:Int,hitboxX:Int,hitboxY:Int):Objetos(x,y,"Enemigo",true,hitboxX,hitboxY){

    val SpawnX=x
    val SpawnY=y

    val solido=true

    val radioMovimiento=movimiento
    val radioAgro=agro
    var agroActivado=false
    val rangoAtaque=rango

    fun moverseEnemigo(){

    }

    fun atacar(){


    }
}