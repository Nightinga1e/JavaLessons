import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

abstract class User{
  private String name;
	private String email; //доступны только из этого класса
  public User(String name){
  	this.name = name;
  }
	public User(String name, String email){  // доступен отовсюду
		this(name);
		this.email = email;
	}
	final protected String getName(){ //доступен только из дочерних
		return this.name;
	}
  final protected String getEmail(){
    return this.email;
  }
	//abstract String  toString();
}

class Developer extends User{
    private String team;
    public Developer (String name, String email, String team){
      super(name,email);
      this.team = team;
    }
    protected String getTeam(){
      return this.team;
    }
}

class Manager extends User{
  private String dep;
  public Manager (String name, String email, String dep){
    super(name,email);
    this.dep = dep;
  }
  protected String getDep(){
    return this.dep;
  }
}

interface CSV{ //хранит 2 метода
  void toCSV(String str) throws IOException; //возвращающий строку, которую запишем в файл
  String fromCSV(Integer number) throws IOException; // примет строчку из файла
}

class DeveloperRW implements CSV{
    private String outputString;
    private Integer counter;
    public void toCSV(String str) throws IOException{
      java.io.FileWriter fw = new java.io.FileWriter("developers.csv", true);
      fw.write(str);
      fw.close();
    }
    public String fromCSV(Integer number) throws IOException{
      counter = 0;
      FileReader fr = new FileReader("developers.csv");
      Scanner out = new Scanner(fr);
      while(out.hasNextLine()){
        if(counter.equals(number)){
          outputString = out.nextLine();
          break;
        }else{
          out.nextLine();
        }
        counter++;
      }
      fr.close();
      return outputString;
    }
}

class ManagerRW implements CSV{
    private String outputString;
    private Integer counter;
    public void toCSV(String str) throws IOException{
      java.io.FileWriter fw = new java.io.FileWriter("managers.csv", true);
      fw.write(str);
      fw.close();
    }
    public String fromCSV(Integer number) throws IOException{
      counter = 0;
      FileReader fr = new FileReader("managers.csv");
      Scanner out = new Scanner(fr);
      while(out.hasNextLine()){
        if(counter.equals(number)){
          outputString = out.nextLine();
          break;
        }else{
          out.nextLine();
        }
        counter++;
      }
      fr.close();
      return outputString;
    }
}

public class FileWriter{
  public static void createDB() throws IOException{
    String[] fName = {"Ivan","Kate","Robert","Dave","Wade","Riley","Gilbert","Dan","Brian","Liam"};
    String[] fEmail = {"A@A","B@B","C@C","D@D","E@E","F@F","G@G","H@H","I@I","J@J"};
    String[] fTeam = {"Blue_Team","Red_Team","Spy_Team","SIBGUCHI_Team","Atom_Team","SKSH_Team","FeelsGood_Team","Memories_Team","Snoweee_Team","MeAndTheBoys_Team"};
    String[] fDep = {"RDR_Dep","SKS_Dep","OOF_Dep","DedIns_Dep","DDLN_Dep","Zaravidl_Dep","Af_Dep","GrafFas_Dep","Fem_Dep","Tx_Dep"};

//    String[] fDep = {"Blue_Team","Red_Team","Spy_Team","SIBGUCHI_Team","Atom_Team","SKSH_Team","FeelsGood_Team","Memories_Team","Snoweee_Team","MeAndTheBoys_Team"};
    Developer[] developers = new Developer[1000];
    Manager[] managers = new Manager[1000];
    Random rnd = new Random();

    for(Integer i = 0; i<1000; i++){
      developers[i] = new Developer(fName[rnd.nextInt(fName.length)],
        fEmail[rnd.nextInt(fEmail.length)],fTeam[rnd.nextInt(fTeam.length)]);
      managers[i] = new Manager(fName[rnd.nextInt(fName.length)],
        fEmail[rnd.nextInt(fEmail.length)],fDep[rnd.nextInt(fDep.length)]);
    }
    DeveloperRW Dev = new DeveloperRW();
    ManagerRW Man = new ManagerRW();

    File file = new File("/home/_1/Java/Tasks/2.FileWriter/src/main/resources", "developers.csv");
    if(file.exists() && file.isFile()){
      file.delete();
    }
    file.createNewFile();
    for(Integer i = 0; i < 1000; i++){
      Dev.toCSV(String.join(";", developers[i].getName(), developers[i].getEmail(),
        developers[i].getTeam(),"\n"));
    }
    file = new File("/home/_1/Java/Tasks/2.FileWriter/src/main/resources", "managers.csv");
    if(file.exists() && file.isFile()){
      file.delete();
    }
    file.createNewFile();
    for(Integer i = 0; i < 1000; i++){
      Man.toCSV(String.join(";", managers[i].getName(), managers[i].getEmail(),
        managers[i].getDep(),"\n"));
    }
  }

  public static final void main(String[] args) throws IOException{
    createDB();
    Integer num = 228;
    DeveloperRW dvl = new DeveloperRW();
    ManagerRW mng = new ManagerRW();
    String devout = dvl.fromCSV(num);
    String manout = mng.fromCSV(num);
    String str1[] = devout.split(";");
    String str2[] = manout.split(";");
    System.out.println(Arrays.toString(str1));
    System.out.println(Arrays.toString(str2));
  }
}
