package com.epam.tariff.logic;

import com.epam.tariff.entity.Tariff;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TariffXMLParser {
    private ArrayList<Tariff> tariffs = new ArrayList<Tariff>();

    public TariffXMLParser(String xmlFileName) {
        try{
            DOMParser domParser = new DOMParser();
            domParser.parse(xmlFileName);
            Document document = domParser.getDocument();
            Element root = document.getDocumentElement();
            analyze(root);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Tariff> getData() {
        return (ArrayList<Tariff>) Collections.unmodifiableList(tariffs);
    }

    public void analyze(Element root) {
        NodeList tariffList = root.getElementsByTagName("tariff");
        Tariff tariff = null;
        for(int i = 0; i < tariffList.getLength(); i++){
            tariff = new Tariff();
            Element tariffElement = (Element) tariffList.item(i);
            tariff.setName(getBabyValue(tariffElement, "name"));
            tariff.setOperatorName(getBabyValue(tariffElement, "OperatorName"));
        }
    }

    private String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value;
    }

    private Element getBaby(Element parent, String childName) {
        NodeList nodeList = parent.getElementsByTagName("name");
        Element child  = (Element) nodeList.item(0);
        return child;
    }
}
