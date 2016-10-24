/**
 * RU Framework
 * This class or interface is part of a Framework used in cource
 * T-302-HONN, Design and Implementation at Reykjavik University.
 */

package is.ruframework.data;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;

import is.ruframework.domain.RuException;

import java.util.logging.Logger;

/**
 * RuDataAccessFactory provides the needed Data Access Objects. The factory assumes
 * information on the database connections is defined in the dataSourceFile.
 * The dataSourceFile must define a bean called <b>data</b> of type DriveManagerDataSource
 * and provide property values for <i>driverClassName</i>, <i>url</i>, <i/>username</i>,
 * and <i>password</i>.
 */

public class RuDataAccessFactory
{
  // Logger object
  private Logger log = Logger.getLogger(this.getClass().getName());

  /**
   * Data Source used by the factory. All new data access objects will have access to
   * this datesource.
   */
  private DataSource dataSource = null;

  /**
   * Factory for generating new data access object. The generated data access object must be specified
   * in the XML file supplied to the constructor.
   */
  private BeanFactory beanFactory = null;


  private void setBeanFactory(BeanFactory beanFactory)
  {
    this.beanFactory = beanFactory;
  }

  /**
   * Returns an instance of a RuDataAccessFactory that is initialized from the given jdbcFileName
   * parameter. This file must contain a bean description of jdbc datasource.
   *
   * @param jdbcFileName Name of the file containing the bean description
   * @return RuDataAccessFactory
   * @throws RuException
   */
  public static RuDataAccessFactory getInstance(String jdbcFileName) throws RuException
  {
    RuDataAccessFactory factory = new RuDataAccessFactory();
    factory.initBeanFactory(jdbcFileName);
    factory.loadFromFile();
    return factory;
  }

  /**
   * Returns an instance of a data accessFactory using the supplied datasource. All data access
   * objects are defined in the jdbcFileName file.
   *
   * @param dataSource Valid datasource that will be used by the factory
   * @param jdbcFileName Name o
   * @throws RuException the file containing the data access bean descriptions
   * @return RuDataAccessFactory
   */
  public static RuDataAccessFactory getInstance (DataSource dataSource, String jdbcFileName)  throws RuException
  {
    RuDataAccessFactory factory = new RuDataAccessFactory();
    factory.initBeanFactory(jdbcFileName);
    factory.dataSource = dataSource;
    return factory;
  }

  /**
   * Returns an instance of a RuDataAccessFactory that is initialized from the given jdbcFileName
   * parameter. This file must contain a bean description of jdbc datasource.
   *
   * @param beanFactory
   * @return RuDataAccessFactory
   * @throws RuException
   */
  public static RuDataAccessFactory getInstance(BeanFactory beanFactory) throws RuException
  {
    RuDataAccessFactory factory = new RuDataAccessFactory();
    factory.setBeanFactory(beanFactory);
    factory.loadFromFile();
    return factory;
  }


  /**
   * Private contstructor so Factory cannot be new-ed
   */
  private RuDataAccessFactory()
  {}

  private void initBeanFactory(String jdbcFileName) throws RuException
  {
    try
    {
      beanFactory = new FileSystemXmlApplicationContext("classpath:" + jdbcFileName);
    }
    catch (BeansException bex)
    {
      String tmp = "Unable to initialize the bean factory with name '" + jdbcFileName + "'.";
      log.severe(tmp);
      throw new RuException(tmp, bex);

    }
  }


   /**
   * Factory constructor that takes as parameter the path to dataSource file. This
   * file must contain XML Bean definition for data access object. Data Source information
   * is specified by the <b>jdbc</b> object.
   *
   * @throws RuException
   */
  private void loadFromFile() throws RuException
  {
    try
    {
      dataSource = (DataSource)beanFactory.getBean("dataSource");
    }
    catch (BeansException bex)
    {
      String tmp = "Unable to load 'dataSource' bean from file (Driver could be missing)";
      log.severe(tmp);
      throw new RuException(tmp, bex);
    }
  }

/**
 * getDataAccess returns a data access object of a specified class. The data access object must be
 * defined in bean definition in the dataSourceFile under the name provided
 * by data accessName. The bean definitions needs to specify the claas name.
 *
 * If the dataSourceFile was not initiation properly calling this function
 * will result in NullPointerException
 *
 * @param dataAccessName name of the data access class as it is in the dataSourceFile
 * @return RuDataAccess class that can be typecast into the proper type
 */
  public RuDataAccess getDataAccess(String dataAccessName)
  {
    RuDataAccess dataAccess = (RuDataAccess)beanFactory.getBean(dataAccessName);
    dataAccess.setDataSource(dataSource);
    return dataAccess;

  }

} // RuDataAccessFactory
