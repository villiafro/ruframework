/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.process;

import java.util.logging.Logger;

/**
 * <i>RuProcessRunner</i> provides the enviroment to run a process. The runner
 * provides a <i>main</i> method to run the process. The main method must have
 * as a parameter the path and name of the process context file. The runner will
 * load load the process context files and create process class specified in
 *
 * <i>RuProcessRunner</i> support threads since the class implements the <i>Runnable</i>
 * interface.
 *
 */

public class RuProcessRunner implements Runnable
{
  Logger log = Logger.getLogger(this.getClass().getName());
  private RuProcess process = null;

  public RuProcess getProcess()
  {
    return process;
  }

  /**
   * main method. The args array must contain the name of the context file as parameter.
   * The context file must define <i>processContext</i> of type <i>RuProcessContext</i>.
   *
   * @param args
   */

  public static void main(String[] args)
  {
    // context file must be specifid as parameter
    if (args.length == 0)
    {
      System.out.println("Name of context file required as parameter");
      System.exit(0);
    }

    try
    {
      RuProcessRunner runner = new RuProcessRunner(args[0]);
      runner.run();
    }
    catch (RuProcessException fwpe)
    {
      System.out.println(fwpe.getMessage());
    }

  }

  /**
   * Constructor that take the name of the context file as a parameter
   *
   * @param contextFile
   * @throws RuProcessException
   */

  public RuProcessRunner(String contextFile) throws RuProcessException
  {
    if (contextFile == null)
    {
      String tmp = "Parameter contextFile must not be null";
      log.severe(tmp);
      throw new RuProcessException(tmp);
    }

    RuProcessFactory factory = new RuProcessFactory(contextFile);
    process = factory.loadProcess();
  }

  /**
   * Contructor that takes a <i>RuProcessContext</i> as parameter
   *
   * @param pctx
   */

  public RuProcessRunner(RuProcessContext pctx)
  {
    RuProcessFactory factory = new RuProcessFactory(pctx);
    process = factory.loadProcess();
  }

  /**
   *
   * Contructor that takes a <i>RuProcess</i> as parameter
   *
   * @param process
   */

  public RuProcessRunner(RuProcess process)
  {
    this.process = process;
  }

  /**
   * run will execute the process by calling, in sequence, beforeProcess, startProcess and
   * endProcess. The method can be started as a thread.
   */

  public void run()
  {
    if (process != null)
    {
      process.beforeProcess();
      process.startProcess();
      process.afterProcess();
    }
  }

} // RuProcessRunner
