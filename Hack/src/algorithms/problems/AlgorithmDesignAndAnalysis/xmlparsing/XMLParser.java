package algorithms.problems.AlgorithmDesignAndAnalysis.xmlparsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public static void main(String[] args) throws Exception {
        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document =
                builder.parse(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("XMLData.xml"));

        List<AirFlight> airFlights= new ArrayList<AirFlight>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                AirFlight airFlight=new AirFlight();
                airFlight.setKey(node.getAttributes().
                        getNamedItem("TraceId").getNodeValue());

                 NodeList childNodes = node.getChildNodes();
/*
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "firstName":
                                emp.firstName = content;
                                break;
                            case "lastName":
                                emp.lastName = content;
                                break;
                            case "location":
                                emp.location = content;
                                break;
                        }
                    }
                }
*/
                airFlights.add(airFlight);
            }

        }

        //Printing the Employee list populated.
        for(AirFlight airFlight:airFlights)
            System.out.println(airFlight.getKey());

    }
}

