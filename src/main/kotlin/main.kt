import com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener
import java.io.File
import java.util.*

var jugando:Boolean=false
var objetos=ArrayList<Objetos>()
val niveles=Niveles()
val ArchivoNivel= File("src/main/resources/Partida.txt")
var nivelActual= ArchivoNivel
    .inputStream()
    .bufferedReader()
    .readLine()
val jugador=Jugador(1,1)
val ventana:Ventana= Ventana()


fun main(args: Array<String>) {

    ventana.inicializarVentana(1680,1020)

    print(nivelActual)
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
    ArchivoNivel.delete()
    ArchivoNivel.createNewFile()
    ArchivoNivel.writeText(nivelActual)
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
    ventana.changeResoulution(1000,1000)
}


fun jugar(){

    jugando=true

    cargarNivel()

}


fun cargarNivel() {

    objetos.clear()
    objetos=niveles.Niveles[nivelActual.toInt()-1]
    for (objeto in objetos)
        println(objeto.toString())
    cargarTiles()
    cargarObejtos()

}

fun cargarTiles(){
    println("cargando Tiles")
}

fun cargarObejtos(){

    cargarObstaculos()
    cargarPickeables()
    cargarNPCS()
    cargarEnemigos()
    cargarJugador()

}

fun cargarEnemigos(){
    println("cargando Enemigos")
}
fun cargarNPCS(){
    println("cargando npcs")
}
fun cargarPickeables(){
    println("cargando pickeables")
}
fun cargarJugador(){
    println("cargando jugador")
}
fun cargarObstaculos(){
    println("cargando obstaculos")
}

