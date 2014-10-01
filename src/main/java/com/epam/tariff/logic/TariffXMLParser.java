package com.epam.tariff.logic;

import com.epam.tariff.entity.CallPrice;
import com.epam.tariff.entity.Parameter;
import com.epam.tariff.entity.Tariff;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TariffXMLParser {
    private ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    public final static Logger logger = Logger.getLogger(com.epam.tariff.logic.TariffXMLParser.class);

    public TariffXMLParser(String xmlFileName) {
        try{
            DOMParser domParser = new DOMParser();
            domParser.parse(xmlFileName);
            Document document = domParser.getDocument();
            Element root = document.getDocumentElement();
            analyze(root);
        } catch (SAXException e) {
            logger.error("XML parsing error: " + e.getMessage());
        } catch (IOException e) {
            logger.error("IO error: " + e.getMessage());
        }
    }

    public List<Tariff> getData() {
        return Collections.unmodifiableList(tariffs);
    }

    public void analyze(Element root) {
        NodeList tariffList = root.getElementsByTagName("tariff");
        for(int i = 0; i < tariffList.getLength(); i++){
            Element tariffElement = (Element) tariffList.item(i);
            Tariff tariff = buildTariff(tariffElement);
            tariffs.add(tariff);
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff tariff = new Tariff();
        tariff.setName(getElementTextContent(tariffElement, "name"));
        tariff.setOperatorName(getElementTextContent(tariffElement, "operatorName"));
        tariff.setPayroll(Double.parseDouble(getElementTextContent(tariffElement, "payroll")));
        tariff.setSmsPrice(Double.parseDouble(getElementTextContent(tariffElement, "smsPrice")));

        CallPrice callPrice = tariff.getCallPrice();
        Element elementCallPrice = (Element) tariffElement.getElementsByTagName("callPrice").item(0);
        callPrice.setIntraCallPrice(Double.parseDouble(getElementTextContent(elementCallPrice, "intraCallPrice")));
        callPrice.setExternalCallPrice(Double.parseDouble(getElementTextContent(elementCallPrice, "externalCallPrice")));
        callPrice.setLandLineCallPrice(Double.parseDouble(getElementTextContent(elementCallPrice, "landLineCallPrice")));

        Parameter parameter = tariff.getParameter();
        Element elementParameter = (Element) tariffElement.getElementsByTagName("parameter").item(0);
        parameter.setHasFavouriteNumber(Boolean.parseBoolean(getElementTextContent(elementParameter, "hasFavouriteNumber")));
        parameter.setTypeTariff(getElementTextContent(elementParameter, "typeTariff"));
        parameter.setGetOperatorPrice(Double.parseDouble(getElementTextContent(elementParameter, "getOperatorPrice")));

        return tariff;
    }

    private String getElementTextContent(Element parent, String childName) {
        NodeList nList = parent.getElementsByTagName(childName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
