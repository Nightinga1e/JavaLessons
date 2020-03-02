import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Manager extends User implements CSV{
  private String dep;
  private String outputString;
  private Integer counter;
  private String str;

  public Manager (String name, String email, String dep){
    super(name,email);
    this.dep = dep;
  }

  protected String getDep(){
    return this.dep;
  }

  public void toCSV() throws IOException{
    java.io.FileWriter fw = new java.io.FileWriter("managers.csv", true);
    str = (String.join(";", this.getName(), this.getEmail(), this.getDep(),"\n"));
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

