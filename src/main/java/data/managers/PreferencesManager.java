package data.managers;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import utils.PreferencesManagerConstants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.Properties;

public class PreferencesManager {

    private static PreferencesManager instance;
    private static final String XML_PATH = "configuration/appconfig.xml";
    private Document document;
    private XPath path;
    private Properties properties;

    private PreferencesManager() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(XML_PATH);
            XPathFactory xpathfactory = XPathFactory.newInstance();
            this.path = xpathfactory.newXPath();
            this.properties = new Properties();
            readProperties();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static PreferencesManager getInstance() {
        if (instance == null) {
            instance = new PreferencesManager();
        }
        return instance;
    }


    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperties(Properties prop) {
        prop.stringPropertyNames().forEach(property -> setProperty(property,prop.getProperty(property)));
    }

    public Properties getProperties() {
        return properties;
    }

    private void readProperties() {
        String[] keys = {PreferencesManagerConstants.classname, PreferencesManagerConstants.DBName,
                PreferencesManagerConstants.drivertype, PreferencesManagerConstants.pass,
                PreferencesManagerConstants.hostName, PreferencesManagerConstants.port,
                PreferencesManagerConstants.user};
        for(String key : keys){
            try {
                properties.setProperty(key,path.evaluate(key,document));
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
    }

}
