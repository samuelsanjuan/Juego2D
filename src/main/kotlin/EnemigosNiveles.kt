class EnemigosNiveles(){

    val enemigoDefault1=Enemigo(50,50,3,10,1,1,1,10,5,"Enemigo1")
    val enemigoDefault2=Enemigo(90,90,3,10,1,1,1,10,5,"Enemigo2")

    val NivelesEnemigos=ArrayList<ArrayList<Enemigo>>()

    val Nivel1= arrayListOf<Enemigo>()
    val Nivel2= arrayListOf(enemigoDefault1,enemigoDefault2)
    val Nivel3= arrayListOf(enemigoDefault1,enemigoDefault2)
    val Nivel4= arrayListOf(enemigoDefault1,enemigoDefault2)
    val Nivel5= arrayListOf(enemigoDefault1,enemigoDefault2)

    init {
        NivelesEnemigos.add(Nivel1)
        NivelesEnemigos.add(Nivel2)
        NivelesEnemigos.add(Nivel3)
        NivelesEnemigos.add(Nivel4)
        NivelesEnemigos.add(Nivel5)
    }
}
