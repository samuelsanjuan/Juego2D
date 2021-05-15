import java.awt.Button
import java.awt.GridLayout
import java.io.File
import java.lang.Thread.sleep
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

var enEjecucion=false
val niveles=Niveles()
var jugando:Boolean=false
var objetos=ArrayList<Objetos>()
val ArchivoNivel= File("src/main/resources/Partida.txt")
var nivelActual = ArchivoNivel.inputStream().bufferedReader().readLine().toInt()
val jugador=Jugador(1,1)
val longitudNivel=100
var menuOpcion:String="jugar"

val ventana = JFrame("juego")
val menu = JPanel()
val botonJugar = Button("Jugar")
val botonOpciones = Button("Opciones")
val botonSalir = Button("Salir")

fun main(args: Array<String>) {

        ventana.setSize(720, 480)
        ventana.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        ventana.addKeyListener(ControlesTeclado)

        menu.layout = GridLayout(3, 1)
        menu.add(botonJugar)
        menu.add(botonOpciones)
        menu.add(botonSalir)
        ventana.add(menu)
    ventana.isVisible=true

        botonJugar.addActionListener() {
            menuOpcion="jugar"
        }

        botonOpciones.addActionListener() {
            menuOpcion="opciones"
        }

        botonSalir.addActionListener() {
            menuOpcion="salir"
        }


    enEjecucion=true
    print("$nivelActual ")
    println(menuOpcion)

    while(enEjecucion){
        menu()
    }
    println("adios")
}

fun menu(){

    jugando=false

    menu.isVisible = true

    do{
        when (menuOpcion) {

            "jugar" -> {
                jugando=true
                menu.isVisible=false
                jugar()
            }

            "opciones" -> {
                abrirAjustes()
            }

            "salir" -> {
                guardarSalir()
            }

            else -> {
                println("error")
            }
        }

    }while (menuOpcion != "jugar" || menuOpcion != "opciones" || menuOpcion != "salir")
}


fun guardarSalir(){
    guardar()
    salir()
}

fun guardar(){
    ArchivoNivel.delete()
    ArchivoNivel.createNewFile()
    ArchivoNivel.writeText(nivelActual.toString())
}

fun salir(){
    enEjecucion=false
}


fun abrirAjustes(){

}

fun ajustesAudio(){
    println("ajustando audio")
}

fun ajustesControles(){
    println("ajustando controles")
}

fun ajustesResolucion(width:Int,height:Int){
    println("ajustando resolucion")

    ventana.setSize(width,height)
}


fun jugar(){

    while (jugando==true) {
        cargarNivel(nivelActual)
    }

    menu()
}


fun cargarNivel(nivel:Int) {

    cargarTiles()

    if (jugador.x in 0..longitudNivel) {

        objetos.clear()
        objetos = niveles.Niveles[nivelActual - 1]
        for (objeto in objetos)
            println(objeto.toString())

        sleep(15)
        cargarObjetos()

    }
    else if (jugador.x>longitudNivel){
        nivelActual=nivelActual+1
        jugador.x=0
    }
    else if (jugador.x<0){
        nivelActual=nivelActual-1
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

    ControlesTeclado.actualizar()
    jugador.actualizar()
    if (ControlesTeclado.menu==true){
        jugando=false
        menuOpcion=""
    }
}

fun cargarObstaculos(){
}
