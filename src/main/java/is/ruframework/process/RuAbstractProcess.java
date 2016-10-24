/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.process;

import java.util.logging.Logger;

/**
 * <i>FwAbstracProcess</i> provides the basic functionality of a process. The
 * class implements RuProcess and provides abstract methods for the requiered
 * startProcess method.
 *
 * Processes should extend this class and provide functionality for <i>startProcess</i>
 * and optionally the <i>beforeProces</i> and <i>afterProcess</i> methods.
 *
 */
abstract public class RuAbstractProcess implements RuProcess
{
  private RuProcessContext processContext;
  private String contextFile;
  private String parameters[];
  protected Logger log = Logger.getLogger(this.getClass().getName());

  /**
   * Empty constructor.
   */
  public RuAbstractProcess()
  {

  }

  /**
   * Set the process context.
   *
   * @param processContext Process context to set.
   */
  public void setProcessContext(RuProcessContext processContext)
  {
    this.processContext = processContext;

  }

  public RuProcessContext getProcessContext()
  {
    return processContext;
  }

  public String[] getParameters()
  {
    return parameters;
  }

  public void setParameters(String[] parameters)
  {
    this.parameters = parameters;
  }

  /**
   * Returns the path of the context files.
   * @return String containing the path of the context file.
   */
  public String getContextFile()
  {
    return contextFile;

  } // getContextFile

  /**
   * Set the process context.
   *
   * @param contextFile Process context to set.
   */
  public void setContextFile(String contextFile)
  {
    this.contextFile = contextFile;

  } // setContextFile

  /**
   * Subclasses of the class must provide functionaly for this method. This method
   * is called to start the process. It is called after <i>beforeProcess</i>.
   */
  abstract public void startProcess ();

  /**
   * This method is called before <i>startProcess</i> is called. Subclasses
   * can use this method to do any pre-process work.
   *
   * The RuAbstractProcess version of this method is empty.
   */
  public void beforeProcess ()
  {

  } // beforeProcess

  /**
   * This method is called after <i>startProcess</i> is called. Subclasses
   * can use this method to do any post-process work.
   *
   * The RuAbstractProcess version of this method is empty.
   */
  public void afterProcess ()
  {

  } // afterProcess

} // RuAbstractProcess
