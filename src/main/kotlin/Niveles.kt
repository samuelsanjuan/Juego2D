class Niveles(){

    val objetos= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1),
        Enemigo(6,8,5,10,1),
        Obstaculo(0,0),
        Obstaculo(0,1),
        Obstaculo(0,2),
        Obstaculo(1,0),
        Obstaculo(1,1),
        Obstaculo(2,0))

    fun pruebaEnemigo(){

        val mapa=Mapa(objetos)

    }

}
