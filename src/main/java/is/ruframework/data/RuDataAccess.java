/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.data;

import javax.sql.DataSource;

/**
 * All data access interfaces must extend the base RuDataAccess interface and provide the method
 * <i>setDataSource</i>. This method sets the datasource for the instantiated
 * data access object
 */

public interface RuDataAccess
{
  /**
   * Set the DataSource that concreate classes implementing this interface must
   * have. The RuDataAccessFactory will contain a datasource and provide a reference when
   * generating new data access objects.
   *
   * @param dataSource The datasource specifying the connection information
   */
  public void setDataSource (DataSource dataSource);

  /**
   * Returns the DataSource associated with subclasses.
   * @return DataSource The current DataSource
   */
  public DataSource getDataSource ();

} // RuDataAccess
