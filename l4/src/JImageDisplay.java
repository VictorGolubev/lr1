import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

/**
 * This class allows us to display our fractals. 
 * It derives from javax.swing.JComponent.
 */
class JImageDisplay extends JComponent
{
    // управляет изображением, содержимое которого можно записать.
    private BufferedImage displayImage;

    //должен принимать целочисленные значения ширины и высоты,
    //и инициализировать объект BufferedImage новым
    //изображением с этой шириной и высотой
    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension); // <-- super значит что вызывается метод из класса-родителя,
        // от которого унаследован этот класс (JComponent метод setPreferredSize)

    }


    //Пользовательские компоненты Swing должны предоставлять свой
    //собственный код для отрисовки, переопределяя защищенный метод JComponent
    //paintComponent (Graphics g). Так как наш компонент просто выводит на экран
    //данные изображения, реализация будет проста!
    // Нужно всегда вызывать метод суперкласса paintComponent (g) так, чтобы объекты
    //отображались правильно, а далее код из методы
    //null для ImageObserver, поскольку данная функциональность не требуется.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, displayImage.getWidth(),
                displayImage.getHeight(), null);
    }

    //Все пиксели задаются черным цветом
    public void clearImage() {
        displayImage.setRGB(0, 0, getWidth(), getHeight(), new int[getWidth() * getHeight()], 0, 1);
    }

    /**
     * Sets a pixel to a specific color.
     */
    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }
}