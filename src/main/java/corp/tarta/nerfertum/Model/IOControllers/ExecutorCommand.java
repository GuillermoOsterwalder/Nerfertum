package corp.tarta.nerfertum.Model.IOControllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by morio on 30/06/17.
 */
public class ExecutorCommand implements Command{

  @Override
  public void doExecute(String command) {
    try {
      String linea;
      Process p = Runtime.getRuntime().exec(command);
      BufferedReader input = new BufferedReader (new InputStreamReader(p.getInputStream()));
      while ((linea = input.readLine()) != null) {
        System.out.println(linea);
      }
      input.close();
    }
    catch (Exception err) {
      err.printStackTrace();
    }
  }
}
