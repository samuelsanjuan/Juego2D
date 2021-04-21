import java.io.File
import java.util.*
import kotlin.collections.ArrayList

var jugando:Boolean=false
var objetos=ArrayList<Objetos>()
val niveles=Niveles()
var nivelActual= File("src/main/resources/Partida").inputStream().bufferedReader().readLine().toInt()
fun main(args: Array<String>) {

    print(nivelActual)
    cargar()
    menu()

}

fun cargar(){
    getNivel()
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

    getNivel()

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

    cargarNivel(getNivel())

}


fun cargarNivel(nivel: Int) {

    objetos.clear()
    objetos=niveles.Niveles[nivel-1]
    cargarTiles(nivel)
    cargarObejtos(nivel)

}
fun getNivel():Int{
    var nivel=1

    return nivel
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

