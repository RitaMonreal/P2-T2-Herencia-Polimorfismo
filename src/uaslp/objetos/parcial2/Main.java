package uaslp.objetos.parcial2;

import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Modifier;

//Con ctrl + r puedes remplazar fácil todo
abstract class Figure{//a nivel de clase abstract no puede ser instanciada, puede o no tener métodos abstractos

   private static int figuresCreated; //Está es una variable la quiero para que cada cree una figura aumente, como si fuera un contador (solo una copia)
   private final String name;//Cada objeto tendrá su nombre porque no es una variable

   protected Figure(String name){
        this.name = name;

        figuresCreated++;
   }

   public abstract float getArea();//Es abstracto el método y no lleva cuerpo, si llevrá cuerpo es porque sé que hacer con él
   public abstract float getPerimeter() ;

   public final String getName(){// el final es porwque no se puede repetir
        return name;
   }

   public static int getFiguresCreated(){
        return figuresCreated;
   }

}

class Circle extends Figure{
    private float radio;

    public Circle(){//Constructor, solamente se puede llamar como la primera instrucción en el constructor de la clase hija

        super("Circulo");
    }

    public Circle(float radio){//Hay sobrecarga ya que hay dos métodos con el mismo nombre, pero con diferentes parámetros
        super("Circulo");
        this.radio = radio;
    }

   public float getArea(){
       return (float)Math.PI * radio * radio;//Estás como "casteando"
   }

   public float getPerimeter(){
       return (float)(Math.PI * radio * 2);//Vuelves a hacer el casteo
   }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}

class Rectangle extends Figure{
    private float base;
    private float height;
    //Super solo se puede llamar como la primera instrucción en la clase hija, todo lo que está antes se considera como error
    public Rectangle(){//Constructor, solamente se puede llamar como la primera instrucción en el constructor de la clase hija

        super("Rectángulo");//Super hace referencia al constructor de la clase padre
    }

    public Rectangle(float base, float height){
        super("Rectángulo");//Super hace referencia al constructor de la clase padre
        this.base = base;
        this.height = height;
    }
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getArea(){
        return base * height;
    }

    public float getPerimeter(){
        return 2 * base + 2 * height;
    }
}

class Polygon extends Figure{

    private float apotema;
    private int sidesCount;
    private float sideLenght;
    public Polygon(float apotema, int sidesCount, float sideLenght){//Constructor, solamente se puede llamar como la primera instrucción en el constructor de la clase hija

        super("Polígno");
        this.apotema = apotema;
        this.sideLenght = sideLenght;
        this.sidesCount = sidesCount;
    }
    public float getArea(){
        return getPerimeter() * apotema / 2;
    }

    public float getPerimeter(){
        return sidesCount * sideLenght;
    }
}

public class Main {//Main es statico lo que significa que no pertenece a nadie, los test no están actuando sobre ningun objeto, porque no existen
    public static void main(String[] args){
        List<Figure> figureList = new LinkedList<>();

        figureList.add(new Polygon(4, 5, 6.3f));
        figureList.add(new Polygon(4.5f, 8, 3.9f));
        figureList.add(new Rectangle(4, 5));
        figureList.add(new Rectangle(4.5f, 9.6f));
        figureList.add(new Circle(5.3f));
        figureList.add(new Circle(10.6f));

        for (Figure figure : figureList) {
            System.out.println(figure.getName() + ", Area: " + figure.getArea() + ", Perímetro: " + figure.getPerimeter());
        }

        if(Modifier.isAbstract(Figure.class.getModifiers())){
            System.out.println("Figure es abstracta");
        }
        System.out.println("Se generaron: " + Figure.getFiguresCreated() + " figuras");
    }
}

/*
     //Figure figure = new Figure(); ya que es abstracto no le pertenece anadie
       // circlesTest();
       // rectanglesTest();
        // polygonTest();
        List<Figure> figureList = new LinkedList<>();
        figureList.add(new Polygon(4, 5, 6.3f));
        figureList.add(new Polygon(4.5f, 8, 3.9f));
        figureList.add(new Rectangle(4, 5));
        figureList.add(new Rectangle(4.5f, 9.6f));
        figureList.add(new Rectangle(4, 5));
        figureList.add(new Rectangle(4.5f, 9.6f));
        //POLIMORFISMO
        for(Figure figure: figureList){//Puedo usar getname gracias a su papá
            System.out.println(figure.getName() + ", Area: " + figure.getArea() + ", Perímetro: " + figure.getPerimeter());
        }

    }

    private static void polygonTest() {
        List<Polygon> polygonList = new LinkedList<>();
        polygonList.add(new Polygon(4, 5, 6.3f));
        polygonList.add(new Polygon(4.5f, 8, 3.9f));

        for(Polygon polygon: polygonList){//Puedo usar getname gracias a su papá
            System.out.println(polygon.getName() + ", Area: " + polygon.getArea() + ", Perímetro: " + polygon.getPerimeter());
        }
    }

    private static void rectanglesTest() {
        List<Rectangle> rectangleList = new LinkedList<>();
        rectangleList.add(new Rectangle(4, 5));
        rectangleList.add(new Rectangle(4.5f, 9.6f));

        for(Rectangle rectangle: rectangleList){//Puedo usar getname gracias a su papá
            System.out.println(rectangle.getName() + ", Area: " + rectangle.getArea() + ", Perímetro: " + rectangle.getPerimeter());
        }
    }

    private static void circlesTest() {
        List<Circle> circleList = new LinkedList<>();
        Circle circle1 = new Circle();//Dentro del constructor de cicle se llama mandar al constructor de figura (el papá de circle)
        Circle circle2 = new Circle(10.6f);
        circle1.setRadio(5.3f);//Para que sea flotante le agregas la f, sino la tiene se considera como double

        circleList.add(circle1);
        circleList.add(circle2);

        for(Circle circle: circleList){//Puedo usar getname gracias a su papá
            System.out.println(circle.getName() + ", Area: " + circle.getArea() + ", Perímetro: " + circle.getPerimeter());
        }
 */