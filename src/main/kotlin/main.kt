import java.awt.Button
import java.awt.GridLayout
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.File
import java.lang.Thread.sleep
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import kotlin.collections.ArrayList

//booleans de control del programa
var enEjecucion=true
var jugando=false

//fichero que guarda el nivel en el que te quedaste
val ArchivoNivel= File("src/main/resources/Partida.txt")
var nivelActual = ArchivoNivel.inputStream().bufferedReader().readLine().toInt()

//logitud del mapa
val longitudNivel=250

//opciones para los menus
var menuOpcion:String=""
var ajustesOpcion:String=""

//coleccion de graficos
val graficos=ColeccionDeGraficos()
var iconoPrincipal=ImageIcon()

val jugador=Jugador(12,50)
var objetos=ArrayList<Objetos>()
var obstaculos=ArrayList<Obstaculo>()
var enemigos=ArrayList<Enemigo>()

//objetos para los menus
val ventana = JFrame("juego")
var graficosJuego=JLabel()
val menu = JPanel()
val botonJugar = Button("Jugar")
val botonOpciones = Button("Opciones")
val botonSalir = Button("Salir")

fun main() {

    //inicializacion de la ventana de juego
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    val width = screenSize.width
    val height = screenSize.height
    ventana.setSize(width, height)
    ventana.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventana.addKeyListener(ControlesTeclado)
    graficosJuego.addKeyListener(ControlesTeclado)

    menu.layout = GridLayout(3, 1)
    menu.add(botonJugar)
    menu.add(botonOpciones)
    menu.add(botonSalir)
    ventana.add(menu)

    ventana.isVisible=true

    botonJugar.addActionListener{
        menuOpcion="jugar"
    }

    botonOpciones.addActionListener{
        menuOpcion="opciones"
    }
    botonSalir.addActionListener{
        menuOpcion="salir"
    }

    //loop principal
    while(enEjecucion){
        menu()
    }
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
                guardar()
                salir()
            }

            else -> {
                print("")
            }
        }

    }while (menuOpcion != "jugar" || menuOpcion != "opciones" || menuOpcion != "salir")
}

fun guardar(){
    ArchivoNivel.delete()
    ArchivoNivel.createNewFile()
    ArchivoNivel.writeText(nivelActual.toString())
}

fun salir(){
    enEjecucion=false
    System.exit(0)
}


fun abrirAjustes(){

    do {
        when (ajustesOpcion){
            "audio"->ajustesAudio()
            "controles"->ajustesControles()
            "resolucion"->ajustesResolucion(1420,840)
        }
    }while (ajustesOpcion!="audio"||ajustesOpcion!="controles"||ajustesOpcion!="resolucion")

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

/////////////////////////////////////// METODO JUGAR /////////////////////////////////////////////////////////////////
fun jugar(){

    while (jugando==true) {

        cargarTiles()
        cargarNivel()
    }
    menu()
}

fun mostrar(){

    ventana.remove(graficosJuego)
    graficosJuego= JLabel(iconoPrincipal)
    ventana.add(graficosJuego)
    ventana.isVisible=true

}

fun cargarNivel() {

    while (jugador.x in 0..longitudNivel&&jugando==true){

        cargarObjetos()
        mostrar()
        sleep(15)
        iconoPrincipal=graficos.tiles[nivelActual]

    }
    if (jugador.x>longitudNivel){
        nivelActual++
        actualizarNivel()
        jugador.x=0
    }
    else if (jugador.x<0){
        nivelActual--
        actualizarNivel()
        jugador.x=longitudNivel
    }
}

fun actualizarNivel(){

    val EnemigosDel=EnemigosNiveles().NivelesEnemigos
    val ObstaculosDel=ObstaculosNiveles().NivelesObstaculos

    enemigos.clear()
    obstaculos.clear()
    enemigos=EnemigosDel[nivelActual]
    obstaculos=ObstaculosDel[nivelActual]
}

fun cargarTiles(){

    iconoPrincipal=graficos.tiles[nivelActual]
    mostrar()

}

fun cargarObjetos(){

    cargarObstaculos()
    cargarPickeables()
    cargarNPCS()
    cargarEnemigos()
    cargarJugador()

}

fun cargarEnemigos(){
    for (enemigo in enemigos){
        enemigo.moverse(jugador)
       iconoPrincipal = Graficos.combinar2Imagenes(enemigo.x,enemigo.y, iconoPrincipal,enemigo.textura)
    }
}

fun cargarNPCS(){
}

fun cargarPickeables(){
}

fun cargarJugador(){


    if (jugador.vida>0){
        iconoPrincipal=Graficos.combinar2Imagenes(jugador.x,jugador.y,iconoPrincipal,jugador.textura)
    }
    else{
        iconoPrincipal=Graficos.combinar2Imagenes(jugador.x,jugador.y,iconoPrincipal,jugador.textura)
    }
    ControlesTeclado.actualizar()
    jugador.actualizar()
    if (ControlesTeclado.menu==true){
        jugando=false
        menuOpcion=""
    }
}

fun cargarObstaculos(){

    for (obstaculo in obstaculos){
    //    iconoPrincipal = Graficos.combinar2Imagenes(obstaculo.x,obstaculo.y, iconoPrincipal,obstaculo.textura)
    }
}