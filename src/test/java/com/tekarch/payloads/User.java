/**
 * 
 */
package com.tekarch.payloads;

/**
 * userData.put("accountno", "TA-3334446");
		userData.put("departmentno", "1");
		userData.put("salary", "40000");
		userData.put("pincode", "123456");
*/
public class User {
	
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	
	public User(String accountno,String departmentno,String salary,String pincode ) {
		
		this.accountno=accountno;
		this.departmentno=departmentno;
		this.salary=salary;
		this.pincode=pincode;
		
	}

	public String getAccountno() {
		return accountno;
	}

	public String getDepartmentno() {
		return departmentno;
	}

	public String getSalary() {
		return salary;
	}

	public String getPincode() {
		return pincode;
	}

	
	
}
