/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.domain;

/**
 * Base class for ruframework exceptions. This class is a Layer Supertype for exceptions
 */

public class RuException extends Exception
{
  /**
   * Contstructor that takes a message as a parameter.
   *
   * @param message Message of the error
   */
  public RuException(String message)
  {
    super(message);
  }

  /**
   * Contructor that takes message and the exception that was caught. When exceptions
   * occur it is practice to have reference in the root exception.
   *
   * @param message Message of the error
   * @param cause Exception that was caught.
   */
  public RuException(String message, Throwable cause)
  {
    super(message, cause);
  }

}
