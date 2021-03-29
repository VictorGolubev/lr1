public class Point3d {
    //Свойства класса (координаты)
    private double x;
    private double y;
    private double z;

    //Конструкторы

    //создание нового объекта Point3d с тремя значениями с плавающей    точкой (double);
    //Создание класса с определнием 3х параметров
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //создание нового объекта Point3d со значениями (0.0, 0.0, 0.0) по умолчанию
    //Создание класса без входящих параметро (по умолчанию) => задаются координаты 0 0 0
    public Point3d() {
        this(0,0,0);
    }




    //возможность получения и изменения всех трех значений по отдельности;

    //считать значение координаты Х
    public double getX() {
        return x;
    }

    //установить значение координаты Х
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }





    //метод для сравнения значений двух объектов Point3d

    //сравнивает точку которая передается как параметр с текущим обьектом класса (из которого вызывается)
    public boolean equals(Point3d point) {
        //return point.getX() == this.x && point.getY() == this.y && point.getZ() == this.z;
        if(point.getX() == this.x && point.getY() == this.y && point.getZ() == this.z)
            return true;
        else
            return false;
    }


    //находит раасстояние до точки которая передается как параметр с текущим обьектом класса (из которого вызывается)
    private double distanceTo(Point3d point) {
        double distance = Math.sqrt(Math.pow((point.getX() - this.x),2)+ Math.pow((point.getY() - this.y),2)+ Math.pow((point.getZ() - this.z),2));
        return Math.floor(distance*1000)/1000; // 4.333333 433.333 433 4.33
    }


    //Посчитать площадь треугольника по точкам
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3) {
        //Стороны треугольника
        double a = point1.distanceTo(point2);
        double b = point1.distanceTo(point3);
        double c = point2.distanceTo(point3);
        //Полупериметр
        double p = (a+b+c)/2;
        //Площадь
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return s;
    }
}
