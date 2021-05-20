class EnemigosNiveles(){

    val enemigo0=Enemigo(100,100,3,8000,8000,1,1,500,8000,"EasterEgg",graficos.enemigos[0])
    val enemigoDefault1=Enemigo(50,50,3,10,1,1,1,10,5,"Enemigo1",graficos.enemigos[0])
    val enemigoDefault2=Enemigo(90,90,3,10,1,1,1,10,5,"Enemigo2",graficos.enemigos[0])

    val NivelesEnemigos=ArrayList<ArrayList<Enemigo>>()

    val Nivel0= arrayListOf(enemigo0)
    val Nivel1= arrayListOf<Enemigo>()
    val Nivel2= arrayListOf(enemigoDefault1)
    val Nivel3= arrayListOf(enemigoDefault1,enemigoDefault2)
    val Nivel4= arrayListOf(enemigoDefault1,enemigoDefault2)
    val Nivel5= arrayListOf(enemigoDefault1,enemigoDefault2)

    init {
        NivelesEnemigos.add(Nivel0)
        NivelesEnemigos.add(Nivel1)
        NivelesEnemigos.add(Nivel2)
        NivelesEnemigos.add(Nivel3)
        NivelesEnemigos.add(Nivel4)
        NivelesEnemigos.add(Nivel5)
    }
}
