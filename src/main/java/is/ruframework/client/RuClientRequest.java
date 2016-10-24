/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.client;

import is.ruframework.reader.RuReaderException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * RuClientRequest is a simple class that connects to an HTTP service and gets the contents
 * of the request back. The class can also read from file system.
 */

public class RuClientRequest
{
  public RuClientRequest()
  {
  }

  /**
   * getRequest returns the content of the URL specified
   *
   * @param url the URL resource
   * @return Content in a string format
   */
  public String getRequest(String url)
  {
    Client client = ClientBuilder.newClient();
    Response response = client.target(url).request().get();

    String result = response.readEntity(String.class);
    client.close();

    return result;
  }

  /**
   * getFileContent opens a file and reads the content into a string and
   * returns the string
   *
   * @param fileName filename
   * @return Contents of the file
   * @throws RuReaderException
   */
  public String getFileContent(String fileName) throws RuReaderException
  {
    StringBuilder content = new StringBuilder();
    try
    {
      java.io.FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;
      while((line = bufferedReader.readLine()) != null)
      {
        content.append(line);
      }
      bufferedReader.close();
    }
    catch(FileNotFoundException ex)
    {
      String msg = "Unable to open file '" + fileName + "'";
      throw new RuReaderException(msg, ex);
    }
    catch(IOException ex)
    {
      String msg = "Error reading file '" + fileName + "'";
      throw new RuReaderException(msg, ex);
    }
    return content.toString();
  }

}
