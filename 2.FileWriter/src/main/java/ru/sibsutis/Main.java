import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main{
  public static void createDB() throws IOException{
    String[] fName = {"Ivan","Kate","Robert","Dave","Wade","Riley","Gilbert","Dan","Brian","Liam"};
    String[] fEmail = {"A@A","B@B","C@C","D@D","E@E","F@F","G@G","H@H","I@I","J@J"};
    String[] fTeam = {"Blue_Team","Red_Team","Spy_Team","SIBGUCHI_Team","Atom_Team","SKSH_Team","FeelsGood_Team","Memories_Team","Snoweee_Team","MeAndTheBoys_Team"};
    String[] fDep = {"RDR_Dep","SKS_Dep","OOF_Dep","DedIns_Dep","DDLN_Dep","Zaravidl_Dep","Af_Dep","GrafFas_Dep","Fem_Dep","Tx_Dep"};

    Developer[] developers = new Developer[1000];
    Manager[] managers = new Manager[1000];
    Random rnd = new Random();

    for(Integer i = 0; i < 1000; i++){
      developers[i] = new Developer(fName[rnd.nextInt(fName.length)],
        fEmail[rnd.nextInt(fEmail.length)],fTeam[rnd.nextInt(fTeam.length)]);
      managers[i] = new Manager(fName[rnd.nextInt(fName.length)],
        fEmail[rnd.nextInt(fEmail.length)],fDep[rnd.nextInt(fDep.length)]);
    }

    File file = new File("/home/_1/Java/Tasks/2.FileWriter/src/main/resources", "developers.csv");
    if(file.exists() && file.isFile()){
      file.delete();
    }
    file.createNewFile();
    for(Integer i = 0; i < 1000; i++){
        developers[i].toCSV();
    }
    file = new File("/home/_1/Java/Tasks/2.FileWriter/src/main/resources", "managers.csv");
    if(file.exists() && file.isFile()){
      file.delete();
    }
    file.createNewFile();
    for(Integer i = 0; i < 1000; i++){
        managers[i].toCSV();
    }
  }

  public static final void main(String[] args) throws IOException{
    createDB();
    System.out.println("Enter number(max=1000):");
    Scanner scanner = new Scanner(System.in);

    Integer num = scanner.nextInt();
    Developer dvl = new Developer("","","");
    Manager mng = new Manager("","","");
    String devout = dvl.fromCSV(num);
    String manout = mng.fromCSV(num);
    String str1[] = devout.split(";");
    String str2[] = manout.split(";");
    System.out.println(Arrays.toString(str1));
    System.out.println(Arrays.toString(str2));
  }
}
