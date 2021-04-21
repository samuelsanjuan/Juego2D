class Niveles(){

    val Niveles=ArrayList<ArrayList<Objetos>>()

    public val objetosNivel1= arrayListOf<Objetos>(
        Enemigo(5,5,4,10,1,1,1),
        Enemigo(6,8,5,10,1,1,1),
        Obstaculo(0,0,10,10),
        Obstaculo(10,10,-10,-10)
    )

    init {
        Niveles.add(objetosNivel1)
    }
}
