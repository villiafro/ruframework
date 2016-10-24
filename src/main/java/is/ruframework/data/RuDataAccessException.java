/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.data;

import org.springframework.dao.DataAccessException;

/**
 * Generic data access exception used by the ruframework. This is a nested runtime
 * exception, so classes using the ruframework can choose to use checked or
 * unchecked (runtime) exceptions.
 *
 * Please refer to DataAccessException for more explaination
 */

public class RuDataAccessException extends DataAccessException
{
  /**
   * Contructor for this class
   * @param message Contructor for this class
   */
  public RuDataAccessException(String message)
  {
    super(message);

  } // RuDataAccessException

  /**
   * Contructor for this class
   * @param message Contructor for this classMesa
   * @param cause   The exception that was caught
   */
  public RuDataAccessException(String message, Throwable cause)
  {
    super(message, cause);

  } // RuDataAccessException

} // RuDataAccessException
