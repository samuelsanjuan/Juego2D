import javax.swing.JFrame

class Ventana (){

    val ventana=JFrame("juego")

    fun inicializarVentana(width:Int,heigh:Int): JFrame {
        ventana.setSize(width,heigh)
        ventana.defaultCloseOperation= JFrame.EXIT_ON_CLOSE
        ventana.isVisible=true
        ventana.addKeyListener(ControlesTeclado)

        return ventana


    }
    fun changeResoulution(width: Int,heigh: Int){
        ventana.setSize(width,heigh)
    }
}