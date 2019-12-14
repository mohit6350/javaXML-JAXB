package com.quinnox.util;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.quinnox.binding.PurchaseOrderType;

public class InMemoryValidation {
	public static void main(String[] args) throws Exception {
		SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sFactory.newSchema(new File(InMemoryValidation.class.getClassLoader().getResource("purchaseOrder.xsd").getPath()));
		JAXBContext context = JAXBContext.newInstance("com.quinnox.binding");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setSchema(schema);
		JAXBElement<PurchaseOrderType> pot = (JAXBElement<PurchaseOrderType>) unmarshaller.unmarshal(new File(InMemoryValidation.class.getClassLoader().getResource("purchaseOrder.xml").getPath()));
		System.out.println(pot.getValue().getShippingAddress().getAddressLine1());
	}
	
}
