package is.ruframework.reader;

import is.ruframework.client.RuClientRequest;

import java.util.logging.Logger;

public abstract class RuAbstractReader implements RuReader
{
  Logger log = Logger.getLogger(this.getClass().getName());
  protected String URI;
  protected RuReadHandler readHandler;

  public void setURI(String URI)
  {
    this.URI = URI;
  }

  public String getURI()
  {
    return URI;
  }

  public void setReadHandler(RuReadHandler readHandler)
  {
    this.readHandler = readHandler;
  }

  public RuReadHandler getReadHandler()
  {
    return readHandler;
  }

  public Object read() throws RuReaderException
  {
    if(readHandler == null)
    {
      String msg = "ReadHandler is not set";
      log.severe(msg);
      throw new RuReaderException(msg);
    }

    RuClientRequest clientRequest = new RuClientRequest();
    String content = "";

    content = clientRequest.getRequest(getURI());
    return parse(content);

  }
}
