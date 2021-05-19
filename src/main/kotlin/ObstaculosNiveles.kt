class ObstaculosNiveles {

    val bordeArriba= Obstaculo(1,1,1,100)
    val bordeAbajo = Obstaculo(1,99,1,100)

    val NivelesObstaculos=ArrayList<ArrayList<Obstaculo>>()

    val Nivel1= arrayListOf<Obstaculo>(bordeAbajo,bordeArriba)
    val Nivel2= arrayListOf<Obstaculo>(bordeAbajo,bordeArriba)
    val Nivel3= arrayListOf<Obstaculo>(bordeAbajo,bordeArriba)
    val Nivel4= arrayListOf<Obstaculo>(bordeAbajo,bordeArriba)
    val Nivel5= arrayListOf<Obstaculo>(bordeAbajo,bordeArriba)

    init {
        NivelesObstaculos.add(Nivel1)
        NivelesObstaculos.add(Nivel2)
        NivelesObstaculos.add(Nivel3)
        NivelesObstaculos.add(Nivel4)
        NivelesObstaculos.add(Nivel5)


    }



}