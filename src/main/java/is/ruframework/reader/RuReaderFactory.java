package is.ruframework.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class RuReaderFactory
{
  protected String contextFile;

  public RuReaderFactory(String contextFile)
  {
    this.contextFile = contextFile;
  }

  public RuReader getReader(String name)
  {
    ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:" + contextFile);

    RuReader reader = (RuReader)applicationContext.getBean(name);
    return reader;
  }
}
