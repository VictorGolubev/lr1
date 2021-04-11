import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

//Основной класс, который нужно запускать main внизу!!
public class FractalExplorer
{
    //размер экрана
    private int displaySize;

    private JImageDisplay display;

    //ссылка на базовый класс для отображения других видов фракталов в будущем.
    private FractalGenerator fractal;

    //диапазона комплексной плоскости, которая выводится на экран
    private Rectangle2D.Double range;

    //Конструктор
    public FractalExplorer(int size) {
        //Задает размер
        displaySize = size;

        //Инициализация объектов без Swing
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);

    }

    //инициализация графического интерфейса Swing: JFrame
    public void createAndShowGUI()
    {
        display.setLayout(new BorderLayout());
        JFrame myframe = new JFrame("Fractal Explorer");

        //объект отображения изображения в позиции BorderLayout.CENTER
        myframe.add(display, BorderLayout.CENTER);

        //Инициализация кнопки сброса
        JButton resetButton = new JButton("Reset Display");

        //Создание обработчика запроса для кнопки
        Action handler = new ResetHandler();
        resetButton.addActionListener(handler);

        myframe.add(resetButton, BorderLayout.SOUTH);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myframe.pack();
        myframe.setVisible(true);
        myframe.setResizable(false);
    }

    //Класс обработки кнопки Сброса
    private class ResetHandler extends AbstractAction {

        //КОгда обработчик получает событие нажатия на кнопку,
        // тосбрасывает диапазон до начального диапазона, заданного генератором,
        // а затем рисует фрактал.
        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    //Класс обработки события нажатия на кнопку
    private class MouseHandler extends MouseAdapter
    {
        //Когда обработчик получает событие щелчка мыши,
        //он сопоставляет пиксельные координаты щелчка с областью отображаемого фрактала,
        //а затем вызывает метод генератора correnterAndZoomRange () с координатами, по которым щелкнули, и шкалой 0,5.
        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }


    // метод для вывода на экран фрактала
    private void drawFractal()
    {
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                double xCoord = fractal.getCoord(range.x,range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y,range.y + range.height, displaySize, y);
                int iteration = fractal.numIterations(xCoord, yCoord);
                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }
                else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(x, y, rgbColor);
                }

            }
        }
        display.repaint();
    }

    //Основной метод для старта программы
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);//В задании тут 800 должно быть, но у меня в экран не помещалось, можешь поменять
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}