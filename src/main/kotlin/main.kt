import java.io.File
import java.util.*

var jugando:Boolean=false
var enEjecucion=false
var objetos=ArrayList<Objetos>()
val niveles=Niveles()
val ArchivoNivel= File("src/main/resources/Partida.txt")
var nivelActual = ArchivoNivel.inputStream().bufferedReader().readLine()
val jugador=Jugador(1,1)
val ventana:Ventana= Ventana()
val longitudNivel=100


fun main(args: Array<String>) {
    enEjecucion=true
    ventana.inicializarVentana(720,480)

    print(nivelActual)
    if(enEjecucion){
        menu()
    }
}

fun menu(){

    jugando=false

    ventana.menuVisible()

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
    enEjecucion=false
}


fun opciones(){
    abrirAjustes()
}

fun abrirAjustes(){
    var ajuste:String="resolucion"
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

    ventana.menuInvisible()

    jugando= true

    while (jugando==true) {
        cargarNivel()
    }
    menu()
}


fun cargarNivel() {

    if (jugador.x in 0..longitudNivel) {

        objetos.clear()
        objetos = niveles.Niveles[nivelActual.toInt() - 1]
        for (objeto in objetos)
            println(objeto.toString())
        cargarTiles()

        realentizar()
    }
    else if (jugador.x>longitudNivel){
        nivelActual="${nivelActual.toInt()+1}"
        jugador.x=0
    }
    else if (jugador.x<0){
        nivelActual="${nivelActual.toInt()-1}"
        jugador.x=longitudNivel
    }
}

fun cargarTiles(){

}

fun cargarObjetos(){

    cargarObstaculos()
    cargarPickeables()
    cargarNPCS()
    cargarEnemigos()
    cargarJugador()

}

fun cargarEnemigos(){
}

fun cargarNPCS(){
}

fun cargarPickeables(){
}

fun cargarJugador(){

    jugador.actualizar()
    if (ControlesTeclado.menu==true){
        jugando=false
    }
}

fun cargarObstaculos(){
}


fun realentizar() {

    val nsPorSegundo = 1000000000
    val apsObjetivo: Byte = 60
    val nsPorActualizacion = (nsPorSegundo / apsObjetivo).toDouble()

    var referenciaActualizacion = System.nanoTime()
    var referenciaContador = System.nanoTime()

    var tiempoTranscurrido: Double
    var delta = 0.0

    while (jugando&&jugador.x in 0..longitudNivel) {

        val inicioBucle = System.nanoTime()

        tiempoTranscurrido = (inicioBucle - referenciaActualizacion).toDouble()
        referenciaActualizacion = inicioBucle

        delta += tiempoTranscurrido / nsPorActualizacion

        while (delta >= 1) {
            cargarObjetos()
            delta--
        }

        if (System.nanoTime() - referenciaContador > nsPorSegundo) {
            referenciaContador = System.nanoTime()
        }
    }
}
