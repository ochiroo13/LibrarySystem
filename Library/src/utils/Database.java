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

	public void initData() {
		initAdmins();
		initLibrarians();
		initUsers();
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
	}

	private void initUsers() {
		listUser = new ArrayList<User>();

		listUser.addAll(listAdmin);
		listUser.addAll(listLibrarian);
	}
}
