/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.process;

import java.util.Map;

/**
 * The <i>RuProcessContext</i> object is associated with a process represented
 * by the <i>RuAbstractProcess</i> class.
 *
 * The process context proves the needed environment of the process to run, for
 * exmaple the process name, the process class, import file and dataSource file
 * to be used.
 *
 */

public class RuProcessContext
{
  private String processName;
  private String processClass;
  private String importFile;
  private String importURL;
  private String dataSourceFile;
  private Map params;

  public RuProcessContext()
  {
  }

  public String getProcessName()
  {
    return processName;
  }

  public void setProcessName(String processName)
  {
    this.processName = processName;
  }

  public String getProcessClass()
  {
    return processClass;
  }

  public void setProcessClass(String processClass)
  {
    this.processClass = processClass;
  }

  public String getImportFile()
  {
    return importFile;
  }

  public void setImportFile(String importFile)
  {
    this.importFile = importFile;
  }

  public String getImportURL()
  {
    return importURL;
  }

  public void setImportURL(String importURL)
  {
    this.importURL = importURL;
  }

  public String getDataSourceFile()
  {
    return dataSourceFile;
  }

  public void setDataSourceFile(String dataSourceFile)
  {
    this.dataSourceFile = dataSourceFile;
  }

  public Map getParams()
  {
    return params;
  }

  public void setParams(Map params)
  {
    this.params = params;
  }

}


