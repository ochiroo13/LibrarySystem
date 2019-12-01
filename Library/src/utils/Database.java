package utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import objects.Administrator;
import objects.Book;
import objects.Librarian;
import objects.Member;
import objects.User;

public class Database {

	public static List<Administrator> listAdmin;

	public static List<Librarian> listLibrarian;

	public static List<User> listUser;

	public static List<Book> listBook;

	public static List<Member> listMember;

	public static int maxIdAdmin;

	public static int maxIdLibrarian;

	public static int maxIdMember;

	public static int maxIdBook;

	public void initData() {
		initAdmins();
		initLibrarians();
		initUsers();
		initMembers();
		initBooks();
	}

	private void initBooks() {
	listBook= new ArrayList<Book>();
    Book bk = new Book();
    bk.setId(1);
    bk.setName("title 1");
    bk.setAuthorName("name 1");
    listBook.add(bk);
    bk = new Book();
    bk.setId(2);
    bk.setName("title 2");
    bk.setAuthorName("name 2");
    listBook.add(bk);
    bk = new Book();
    bk.setId(3);
    bk.setName("title 3");
    bk.setAuthorName("name 3");
    listBook.add(bk);
    
	}
	 
	private void initAdmins() {
		listAdmin = new ArrayList<Administrator>();

		Administrator admin = new Administrator();
		admin.setEmail("admin1@mum.edu");
		admin.setFirstName("Admin");
		admin.setLastLoginDate(new Date());
		admin.setLastName("Inistrator1");
		admin.setLoginName("admin1");
		admin.setPassword("password");
		admin.setSsn(1);
		admin.setGender(Const.MALE);
		listAdmin.add(admin);

		Administrator admin2 = new Administrator();
		admin2.setEmail("admin2@mum.edu");
		admin2.setFirstName("Admin2");
		admin2.setLastLoginDate(new Date());
		admin2.setLastName("Inistrator2");
		admin2.setLoginName("admin2");
		admin2.setPassword("password");
		admin2.setSsn(2);
		admin2.setGender(Const.FEMALE);
		listAdmin.add(admin2);

		maxIdAdmin = listAdmin.size();
	}

	private void initLibrarians() {
		listLibrarian = new ArrayList<Librarian>();

		Librarian librarian = new Librarian();
		librarian.setEmail("Ochirsuren@mum.edu");
		librarian.setFirstName("Ochirsuren");
		librarian.setLastLoginDate(new Date());
		librarian.setLastName("Surakhbayar");
		librarian.setLoginName("ochirsuren");
		librarian.setPassword("ochirsuren");
		librarian.setSsn(1);
		librarian.setGender(Const.MALE);
		listLibrarian.add(librarian);

		Librarian librarian2 = new Librarian();
		librarian2.setEmail("Bassem@mum.edu");
		librarian2.setFirstName("Bassem");
		librarian2.setLastLoginDate(new Date());
		librarian2.setLastName("El Sawy");
		librarian2.setLoginName("bassem");
		librarian2.setPassword("bassem");
		librarian2.setSsn(1);
		librarian2.setGender(Const.MALE);
		listLibrarian.add(librarian2);

		Librarian librarian3 = new Librarian();
		librarian3.setEmail("Ahmad@mum.edu");
		librarian3.setFirstName("Ahmad");
		librarian3.setLastLoginDate(new Date());
		librarian3.setLastName("Rashaideh");
		librarian3.setLoginName("ahmad");
		librarian3.setPassword("ahmad");
		librarian3.setSsn(1);
		librarian3.setGender(Const.MALE);
		listLibrarian.add(librarian3);

		Librarian librarian4 = new Librarian();
		librarian4.setEmail("Uuganbayar@mum.edu");
		librarian4.setFirstName("Uuganbayar");
		librarian4.setLastLoginDate(new Date());
		librarian4.setLastName("Oyun");
		librarian4.setLoginName("uuganbayar");
		librarian4.setPassword("uuganbayar");
		librarian4.setSsn(1);
		librarian4.setGender(Const.MALE);
		listLibrarian.add(librarian4);

		Librarian librarian5 = new Librarian();
		librarian5.setEmail("Oussama@mum.edu");
		librarian5.setFirstName("Oussama");
		librarian5.setLastLoginDate(new Date());
		librarian5.setLastName("Jablaou");
		librarian5.setLoginName("oussama");
		librarian5.setPassword("oussama");
		librarian5.setSsn(1);
		librarian5.setGender(Const.MALE);
		listLibrarian.add(librarian5);

		maxIdLibrarian = listLibrarian.size();
	}

	private void initUsers() {
		listUser = new ArrayList<User>();

		listUser.addAll(listAdmin);
		listUser.addAll(listLibrarian);
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
}
