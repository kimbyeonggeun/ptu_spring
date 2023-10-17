package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.Student;

public class PrintStudentInformationService {
	
	StudentAllSelectService allSelectService;
	
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	public void printStudentsInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("STUDENT LIST START ----------");
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.println("sNum : "+ student.getsNum() + "\t");
			System.out.println("sId : "+ student.getsId() + "\t");
			System.out.println("sPw : "+ student.getsPw() + "\t");
			System.out.println("sName : "+ student.getsName() + "\t");
			System.out.println("sAge : "+ student.getsAge() + "\t");
			System.out.println("sGender : "+ student.getsGender() + "\t");
			System.out.println("sMajor : "+ student.getsMajor() + "\t");
			System.out.println();
		}
		System.out.println("END -------------------------");
		System.out.println();
	}
}
