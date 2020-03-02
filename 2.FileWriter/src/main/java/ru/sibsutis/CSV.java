import java.io.IOException;

interface CSV{ //хранит 2 метода
  void toCSV() throws IOException; //возвращающий строку, которую запишем в файл
  String fromCSV(Integer number) throws IOException; // примет строчку из файла
}
