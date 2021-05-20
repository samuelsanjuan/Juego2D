import javax.swing.ImageIcon

class ColeccionDeGraficos {

    val tiles =ArrayList<ImageIcon>()
    val enemigos=ArrayList<ImageIcon>()

    init {
        enemigos.add(ImageIcon("src/main/resources/Enemy.png"))
        tiles.add(ImageIcon("src/main/resources/Fondo.png"))
        tiles.add(ImageIcon("src/main/resources/Fondo.png"))
        tiles.add(ImageIcon("src/main/resources/Fondo.png"))
        tiles.add(ImageIcon("src/main/resources/Fondo.png"))
    }

}