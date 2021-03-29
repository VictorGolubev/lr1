import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double tempX;
        double tempY;
        double tempZ;


        System.out.println("Ввод\nПервая точка:");
        System.out.print("X = ");
        tempX = scan.nextDouble();
        System.out.print("Y = ");
        tempY = scan.nextDouble();
        System.out.print("Z = ");
        tempZ = scan.nextDouble();

        Point3d point1 = new Point3d(tempX,tempY,tempZ);

        System.out.println("\nВторая точка:");
        System.out.print("X = ");
        tempX = scan.nextDouble();
        System.out.print("Y = ");
        tempY = scan.nextDouble();
        System.out.print("Z = ");
        tempZ = scan.nextDouble();

        Point3d point2 = new Point3d(tempX,tempY,tempZ);

        System.out.println("\nТретья точка:");
        System.out.print("X = ");
        tempX = scan.nextDouble();
        System.out.print("Y = ");
        tempY = scan.nextDouble();
        System.out.print("Z = ");
        tempZ = scan.nextDouble();

        Point3d point3 = new Point3d(tempX,tempY,tempZ);

        if(point1.equals(point2) || point1.equals(point3) || point2.equals(point3)) {
            System.out.println("Координаты точек совпадают!");
        }
        else {
            System.out.println("Координаты точек не совпадают!");
            System.out.println("Площадь треугольника образованного точками: " + Point3d.computeArea(point1,point2,point3));
        }


        scan.close();




    }
}