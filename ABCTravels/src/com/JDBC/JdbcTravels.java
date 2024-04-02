package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.travels.PlanJourney;

public class JdbcTravels {

	boolean isLoggedin = false;

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> userMap = new HashMap<Integer, String>();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctravels", "root",
				"Akash@111");
		Statement createStatement = connection.createStatement();
		BookingProcess(sc, connection);
		int i = 0;
		while (i < 3) {
			System.out.println("Enter value for the processing");
			System.out.println("1.New Registration");
			System.out.println("2.Login");
			System.out.println("3.Booking");
			System.out.println("4.Exit");
			int value = sc.nextInt();
			switch (value) {
			case 1:
				SignInprocess(sc, userMap, connection, createStatement);
				break;
			case 2:
				LoginDetailsofuser(sc, userMap, connection, createStatement);
				break;
			case 3:
				BookingProcess(sc, connection);
				break;
			case 4:
				System.out.println("Exited from menu");
				return;
			default:
				System.out.println("Enter Proper value");
				break;
			}
		}
	}

	private static void BookingProcess(Scanner sc, Connection connection) throws SQLException {
		String CreateQuery = "create table PassenegerDetails(Source char(10),Destination char(10),Journeydate date,NoofPassengers int ,PassengersDetails1 Char(10),Gender char(10),TotalFare float(10),Reschedule char(10),Paymentstatus char(10),BookingStatus char(10))";
		PreparedStatement ps1 = connection.prepareStatement(CreateQuery);
		String insertQuery = "insert into PassenegerDetails values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		PlanJourney planJourney = new PlanJourney();
		System.out.println("Enter Source place from given menu");
		System.out.println("Nellore");
		System.out.println("Ongole");
		System.out.println("Vijayawada");
		System.out.println("Hyderabad");
		System.out.println("Chennai");
		System.out.println("Tirupati");
		String choice = sc.next();
		ps.setString(1, choice);
		switch (choice) {
		case "Nellore":
			System.out.println("Source - Nellore");
			break;
		case "Ongole":
			System.out.println("Source - Ongole");
			break;
		case "Vijayawada":
			System.out.println("Source - Vijayawada");
			break;
		case "Hyderabad":
			System.out.println("Source - Hyderabad");
			break;
		case "e":
			System.out.println("Source - Chennai");
			break;

		default:
			System.out.println("Source -Tirupati");
			break;
		}
		planJourney.setSource(choice);
		System.out.println("Enter Destination place from given menu");
		System.out.println("Ongole");// Please enter with the given alphabetical order
		System.out.println("Nellore");
		System.out.println("Hyderabad");
		System.out.println("Vijaywada");
		System.out.println("Tirupati");
		System.out.println("Chennai");
		String choice1 = sc.next();
		planJourney.setDestination(choice1);
		ps.setString(2, choice1);
		switch (choice1) {
		case "Ongole":
			System.out.println("Ongole");
			break;
		case "Nellore":
			System.out.println("Destination - Nellore");
			break;
		case "Hyderabad":
			System.out.println("Destination - Hyderabad");
			break;
		case "Vijaywada":
			System.out.println("Destination - Vijaywada");
			break;
		case "Tirupati":
			System.out.println("Destination - Tirupati");
			break;

		default:
			System.out.println(" Destination - Chennai");
			break;
		}
		System.out.println("Enter the Date in yyyy-MM-dd format ");
		String date = sc.next();
		ps.setString(3, date);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, format);
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		final int totalseatscount = 60;
		int bookedseats = 10;
		int availableseats = totalseatscount - bookedseats;
		System.out.println("vacancies on that Date :" + availableseats);
		System.out.println("a.BookTickets");
		System.out.println("b.Trackthevehicle");
		String choiceforbooking = sc.next();
		switch (choiceforbooking) {
		case "a":
			System.out.println(planJourney.getSource() + " " + "to" + " " + planJourney.getDestination());
			System.out.println("Enter no of passengers");
			int passengers = sc.nextInt();
			ps.setInt(4, passengers);
			for (int i = 1; i <= passengers; i++) {
				System.out.println("Enter passenger" + " " + i + " " + "details");
				String passengerdetails = sc.next();
				ps.setString(i + 4, passengerdetails);
				System.out.println("M.male");
				System.out.println("F.Female");
				String gender1 = sc.next();
				ps.setString(i + 4 + passengers, gender1);
				switch (gender1) {
				case "M":
					System.out.println("Male");
					break;
				case "F":
					System.out.println("Female");
					break;
				default:
					System.out.println("Others");
					break;
				}
			}
			final int priceperkm = 5;
			final Double gst = 0.05;
			int distance = 200;
			double totalFare;
			if (dayOfWeek == dayOfWeek.SATURDAY || dayOfWeek == dayOfWeek.SUNDAY) {
				totalFare = (float) ((distance * priceperkm * passengers + passengers * 200)
						+ ((distance * priceperkm * passengers + 200) * gst));

				System.out.println("Total fare of journey" + "=" + totalFare);
			} else {
				totalFare = (distance * priceperkm * passengers) + ((distance * priceperkm * passengers + 200) * gst);
				System.out.println("Total fare of journey" + "=" + totalFare);
			}
			ps.setFloat(5 + passengers * 2, (float) totalFare);
			System.out.println("Are you want to reschedule your journey date");
			System.out.println("Y.yes");
			System.out.println("N.no");
			String schedulechoice = sc.next();
			ps.setString(6 + passengers * 2, schedulechoice);
			switch (schedulechoice) {
			case "Y":
				System.out.println("Enter no of days to be reschedule");
				int noofdays = sc.nextInt();
				LocalDate plusDays = localDate.plusDays(noofdays);
				System.out.println("New date :" + plusDays);
				break;
			case "N":
				System.out.println("Go to Payment Process");
				break;
			default:
				System.out.println("Enter proper choice");
				break;
			}
			String status = "Not Confirmed";
			System.out.println("Enter UPI Method");
			String transcation = sc.next();// paid or unpaid
			ps.setString(7 + passengers * 2, transcation);
			if (transcation.equals("paid")) {
				System.out.println("Booking Confirmed");
				status = "Booked";
				ps.setString(8 + passengers * 2, status);
				ps.executeUpdate();
				System.out.println("inserted");
				break;
			} else {
				System.out.println("Booking is not Confirmed");
				break;
			}
		case "b":
			System.out.println("Enter Tracking id");
			String bookingid = sc.next();
			break;

		default:
			System.out.println("kindly re enter the choice");
			break;
		}
	}

	private static void LoginDetailsofuser(Scanner sc, Map<Integer, String> userMap, Connection connection,
			Statement createStatement) throws SQLException {
		int failedCount = 0;
		String AccountStatus = "InActive";
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter your Emailid");
			String mailid = sc.next();
			System.out.println("Enter your Password");
			String password1 = sc.next();
			String insertquery = "insert into loginDetails Values (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(insertquery);
			ps.setString(1, mailid);
			ps.setString(2, password1);
			if (mailid.equals(userMap.get(1)) && password1.equals(userMap.get(2))) {
				System.out.println("Login successful");
				AccountStatus = "Active";
				ps.setString(3, AccountStatus);
				ps.executeUpdate();
				System.out.println("LogIn Details successfully Inserted to DataBase");
				BookingProcess(sc, connection);
				break;
			} else {
				System.out.println("Invalid Credentials");
				failedCount++;
			}
			if (failedCount >= 3) {
				System.out.println("Account is locked due to Multiple Attempts");
				AccountStatus = "Blocked";
			}

		}
	}

	private static void SignInprocess(Scanner sc, Map<Integer, String> userMap, Connection connection,
			Statement createStatement) {
		System.out.println("****Welcome to ABC Travels****");
		System.out.println("Sign up process");
		try {
			String createQuery = "Create table abctravelsignin ( firstname char(10),lastname char(10),mobilenumber char(10),gender char(10),Emailid char(10),password char(10))";
			System.out.println("Enter first name");
			String firstname = sc.next();
			System.out.println("Enter last name");
			String lastname = sc.next();
			System.out.println("Enter 10 digit Mobile number");
			String mobilenumber = sc.next();
			System.out.println("Enter your Gender");
			System.out.println("M.male");
			System.out.println("F.Female");
			String gender = sc.next();
			switch (gender) {
			case "M":
				System.out.println("Male");
				break;
			case "F":
				System.out.println("Female");
				break;
			default:
				System.out.println("Others");
				break;
			}
			System.out.println("Enter your Emailid");
			String Emailid = sc.next();
			userMap.put(1, Emailid);
			System.out.println("Enter your Password");
			String password = sc.next();
			userMap.put(2, password);
			System.out.println("Account created");
			String insertquery = "insert into abctravelsignin(firstname,lastname,mobilenumber,gender,emailid,password) values (?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(insertquery);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, mobilenumber);
			ps.setString(4, gender);
			ps.setString(5, Emailid);
			ps.setString(6, password);
			ps.executeUpdate();
			System.out.println("SignIn data successfully Inserted to DataBase");
			System.out.println("Kindly login to your account");
			LoginDetailsofuser(sc, userMap, connection, createStatement);
		} catch (Exception e) {
			System.out.println("Kindly recheck the given data");
		}

	}
}
