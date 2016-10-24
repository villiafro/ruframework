/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.process;

/**
 * <i/>RuProcess</i> represents a generic process. Process is a software component that
 * will run and provide simple funcionality such as read a file and update a database.
 * Each process has a process context associated with it. The process context is
 * represented by <i>RuProcessContext</i> object. Definition of the process context must
 * be provided in the process context file.
 *
 * Example context file:
 *
 * <pre>
 * &lt;beans&gt
 *   &lt;bean id="processContext" class="is.ruframework.process.RuProcessContext"&gt
 *    &lt;property name="processName"&gt
 *      &lt;value&gt;teamimportprocess&lt;/value&gt;
 *    &lt;/property&gt;
 *    &lt;property name="importFile"&gt;
 *      &lt;value&gt;etc/teams.xml&lt;/value&gt;
 *    &lt;/property&gt;
 *    &lt;property name="processClass"&gt;
 *      &lt;value&gt;is.ru.honn.sport.imports.TeamImportProcess&lt;/value&gt;
 *    &lt;/property&gt;
 *    &lt;property name="dataSourceFile"&gt;
 *      &lt;value&gt;etc/jdbc.xml&lt;/value&gt;
 *    &lt;/property&gt;
 *   &lt;/bean&gt;
 * &lt;/beans&gt;
 * </pre>
 *
 * To run a process, use RuProcessRunner which provides functionality to load
 * the process context and run the process.
 *
 * Subclasses of this class must provide functionality for <i>startProcess</i> and optionally
 * the <i>beforeProcess</i> and <i>afterProcess</i> methods.
 *
 * The abstract class <i>RuAbstractProcess</i> implements this interface and provides the
 * basic functionality for a process. Processes should extend <i>RuAbstractProcess</i>.
 *
 */

public interface RuProcess
{
  /**
   * Set the process context.
   *
   * @param processContext Process context to set.
   */
   public void setProcessContext(RuProcessContext processContext);

  /**
   * Set the process context.
   *
   * @param params Sets the parameters of the process
   */
  public void setParameters(String[] params);


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
  public void beforeProcess ();

  /**
   * This method is called after <i>startProcess</i> is called. Subclasses
   * can use this method to do any post-process work.
   *
   * The RuAbstractProcess version of this method is empty.
   */
  public void afterProcess ();

} // RuProcess
