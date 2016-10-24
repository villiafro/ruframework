/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.process;

/**
 * Exception thrown by RuProcessRunner
 *
 */

public class RuProcessException extends RuntimeException
{
  public RuProcessException(String message)
  {
    super(message);
  }

  public RuProcessException(String message, Throwable cause)
  {
    super(message, cause);
  }

} // RuProcessException
