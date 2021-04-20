import java.util.*

var jugando:Boolean=false
val objetos= arrayListOf<Objetos>(
    Enemigo(5,5,4,10,1),
    Enemigo(6,8,5,10,1,),
    Obstaculo(10,10),
    Obstaculo(10,9))

val mapa=Mapa(objetos)

fun main(args: Array<String>) {

    menu()

}

fun menu(){

    jugando=false

    val opcionSeleccionada:String=opcionMenu()
    
    when(opcionSeleccionada){
        
        "jugar"-> jugar()
        "opciones"-> opciones()
        "salir"->guardarSalir()
        else->{
            println("ninguna opcion seleccionada")
        }

    }
}


fun guardarSalir(){
    guardar()
    salir()
}


fun guardar(){

}


fun salir(){

}


fun opcionMenu():String{
    val scan = Scanner(System.`in`)

    val n = scan.nextLine()
    return n
}


fun opciones(){
    abrirAjustes()
}


fun abrirAjustes(){
    val ajuste:String
    ajuste="resolucion"
    when(ajuste){

        "resolucion"->ajustesResolucion()
        "audio"->ajustesAudio()
        "controles"->ajustesControles()
        "back"->menu()
    }
}


fun ajustesAudio(){
    println("ajustando audio")
}


fun ajustesControles(){
    println("ajustando controles")
}


fun ajustesResolucion(){
    println("ajustando resolucion")
}


fun jugar(){

    jugando=true

    cargarNivel(1)

}


fun cargarNivel(nivel: Int) {

    cargarTiles(nivel)
    cargarObejtos(nivel)

}

fun cargarTiles(nivel: Int){
    println("cargando Tiles")
}

fun cargarObejtos(nivel: Int){

    cargarObstaculos(nivel)
    cargarPickeables(nivel)
    cargarNPCS(nivel)
    cargarEnemigos(nivel)
    cargarJugador(nivel)

}

fun cargarEnemigos(nivel: Int){
    println("cargando Enemigos")
    mapa.moverEnemigos()
}
fun cargarNPCS(nivel: Int){
    println("cargando npcs")
}
fun cargarPickeables(nivel: Int){
    println("cargando pickeables")
}
fun cargarJugador(nivel: Int){
    println("cargando jugador")
}
fun cargarObstaculos(nivel: Int){
    println("cargando obstaculos")
}

