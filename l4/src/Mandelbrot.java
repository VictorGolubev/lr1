import java.awt.geom.Rectangle2D;



public class Mandelbrot extends FractalGenerator
{
    //Максимальное количество повторов
    public static final int MAX_ITERATIONS = 2000;

    //определеят область комплексной плоскости для конкретного фрактала
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    //Реализация итеративного алгоритма для фрактала Мандельброта
    public int numIterations(double x, double y)
    {
        int counter = 0;
        //Переменные для комплексных чисел
        double zreal = 0;
        double zimaginary = 0;

        while (counter < MAX_ITERATIONS &&
                zreal * zreal + zimaginary * zimaginary < 4)
        {
            zreal = zreal * zreal - zimaginary * zimaginary + x;;
            zimaginary = 2 * zreal * zimaginary + y;
            counter ++;
        }

        return counter == MAX_ITERATIONS ? -1 : counter; //Если счетчик достиг 2000, то вернет -1
    }

}