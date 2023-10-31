package ch05_pjt_01.contact.service;

import javax.inject.Inject;
import javax.inject.Named;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactSerchService {

	@Inject
	@Named("contactDao1")
	private ContactDao contactDao;
//	
//	public ContactSerchService() {
//		System.out.println("default constructor");
//	}

	@Inject
	@Named("contactDao1")
	public ContactSerchService(ContactDao contactDao) {
//		System.out.println("contactDao: "+contactDao);
		
		this.contactDao = contactDao;
	}

	@Inject
	@Named("contactDao1")
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public ContactSet searchContact(String name) {
		if (verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is available");
		}

		return null;
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}

}
