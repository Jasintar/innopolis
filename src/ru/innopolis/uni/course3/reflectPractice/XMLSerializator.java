package ru.innopolis.uni.course3.reflectPractice;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by julia on 12.12.2016.
 */
public class XMLSerializator {
//    Class objClass;

    public XMLSerializator() {
    }


    public void serialize(Object o, String filename) {
        Class objClass = o.getClass();

        if (objClass.getDeclaredFields().length == 0) {
            System.out.println("class has no fields");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        DOMImplementation impl = builder.getDOMImplementation(); // более сложный, но и более гибкий способ создания документов
        Document doc = impl.createDocument(null, // namespaceURI
                null, // qualifiedName
                null); // doctype
        Element e1 = doc.createElement("object");
        e1.setAttribute("type", objClass.getName());
        doc.appendChild(e1);

        for (Field field: objClass.getDeclaredFields()) {
            System.out.println(field.toString());
            Element e2 = doc.createElement("field");
            e2.setAttribute("type", field.getType().toString());
            e2.setAttribute("id", field.getName());
            try {
                e2.setAttribute("value", field.get(o).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            e1.appendChild(e2);
        }
        writeDocument(doc, filename);
    }

    public List<Object> deserialize(String filename) {
        List<Object> list = new LinkedList<>();
//        Object o = new Object();
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = null;
        try {
            builder = f.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            Document doc = builder.parse(new File(filename));
            NodeList methodNodes = doc.getChildNodes();
            for (int i = 0; i < methodNodes.getLength(); i++) {
                Node node = methodNodes.item(i);
                if (node.getNodeName() == "object") {
                    NamedNodeMap attrs = node.getAttributes();
                    String type = attrs.getNamedItem("type").getNodeValue().toString();

                    Class instanceClass = Class.forName(type);

                    Object obj = instanceClass.newInstance(); // create object

                    NodeList childrens = node.getChildNodes();
                    for (int j = 0; j < childrens.getLength(); j++) {
                        Element elem = (Element) childrens.item(j);
//                        Node childNode = childrens.item(i);
                        if (elem.getTagName() == "field") {
                            String id = elem.getAttribute("id");
                            String value = elem.getAttribute("value");
                            String feldType;
                            Field field;
                            switch (elem.getAttribute("type")) {
                                case "class java.lang.String":
                                    field = instanceClass.getDeclaredField(id);
                                    field.set(obj, value);
//                                    Class instanceField = Class.forName(elem.getAttribute("type"));
//                                    Object fieldObj = instanceField.newInstance();
                                    break;
                                case "int":
                                    field = instanceClass.getDeclaredField(id);
                                    field.set(obj, Integer.valueOf(value));
//                                    Class instanceField = Class.forName(elem.getAttribute("type"));
//                                    Object fieldObj = instanceField.newInstance();
                                    break;
                            }
                        }
//                        String childType = attrs.getNamedItem("type").toString();
                    }
                    list.add(obj);
                }
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return list;
    }

    private void writeDocument(Document document, String filename) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(filename);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
