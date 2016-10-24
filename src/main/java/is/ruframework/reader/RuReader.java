package is.ruframework.reader;

public interface RuReader
{
  public Object read() throws RuReaderException;
  public Object parse(String content) throws RuReaderException;
  public void setURI(String URI);
  public void setReadHandler(RuReadHandler readHandler);
}
