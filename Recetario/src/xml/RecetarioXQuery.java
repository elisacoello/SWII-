package xml;

import com.saxonica.xqj.SaxonXQDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

public class RecetarioXQuery {
	public static void main(String[] args) throws XQException {
		
		
	}
	public void ejecutarXQuery(String ruta) throws XQException{
		File queryFile = new File(ruta);

		XQDataSource xqjd = new SaxonXQDataSource();
		XQConnection xqjc = xqjd.getConnection();
		InputStream inputStream = null;
		try {
		    inputStream = new FileInputStream(queryFile);
		} catch (FileNotFoundException ex) {
		    Logger.getLogger(RecetarioXQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		XQPreparedExpression exp = xqjc.prepareExpression(inputStream);
		XQResultSequence result = exp.executeQuery();
		while (result.next()) {
		    System.out.println(result.getItemAsString(null));
		}
		result.close();
		exp.close();
		xqjc.close();
		
		
	}
		
}