import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.swing.ImageIcon


object Graficos {

    fun combinar2Imagenes(xObj :Int , yObj:Int, icon1 : ImageIcon, icon2:ImageIcon):ImageIcon{

        val imagen1:BufferedImage= iconToBufferedImage(icon1)
        val imagen2:BufferedImage= iconToBufferedImage(icon2)

        for (x in 0 until imagen2.width) {
            for (y in 0 until imagen2.height){

                setPixel(x+xObj, y+yObj, getPixel(x,y,imagen2), imagen1)
            }
        }
        return ImageIcon(imagen1)
    }

    fun setPixel(x: Int, y: Int, c: Color, imagen: BufferedImage) = imagen.setRGB(x, y, c.rgb)

    fun getPixel(x: Int, y: Int,imagen: BufferedImage) = Color(imagen.getRGB(x, y))

    fun iconToBufferedImage(icon : ImageIcon): BufferedImage {

        val bi = BufferedImage(icon.iconWidth,icon.iconHeight, BufferedImage.TYPE_INT_RGB)
        val g: Graphics = bi.createGraphics()

        icon.paintIcon(null, g, 0, 0)
        g.dispose()

        return bi
    }

    fun clearBufferedImage(icono:ImageIcon):ImageIcon{
        val bufferedImage = iconToBufferedImage(icono)
        val g: Graphics2D = bufferedImage.createGraphics()
        g.background = Color(0, 0, 0, 0)
        g.clearRect(
            0, 0, bufferedImage.getWidth(),
            bufferedImage.getHeight()
        )
        g.dispose()
        return ImageIcon(bufferedImage)
    }
}

