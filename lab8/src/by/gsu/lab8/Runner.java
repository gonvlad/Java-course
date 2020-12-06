package by.gsu.lab8;

import by.gsu.pms.AmountRange;
import by.gsu.pms.Bank;
import by.gsu.pms.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class Runner {
    public static final String URL = "https://belgazprombank.by/upload/courses.xml";
    private static ArrayList<Bank> banks = new ArrayList<>();

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        int userMenuChoice;
        boolean isProgramRunning = true;

        while (isProgramRunning)
        {
            showUserMenu();
            System.out.print("\nChoose menu item: ");
            userMenuChoice = scanner.nextInt();
            switch (userMenuChoice) {
                case 1:
                    System.out.println(">>> Starting DOM parsing...");
                    banks = domParser(URL);
                    System.out.println(">>> Showing result...");
                    showResult(banks);
                    System.out.println("\n>>> DOM parsing ended.");
                    break;
                case 2:
                    System.out.println(">>> Starting SAX parsing...");
                    saxParser();
                    System.out.println(">>> Showing result...");
                    showResult(banks);
                    System.out.println("\n>>> SAX parsing ended.");
                    break;
                case 3:
                    System.out.println(">>> Starting StAX parsing...");
                    banks = staxParser("resourсes/markup.xml");
                    System.out.println(">>> Showing result...");
                    showResult(banks);
                    System.out.println("\n>>> StAX parsing ended.");
                    break;
                case 4:
                    System.out.println("\n>>> Exiting program...");
                    isProgramRunning = false;
                    break;
                default:
                    System.out.println(">>> Unknown menu item! Choose another one.");
                    break;
            }
        }
    }

    public static void showUserMenu() {
        System.out.println("\n\t\tUSER MENU");
        System.out.println("------------------------------");
        System.out.println("1. Execute DOM parser");
        System.out.println("2. Execute SAX parser");
        System.out.println("3. Execute StAX parser");
        System.out.println("4. EXIT program");
    }

    public static void showResult(ArrayList<Bank> banks) {
        for (Bank bank : banks) {
            System.out.println("\n\t"  + bank.getBankName());
            System.out.println("----------------------------------------");

            for (Currency currency: bank.getCurrencies()) {
                System.out.println(currency.getCurrencyName() + " (" + currency.getNumberOfUnits() + " Unit(s)):");

                for (AmountRange amountRange: currency.getAmountRanges()) {
                    System.out.printf("\tAmount range: %-6d - %-15d buy price: %.3f BYN | sell price: %.3f BYN%n",
                            amountRange.getMinAmount(),
                            amountRange.getMaxAmount(),
                            amountRange.getBuyPrice(),
                            amountRange.getSellPrice());
                }
            }
        }
    }

    public static ArrayList<Bank> domParser(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url);

        NodeList banksList = document.getDocumentElement().getElementsByTagName("branch");
        ArrayList<Bank> banks = new ArrayList<>();
        for (int i = 0; i < banksList.getLength(); ++i)
        {
            Node bank = banksList.item(i);
            NamedNodeMap bankAttributes = bank.getAttributes();

            NodeList ratesList = bank.getChildNodes();
            ArrayList<Currency> currencies = new ArrayList<>();
            for (int j = 0; j < ratesList.getLength(); ++j)
            {
                Node rate = ratesList.item(j);
                NamedNodeMap ratesAttributes = rate.getAttributes();
                if (rate.getFirstChild().hasAttributes() && rate.getFirstChild().getNodeName().equals("range"))
                {
                        NodeList rangesList = rate.getChildNodes();
                        ArrayList<AmountRange> amountRanges = new ArrayList<>();
                        for (int k = 0; k < rangesList.getLength(); ++k)
                        {
                            Node range = rangesList.item(k);
                            NamedNodeMap rangeAttributes = range.getAttributes();
                            NodeList valuesList = range.getChildNodes();
                            amountRanges.add(new AmountRange(
                                        Integer.parseInt(rangeAttributes.getNamedItem("min-amount").getNodeValue()),
                                        new BigInteger(rangeAttributes.getNamedItem("max-amount").getNodeValue()),
                                        Double.parseDouble(valuesList.item(0).getTextContent()),
                                        Double.parseDouble(valuesList.item(1).getTextContent())));

                        }

                        currencies.add(new Currency(
                                        ratesAttributes.getNamedItem("currency").getNodeValue(),
                                        Integer.parseInt(ratesAttributes.getNamedItem("Units").getNodeValue()),
                                        amountRanges));
                }
            }

            banks.add(new Bank(bankAttributes.getNamedItem("name").getNodeValue(), currencies));
        }

        return banks;
    }

    public static void saxParser() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resourсes/markup.xml"), handler);
    }

    private static class XMLHandler extends DefaultHandler {
        private String lastElementName;

        private static ArrayList<Bank> banks_t = new ArrayList<>();
        private static ArrayList<Currency> currencies_t = new ArrayList<>();
        private static ArrayList<AmountRange> amountRanges_t = new ArrayList<>();
        private String bankName_t;
        private String currencyName_t;
        private String numberOfUnits_t;
        private String minAmount_t;
        private String maxAmount_t;
        private String buyPrice_t;
        private String sellPrice_t;

        @Override
        public void endDocument() {
            banks = banks_t;
            banks_t = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            lastElementName = qName;

            if (qName.equals("branch")) {
                bankName_t = attributes.getValue("name");
            }

            if (qName.equals("rate")) {
                currencyName_t = attributes.getValue("currency");
                numberOfUnits_t = attributes.getValue("Units");
            }

            if (qName.equals("range")) {
                minAmount_t = attributes.getValue("min-amount");
                maxAmount_t = attributes.getValue("max-amount");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("buy")) {
                    buyPrice_t = information;
                }
                if (lastElementName.equals("sell")) {
                    sellPrice_t = information;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("range")) {
                if ((buyPrice_t != null && !buyPrice_t.isEmpty()) && (sellPrice_t != null && !sellPrice_t.isEmpty())) {
                    amountRanges_t.add(new AmountRange(Integer.parseInt(minAmount_t), new BigInteger(maxAmount_t), Double.parseDouble(buyPrice_t), Double.parseDouble(sellPrice_t)));
                }
                buyPrice_t = null;
                sellPrice_t = null;
                minAmount_t = null;
                maxAmount_t = null;
            }

            if (qName.equals("rate")) {
                if (currencyName_t != null && !currencyName_t.isEmpty() && numberOfUnits_t != null && !numberOfUnits_t.isEmpty() && !amountRanges_t.isEmpty()) {
                    currencies_t.add(new Currency(currencyName_t, Integer.parseInt(numberOfUnits_t), amountRanges_t));
                }
                currencyName_t = null;
                numberOfUnits_t = null;
                amountRanges_t = new ArrayList<>();
            }

            if (qName.equals("branch")) {
                if (bankName_t != null && !bankName_t.isEmpty() && !currencies_t.isEmpty()) {
                    banks_t.add(new Bank(bankName_t, currencies_t));
                }
                bankName_t = null;
                currencies_t = new ArrayList<>();
            }
        }
    }

    public static ArrayList<Bank> staxParser(String filePath) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));

        ArrayList<Bank> banks_t = new ArrayList<>();
        ArrayList<Currency> currencies_t = new ArrayList<>();
        ArrayList<AmountRange> amountRanges_t = new ArrayList<>();
        String bankName_t = null;
        String currencyName_t = null;
        String numberOfUnits_t = null;
        String minAmount_t = null;
        String maxAmount_t = null;
        String buyPrice_t = null;
        String sellPrice_t = null;

        while (eventReader.hasNext()) {
            XMLEvent xmlEvent = eventReader.nextEvent();

            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();

                switch (startElement.getName().getLocalPart()) {
                    case "branch":
                        bankName_t = startElement.getAttributeByName(new QName("name")).getValue();
                        break;
                    case "rate":
                        currencyName_t = startElement.getAttributeByName(new QName("currency")).getValue();
                        numberOfUnits_t = startElement.getAttributeByName(new QName("Units")).getValue();
                        break;
                    case "range":
                        minAmount_t = startElement.getAttributeByName(new QName("min-amount")).getValue();
                        maxAmount_t = startElement.getAttributeByName(new QName("max-amount")).getValue();
                        break;
                    case "buy":
                        xmlEvent = eventReader.nextEvent();
                        buyPrice_t = xmlEvent.asCharacters().getData();
                        break;
                    case "sell":
                        xmlEvent = eventReader.nextEvent();
                        sellPrice_t = xmlEvent.asCharacters().getData();
                        break;
                }
            } else if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();

                switch (endElement.getName().getLocalPart()) {
                    case "range":
                        assert minAmount_t != null;
                        assert buyPrice_t != null;
                        assert sellPrice_t != null;
                        amountRanges_t.add(new AmountRange(Integer.parseInt(minAmount_t), new BigInteger(maxAmount_t), Double.parseDouble(buyPrice_t), Double.parseDouble(sellPrice_t)));
                        buyPrice_t = null;
                        sellPrice_t = null;
                        minAmount_t = null;
                        maxAmount_t = null;
                        break;
                    case "rate":
                        assert numberOfUnits_t != null;
                        currencies_t.add(new Currency(currencyName_t, Integer.parseInt(numberOfUnits_t), amountRanges_t));
                        currencyName_t = null;
                        numberOfUnits_t = null;
                        amountRanges_t = new ArrayList<>();
                        break;
                    case "branch":
                        banks_t.add(new Bank(bankName_t, currencies_t));
                        bankName_t = null;
                        currencies_t = new ArrayList<>();
                        break;
                }
            }
        }

        return banks_t;
    }
}
