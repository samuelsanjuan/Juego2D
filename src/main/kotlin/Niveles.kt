class Niveles(){

    val Niveles=ArrayList<ArrayList<Objetos>>()

    val objetosNivel1= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1,1,1),
        Enemigo(6,8,5,10,1,1,1),
        Obstaculo(0,0,10,10),
        Obstaculo(10,10,-10,-10)
    )
    val objetosNivel2= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1,1,1),
        Enemigo(6,8,5,10,1,1,1),
        Obstaculo(0,0,10,10),
        Obstaculo(10,10,-10,-10)
    )
    val objetosNivel3= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1,1,1),
        Enemigo(6,8,5,10,1,1,1),
        Obstaculo(0,0,10,10),
        Obstaculo(10,10,-10,-10)
    )
    val objetosNivel4= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1,1,1),
        Enemigo(6,8,5,10,1,1,1),
        Obstaculo(0,0,10,10),
        Obstaculo(10,10,-10,-10)
    )
    val objetosNivel5= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1,1,1),
        Enemigo(6,8,5,10,1,1,1),
        Obstaculo(0,0,10,10),
        Obstaculo(10,10,-10,-10)
    )
    init {
        Niveles.add(objetosNivel1)
        Niveles.add(objetosNivel2)
        Niveles.add(objetosNivel3)
        Niveles.add(objetosNivel4)
        Niveles.add(objetosNivel5)
    }
}
