import java.util.ArrayList;

class Mapa (objetos: ArrayList<Objetos>){

    val objetos=objetos

    val ancho = 10
    val alto = 10

    fun moverEnemigos(){

        for (i in 1..10) {
            for (objeto in objetos){
                if (objeto.tipo=="Enemigo"){

                    val enemigo=Enemigo(objeto.x,objeto.y,10,20,1)
                    enemigo.moverse()
                    objeto.x=enemigo.x
                    objeto.y=enemigo.y

                }
            }

            println()
            mapa.verTablero()
            Thread.sleep(200)

        }
    }

    fun verTablero(){

        for (x in 0..alto) {
            println()
            for (y in 0..ancho){
                for (objeto in objetos){

                    if (objeto.x== x && objeto.y==y) {

                        when (objeto.tipo) {
                            "Enemigo"-> print("X")
                            "Obstaculo"-> print("0")
                        }
                    }else print("_")
                }
            }
        }
    }
}
