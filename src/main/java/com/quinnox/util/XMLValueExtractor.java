package com.quinnox.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.quinnox.binding.OrderItemType;
import com.quinnox.binding.PurchaseOrderType;
import com.quinnox.binding.ShippingAddressType;

public class XMLValueExtractor {

	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance("com.quinnox.binding");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<PurchaseOrderType> element =(JAXBElement<PurchaseOrderType>) unmarshaller.unmarshal(new File(XMLValueExtractor.class.getClassLoader().getResource("purchaseOrder.xml").getPath()));
		PurchaseOrderType purchaseOrderType = element.getValue();
		
		// getting order item
		OrderItemType orderItem = purchaseOrderType.getOrderItem();
		System.err.println(orderItem.getProductName());
		System.err.println(orderItem.getManufacturer());
		System.err.println(orderItem.getPrice());
		System.err.println(orderItem.getDescription());
		
		// getting shipping address
		ShippingAddressType address = purchaseOrderType.getShippingAddress();
		System.err.println(address.getAddressLine1());
		System.err.println(address.getAddressLine2());
		System.err.println(address.getCity());
		System.err.println(address.getState());
		
	}
}
