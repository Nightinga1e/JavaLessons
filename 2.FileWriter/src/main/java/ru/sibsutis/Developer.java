import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Developer extends User implements CSV{
    private String team;
    private String outputString;
    private Integer counter;
    private String str;

    public Developer (String name, String email, String team){
      super(name,email);
      this.team = team;
    }
    protected String getTeam(){
      return this.team;
    }

    public void toCSV() throws IOException{
      java.io.FileWriter fw = new java.io.FileWriter("developers.csv", true);
      str = (String.join(";",this.getName(), this.getEmail(), this.getTeam()));
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
