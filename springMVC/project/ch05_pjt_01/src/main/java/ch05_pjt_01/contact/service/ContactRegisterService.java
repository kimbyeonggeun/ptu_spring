package ch05_pjt_01.contact.service;

import javax.inject.Inject;
import javax.inject.Named;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {

	@Inject
	@Named("contactDao1")
	private ContactDao contactDao;
//	
//	public ContactRegisterService() {
//		System.out.println("default constructor");
//	}

	@Inject
	@Named("contactDao1")
	public ContactRegisterService(ContactDao contactDao) {
//		System.out.println("contactDao: "+contactDao);

		this.contactDao = contactDao;
	}

	@Inject
	@Named("contactDao1")
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if (verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered.");
		}
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}

//	public void setWordDao(ContactDao contactDao) {
//	this.contactDao = contactDao;
//}

}
