package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import objects.AdministratorRole;
import objects.Book;
import objects.LibrarianRole;
import objects.Member;
import objects.User;

public class Database {

	public static List<User> listUser;

	public static List<Book> listBook;

	public static List<Member> listMember;

	public static int maxIdAdmin;

	public static int maxIdLibrarian;

	public static int maxIdMember;

	public static int maxIdBook;

	public void initData() {
		initUsers();
		initMembers();
		initBook();

	}

	private void initUsers() {
		listUser = new ArrayList<User>();

		User user = new User();
		user.setEmail("admin1@mum.edu");
		user.setFirstName("Admin");
		user.setLastLoginDate(new Date());
		user.setLastName("Inistrator1");
		user.setLoginName("admin1");
		user.setPassword("password");
		user.setSsn(1);
		user.setGender(Const.MALE);
		user.addRole(new AdministratorRole());
		listUser.add(user);

		user = new User();
		user.setEmail("admin2@mum.edu");
		user.setFirstName("Admin2");
		user.setLastLoginDate(new Date());
		user.setLastName("Inistrator2");
		user.setLoginName("admin2");
		user.setPassword("password");
		user.setSsn(2);
		user.setGender(Const.FEMALE);
		user.addRole(new AdministratorRole());
		listUser.add(user);

		user = new User();
		user.setEmail("Ochirsuren@mum.edu");
		user.setFirstName("Ochirsuren");
		user.setLastLoginDate(new Date());
		user.setLastName("Surakhbayar");
		user.setLoginName("ochirsuren");
		user.setPassword("1");
		user.setSsn(1);
		user.setGender(Const.MALE);
		user.addRole(new LibrarianRole());
		user.addRole(new AdministratorRole());
		user.setPictureUrl("Ochirsuren.jpg");
		listUser.add(user);

		user = new User();
		user.setEmail("Bassem@mum.edu");
		user.setFirstName("Bassem");
		user.setLastLoginDate(new Date());
		user.setLastName("El Sawy");
		user.setLoginName("bassem");
		user.setPassword("bassem");
		user.setSsn(1);
		user.setGender(Const.MALE);
		user.addRole(new LibrarianRole());
		user.setPictureUrl("Bassem.jpg");
		listUser.add(user);

		user = new User();
		user.setEmail("Ahmad@mum.edu");
		user.setFirstName("Ahmad");
		user.setLastLoginDate(new Date());
		user.setLastName("Rashaideh");
		user.setLoginName("ahmad");
		user.setPassword("ahmad");
		user.setSsn(1);
		user.setGender(Const.MALE);
		user.addRole(new LibrarianRole());
		user.setPictureUrl("Ahmad.jpg");
		listUser.add(user);

		user = new User();
		user.setEmail("Uuganbayar@mum.edu");
		user.setFirstName("Uuganbayar");
		user.setLastLoginDate(new Date());
		user.setLastName("Oyun");
		user.setLoginName("uuganbayar");
		user.setPassword("uuganbayar");
		user.setSsn(1);
		user.setGender(Const.MALE);
		user.addRole(new LibrarianRole());
		user.setPictureUrl("Uuganbayar.jpg");
		listUser.add(user);

		user = new User();
		user.setEmail("Oussama@mum.edu");
		user.setFirstName("Oussama");
		user.setLastLoginDate(new Date());
		user.setLastName("Jablaou");
		user.setLoginName("oussama");
		user.setPassword("oussama");
		user.setSsn(1);
		user.setGender(Const.MALE);
		user.addRole(new LibrarianRole());
		user.setPictureUrl("Oussama.jpg");
		listUser.add(user);

	}

	private void initMembers() {
		listMember = new ArrayList<Member>();

		Member member1 = new Member();
		member1.setId(1);
		member1.setEmail("tony@mum.edu");
		member1.setPhone("99887788");
		member1.setFirstName("John");
		member1.setLastName("Snow");
		member1.setBirthDate(new Date());
		member1.setGender(Const.MALE);
		member1.setCheckedOutBooks(null);
		listMember.add(member1);

		Member member2 = new Member();
		member2.setId(2);
		member2.setEmail("danny@mum.edu");
		member2.setPhone("77887788");
		member2.setFirstName("Danny");
		member2.setLastName("Targaryen");
		member2.setBirthDate(new Date());
		member2.setGender(Const.FEMALE);
		member2.setCheckedOutBooks(null);
		listMember.add(member2);

		maxIdMember = listMember.size();
	}

	private void initBook() {
		
	}
}
