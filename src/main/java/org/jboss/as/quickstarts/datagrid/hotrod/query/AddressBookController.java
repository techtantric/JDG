package org.jboss.as.quickstarts.datagrid.hotrod.query;

import java.util.List;

import org.jboss.as.quickstarts.datagrid.hotrod.query.domain.Person;
import org.jboss.as.quickstarts.datagrid.hotrod.query.domain.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AddressBookController {
	
	@Autowired
	AddressBookManager addressbookManager;
	
	@RequestMapping(value="addperson", method=RequestMethod.POST)
	public Person addPerson(@RequestBody Person person) {
		return addressbookManager.addPerson_New(person);
	
	}
	
	@RequestMapping(value="addphone/{personId}", method=RequestMethod.POST)
	public Person addPerson(@RequestBody PhoneNumber phoneNumber, @PathVariable String personId) {
		return (Person)addressbookManager.addPhone_new(phoneNumber, personId);
	}
	
	@RequestMapping(value="removeData", method=RequestMethod.DELETE)
	public Person removeData(@RequestBody String id) {
		return addressbookManager.removePerson_New(id);
	}
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public List<Person> printAllEntries() {
		return addressbookManager.printAllEntries_New();
	}
	
	@RequestMapping(value="getpersonbyname/{name}", method=RequestMethod.GET)
	public List<Person> getPersonByName(@PathVariable String name) {
		return addressbookManager.queryPersonByNamebyIckle(name);
	}
	
	@RequestMapping(value="getfuzzypersonbyname/{name}", method=RequestMethod.GET)
	public List<Person> getFuzzyPersonByName(@PathVariable String name) {
		return addressbookManager.queryFuzzyPersonByNamebyIckle(name);
	}

}
