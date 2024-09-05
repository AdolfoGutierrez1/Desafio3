import java.util.*;
 
public class Desafio3 {
    //derivada de orden n
    public static double DeriN(int n, double xO){
        double fx;
        fx=Math.pow(-1, n)*Math.exp(-xO);
        return fx;
    }
    //factorial n!
    public static double factorial(int n){
        double a=1;
        while(n>0){
            a=a*(n);
            n=n-1;
        }
        return a;
    }
    public static double Ec (double V,int n,double h){
        double X;
        X=V*Math.pow(h, n)/factorial(n);
        return X;
    }
    public static void main(String[] args) {
        //si quitamos el if que esta en el for podras iterar n veces 
        //cuanto mas iteres mas proximo es el valor hacia f(1)=exp(-1)
        System.out.println("hasta que orden desea iterar? :");
        Scanner lee=new Scanner(System.in);
        int n=lee.nextInt();
        double x0,x1;
        x0=0.2;
        x1=1;
        double h=x1-x0;
        //aplicaremos el orden n de iteraciones
        double f0,f1;// seran nuestras funciones fx con valores de x0 y x1
        f0=Math.exp(-x0);
        //f1=Math.exp(-x1);
        //este cera la funcion de orden cero
        System.out.println("orden cero :"+f0);
        //aqui se realizara el orden de iteracion n
        double var1=0,error;
        for (int i = 1; i <= n; i++) {
            var1=DeriN(i,x0);
            //System.out.println("derivada "+i+": "+var1);
            f1=f0+Ec(var1,i,h);
            error=Math.abs(Ec(var1,i,h));
            System.out.println("error "+i+": "+error);
            System.out.println("orden "+i+": "+f1);
            f0=f1;
            if(0.0005>error)//se detiene la iteracion de orden n debido al error
                break;
        
        }
        System.out.println("valor al que nos queriamos aproximar "+Math.exp(-x1));
    }   
}
