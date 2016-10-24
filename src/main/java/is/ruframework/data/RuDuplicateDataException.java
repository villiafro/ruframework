/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.data;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * Application specific exception for handling duplicate violations when
 * inserting into the database.
 *
 * Please refer to DataIntegrityViolationException for more explaination
 */

public class RuDuplicateDataException extends DataIntegrityViolationException
{
  /**
   * Contructor for this class
   * @param s Contructor for this class
   * @param throwable   The exception that was caught
   */
  public RuDuplicateDataException(String s, Throwable throwable)
  {
    super(s, throwable);

  }

} // RuDuplicateDataException
