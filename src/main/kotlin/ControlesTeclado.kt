import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class ControlesTeclado :KeyListener{

    val NUMERO_TECLAS=120
    val teclas = arrayOfNulls<Boolean>(NUMERO_TECLAS)

    var arriba=teclas[KeyEvent.VK_W]
    var abajo=teclas[KeyEvent.VK_A]
    var izquierda=teclas[KeyEvent.VK_D]
    var derecha=teclas[KeyEvent.VK_S]
    var menu=teclas[KeyEvent.VK_ESCAPE]
    var ataque=teclas[KeyEvent.VK_SPACE]
    var interactuar=teclas[KeyEvent.VK_F]
    var inventraio=teclas[KeyEvent.VK_E]
    var mapa=teclas[KeyEvent.VK_M]

    fun actualizar(){
        arriba = teclas[KeyEvent.VK_W]
        izquierda=teclas[KeyEvent.VK_A]
        derecha=teclas[KeyEvent.VK_D]
        abajo=teclas[KeyEvent.VK_S]
        menu=teclas[KeyEvent.VK_ESCAPE]
        ataque=teclas[KeyEvent.VK_SPACE]
        interactuar=teclas[KeyEvent.VK_F]
        inventraio=teclas[KeyEvent.VK_E]
        mapa=teclas[KeyEvent.VK_M]
    }

    override fun keyTyped(e: KeyEvent?) {

    }

    override fun keyPressed(e: KeyEvent?) {
        if (e != null) {
            teclas[e.keyCode]=true
        }
    }

    override fun keyReleased(e: KeyEvent?) {

    }


}