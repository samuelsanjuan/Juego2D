import java.awt.Button
import java.awt.GridLayout
import javax.swing.JFrame
import javax.swing.JPanel

class Ventana (){

    val ventana=JFrame("juego")
    val menu=JPanel()

    val botonJugar=Button("Jugar")
    val botonOpciones=Button("Opciones")
    val botonSalir=Button("Salir")

    fun inicializarVentana(width:Int,heigh:Int): JFrame {

        ventana.setSize(width,heigh)
        ventana.defaultCloseOperation= JFrame.EXIT_ON_CLOSE
        ventana.isVisible=true
        ventana.addKeyListener(ControlesTeclado)
        menu.layout=GridLayout(3,1)

        menu.add(botonJugar)
        menu.add(botonOpciones)
        menu.add(botonSalir)

        botonJugar.addActionListener(){
            jugar()
        }

        botonOpciones.addActionListener(){
            opciones()
        }

        botonSalir.addActionListener(){
            guardarSalir()
        }


        menu.isVisible=false
        ventana.add(menu)

        return ventana


    }
    fun changeResoulution(width: Int,heigh: Int){
        ventana.setSize(width,heigh)
    }
    fun menuInvisible(){

        menu.isVisible=false
    }

    fun menuVisible(){
        menu.isVisible=true


    }
}