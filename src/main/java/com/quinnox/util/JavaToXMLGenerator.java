package com.quinnox.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.quinnox.pojo.Address;
import com.quinnox.pojo.Student;

public class JavaToXMLGenerator {
	public static void main(String[] args) throws Exception{
      File file = new File("src/main/resources/file.xml");
      JAXBContext context = JAXBContext.newInstance(Student.class);
      Student s = new Student();
      s.setName("Mohit Khare");
      s.setBranch("cse");
      s.setRoll(1233123);
      Address address = new Address();
      address.setAddressLine1("civil 1");
      address.setAddressLine2("near jagdish talkies");
      address.setCity("damoh");
      address.setState("Madhya Pradesh");
      s.setAddress(address);
      Marshaller marshaller = context.createMarshaller();
      marshaller.marshal(s, file);
	}
}
