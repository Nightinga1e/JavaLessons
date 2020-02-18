import java.util.Scanner;

class Calc{
	public static final void main(String[] args){
		System.out.println("Enter a");
    Integer a,b,flag;
    Scanner in = new Scanner(System.in);
    a = in.nextInt();
    System.out.println("Enter b");
    b = in.nextInt();
//    System.out.printf("a= %d, b= %d \n", a, b);
//    System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
    System.out.println(" 1: + \n 2: -\n 3: *\n 4: /\n");
    flag = in.nextInt();
    switch(flag){
      case 1:
              System.out.println(a+b);
              break;
      case 2:
              System.out.println(a-b);
              break;
      case 3:
              System.out.println(a*b);
              break;
      case 4:
              Double da,db;
              da = (double)a;
              db = (double)b;
              System.out.println(da/db);
              break;
      default:
              System.out.println("Wrong command");
              break;
    }
    in.close();
	}
}
