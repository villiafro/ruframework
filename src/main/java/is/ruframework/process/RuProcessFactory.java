package is.ruframework.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.util.Assert;


/**
 * RuProcessFactory
 *
 * The process factory is responsibile for loading processes based on the Process Context (represented by
 * value object class RuProcessContext). ProcessContext are specified in XML files using the Spring Bean
 * Factory DTD.
 *
 */
public class RuProcessFactory
{
  private String contextFile;
  private RuProcessContext processContext;

  public RuProcessFactory(String contextFile)
  {
    this.contextFile = contextFile;
  }

  public RuProcessFactory(RuProcessContext pctx)
  {
    this.processContext = pctx;
  }

  public String getContextFile()
  {
    return contextFile;
  }

  public void setContextFile(String contextFile)
  {
    this.contextFile = contextFile;
  }

  public RuProcessContext getProcessContext()
  {
    return processContext;
  }

  public RuProcess loadProcess(RuProcessContext ctx) throws RuProcessException
  {
    RuProcess process = null;

    // Load the process specified in the context file
    try
    {
      Class cls = Class.forName(ctx.getProcessClass());
      process = (RuProcess)cls.newInstance();
      process.setProcessContext(ctx);
    }
    catch (Exception e)
    {
      String tmp = "Class '" + ctx.getProcessClass() + "'specified in '" + contextFile + "' not founnd";
      throw new RuProcessException(tmp, e);
    }

    return process;

  } // loadProcess

  public RuProcess loadProcess() throws RuProcessException
  {
    if(processContext == null)
    {
       loadProcessContext();
    }
    return loadProcess(processContext);
  }

  /**
    * Load the Context file and instanciate the process context
    *
    * @param contextFile File name of context file
    */

   public void loadProcessContext(String contextFile) throws RuProcessException
   {
     try
     {
       ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:" + contextFile);
       processContext = (RuProcessContext)applicationContext.getBean("processContext");
     }
     catch (BeansException e)
     {
       String tmp = "File '" + contextFile + "' not found. Exception: " + e.getMessage();
       //log.severe(tmp);
       throw new RuProcessException(tmp, e);
     }

   } // loadProcessContext

   public void loadProcessContext() throws RuProcessException
   {
     Assert.notNull(contextFile);
     loadProcessContext(contextFile);

   } // loadProcessContext

}
