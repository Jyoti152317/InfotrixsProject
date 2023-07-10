
import java.util.*;
import java.util.Scanner;

public class MainEmployee {
	
	private static List<Employee> emp = new ArrayList<>();
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean exit=false;
		
		while(!exit) {
			System.out.println(" Operation List ");
			System.out.println("1. Add Employee Details");
			System.out.println("2. View Employee Details");
			System.out.println("3. Update Employee Details");
			System.out.println("4. Delete Employee Details");
			System.out.println("5. Search Employee Details");
			System.out.println("6. Exit");
			int choise=sc.nextInt();
			sc.nextLine();
			
			switch (choise) {
			case 1:
				addEmpoyee(sc);
				break;

			case 2:
				viewEmployee();
				break;
			case 3:
				updateEmployee(sc);
				break;
			case 4:
				deleteEmployee(sc);
			case 5:
				searchEmployee(sc);
				break;
			}
		}
		
		sc.close();

	}
	
	
	
	private static void addEmpoyee(Scanner sc) {
		
		System.out.println("Enter Employee id:");
		int id=sc.nextInt();
		sc.nextLine();
		
		if(isDuplicateId(id)) {
			System.out.println("Employee already exist.");
			System.out.println();
			return;
		}
		
		System.out.println("Enter Employee firstName: ");
		String firstName=sc.nextLine();
		
		System.out.println("Enter Employee lastName: ");
		String lastName=sc.nextLine();
		System.out.println("Enter Employee email: ");
		String email=sc.nextLine();
		System.out.println("Enter Employee phone: ");
		String phone=sc.nextLine();
		System.out.println("Enter Employee salary: ");
		String salary=sc.nextLine();
		
		Employee employee=new Employee(id, firstName, lastName, email,phone, salary);
		emp.add(employee);
		
		System.out.println("Added");
		System.out.println();
		
	}
	
	public static boolean isDuplicateId(int id) {
		for(Employee employee: emp) {
			if(employee.getId()==id) {
				return true;
			}
		}
		return false;
		
	}
	
	public static void viewEmployee() {
		if(emp.isEmpty()) {
			System.out.println("No Employee found.");
		}
		else {
			System.out.println("Employee List:");
			for (Employee employee: emp) {
				System.out.println("Id: "+employee.getId());
				System.out.println("First Name: "+employee.getFirstName());
				System.out.println("Last Name: "+employee.getLastName());
				System.out.println("Email: "+employee.getEmail());
				System.out.println("Phone No.: "+employee.getPhone());
				System.out.println("Salary: "+employee.getSalary());
				System.out.println();
			}
		}
	}
	
	public static void updateEmployee(Scanner sc) {
		System.out.println("Enter Employee Id: ");
		int id=sc.nextInt();
		sc.nextLine();
		
		Employee employee=findEmployeeById(id);
		if(employee==null) {
			System.out.println("Employee not found");
		}
		else {
			System.out.println("Employee List:");
			System.out.println("Id: "+employee.getId());
			System.out.println("First Name: "+employee.getFirstName());
			System.out.println("Last Name: "+employee.getLastName());
			System.out.println("Email: "+employee.getEmail());
			System.out.println("Phone No.: "+employee.getPhone());
			System.out.println("Salary: "+employee.getSalary());
			System.out.println();
			System.out.println("Enter new Employee");
			
			System.out.println("Enter Employee First Name: ");
			String firstName=sc.nextLine();
			System.out.println("Enter Employee lastName: ");
			String lastName=sc.nextLine();
			System.out.println("Enter Employee email: ");
			String email=sc.nextLine();
			System.out.println("Enter Employee phone: ");
			String phone=sc.nextLine();
			System.out.println("Enter Employee salary: ");
			String salary=sc.nextLine();
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setPhone(phone);
			employee.setSalary(salary);
			
			System.out.println("Updated");
			System.out.println();
		}
	}
	
	public static void searchEmployee(Scanner sc) {
		System.out.println("Enter Employee Id: ");
		int id=sc.nextInt();
		sc.nextLine();
		
		Employee employee=findEmployeeById(id);
		if(employee==null) {
			System.out.println("Employee not found");
		}
		else {
			System.out.println("Employee List:");
			System.out.println("Id: "+employee.getId());
			System.out.println("First Name: "+employee.getFirstName());
			System.out.println("Last Name: "+employee.getLastName());
			System.out.println("Email: "+employee.getEmail());
			System.out.println("Phone No.: "+employee.getPhone());
			System.out.println("Salary: "+employee.getSalary());
			System.out.println();
		}
	}
	
	
	public static void deleteEmployee(Scanner sc)
    {
        System.out.println("Enter Employee Id : ");
        int id=sc.nextInt();
		sc.nextLine();
		
		Employee employee=findEmployeeById(id);
		if(employee==null) {
			System.out.println("Employee not found");
		}
		else {
			
			emp.remove(employee);
			
			System.out.println("Deleted");
			System.out.println();
		}
    }
	
	public static Employee findEmployeeById(int id) {
		for(Employee employee:emp)
			if(employee.getId()==id) {
				return employee;
			}
		return null;
		
	}
	
	

}
