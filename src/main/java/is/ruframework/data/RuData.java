/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.data;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * RuData is a base class for JDBC klasses. The main functionality of the class
 * is to hold a datasource. When a data access class is created by the RuDataAccessFactory, the
 * datasource is set.
 */

public class RuData implements RuDataAccess
{
  // Logger
  protected Logger log = Logger.getLogger(this.getClass().getName());

  /**
   * DataSource supplied by the factory when the class is instanciated.
   */
  private DataSource dataSource;

  /**
   * Sets the DataSource for this JDBC class. The factory class, RuDataAccessFactory calls
   * this method to set the datasource.
   *
   * @param dataSource A vaild dataource object.
   */
  public void setDataSource (DataSource dataSource)
  {
    this.dataSource = dataSource;
  }

  /**
   * Returns the current DataSource. Subclasses need to call this method to get
   * access to the database.
   * @return DataSource The current datasource
   */
  public DataSource getDataSource()
  {
    return dataSource;
  }

} // RuData


