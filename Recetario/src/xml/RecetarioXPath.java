package xml;


import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RecetarioXPath {
	    
	    public static String processNode(Node node) {
	        String data = "";
	        if(node.hasChildNodes()) {
	            data += node.getNodeName() + ": ";
	            NodeList nodes = node.getChildNodes();
	            for (int i = 0; i < nodes.getLength(); i++) {
	                data += processNode(nodes.item(i));}
	        } else {
	            data += node.getNodeValue();}
	        return data;
	    }
	    
	    public void ejecutarXPath(String sentencia) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
    	//Construir el DOM
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document doc = builder.parse("./recursos/recetario.xml"); //org.w3c.dom.Document

    	//Crear XPath
    	XPathFactory xpathfactory = XPathFactory.newInstance();
    	XPath xpath = xpathfactory.newXPath(); 

    	// Obtener todos los títulos con un atributo “dificultad” con valor ‘fácil’:
    	XPathExpression expr = xpath.compile(sentencia); //javax.xml.xpath.XPathExpression
    	Object result = expr.evaluate(doc, XPathConstants.NODESET);
    	NodeList nodes = (NodeList) result; //org.w3c.dom.NodeList
    	for (int i = 0; i < nodes.getLength(); i++) {
    	    System.out.println(processNode(nodes.item(i)));
    	}
    	  
	    
}
}
