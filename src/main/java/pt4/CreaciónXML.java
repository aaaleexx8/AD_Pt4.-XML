package pt4;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreaciónXML {

    public static void main(String[] args) {
        try {
            // creo la fabrica
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // creo el constructor (después de la fábrica)
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // creo el documento (después del constructor)
            Document doc = dBuilder.newDocument();

            // creo la raiz
            Element arrel = doc.createElement("zoo");
            doc.appendChild(arrel);

            // creo el objeto dentro de la raiz
            Element animal1 = doc.createElement("animal");
            animal1.setAttribute("id", "1"); // le doy un atributo
            arrel.appendChild(animal1); // la hago hizo de la raíz

                //DATOS
                Element nom1 = doc.createElement("nom"); //creo el dato nombre del objeto animal1
                nom1.appendChild(doc.createTextNode("Panda")); // le doy un texto al dato "nom"
                animal1.appendChild(nom1); // y termino haciendo que sea hijo del objeto

                Element especie1 = doc.createElement("especie");
                especie1.appendChild(doc.createTextNode("Ailuropoda melanoleuca"));
                animal1.appendChild(especie1);

                Element aliment1 = doc.createElement("aliment");
                aliment1.appendChild(doc.createTextNode("Herbívor"));
                animal1.appendChild(aliment1);

                Element edat1 = doc.createElement("edat");
                edat1.appendChild(doc.createTextNode("13"));
                animal1.appendChild(edat1);
                
            Element animal2 = doc.createElement("animal");
            animal2.setAttribute("id", "2"); // le doy un atributo
            arrel.appendChild(animal2); // la hago hizo de la raíz

                //DATOS
                Element nom2 = doc.createElement("nom"); 
                nom2.appendChild(doc.createTextNode("Gálago")); 
                animal2.appendChild(nom2);

                Element especie2 = doc.createElement("especie");
                especie2.appendChild(doc.createTextNode("Galagidae"));
                animal2.appendChild(especie2);

                Element aliment2 = doc.createElement("aliment");
                aliment2.appendChild(doc.createTextNode("Omnívoro"));
                animal2.appendChild(aliment2);

                Element edat2 = doc.createElement("edat");
                edat2.appendChild(doc.createTextNode("8"));
                animal2.appendChild(edat2);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File ("zoo.xml"));

            t.transform(source, sr);

            System.out.println("Fitxer XML creat correctament!");
        } catch (ParserConfigurationException | TransformerException e ) {
            e.printStackTrace();
        }
    }
}
