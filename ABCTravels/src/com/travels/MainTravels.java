package com.travels;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainTravels {

	boolean isLoggedin = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> userMap = new HashMap<Integer, String>();
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
				SignInProcess(sc, userMap);
				break;
			case 2:
				LogInProcess(sc, userMap);
				break;
			case 3:
				Booking(sc);
				break;
			case 4:
				System.out.println("Exited from menu");
				return;
			default:
				System.out.println("Enter Proper value");
				break;
			}
			Booking(sc);
		}
	}
	private static void Booking(Scanner sc) {
		try {
			PlanJourney planJourney = new PlanJourney();
			System.out.println("Enter Source place from given menu");
			System.out.println("Nellore");
			System.out.println("Ongole");
			System.out.println("Vijayawada");
			System.out.println("Hyderabad");
			System.out.println("Chennai");
			System.out.println("Tirupati");
			String choice = sc.next();
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
				System.out.println(" Destination -  Chennai");
				break;
			}
			planJourney.setDestination(choice1);
			System.out.println("Enter the Date in yyyy-MM-dd format ");
			String date = sc.next();
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
				for (int i = 1; i <= passengers; i++) {
					System.out.println("Enter passenger" + " " + i + " " + "details");
					String passengerdetails = sc.next();
					System.out.println("a.male");
					System.out.println("b.Female");
					String gender = sc.next();
					switch (gender) {
					case "a":
						System.out.println("Male");
						break;
					case "b":
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
				if (dayOfWeek == dayOfWeek.SATURDAY || dayOfWeek == dayOfWeek.SUNDAY) {
					double Totalfare = (distance * priceperkm * passengers + passengers * 200)
							+ ((distance * priceperkm * passengers + 200) * gst);
					System.out.println("Total fare of journey" + "=" + Totalfare);
				} else {
					double Totalfare = (distance * priceperkm * passengers)
							+ ((distance * priceperkm * passengers + 200) * gst);
					System.out.println("Total fare of journey" + "=" + Totalfare);
				}
				System.out.println("Are you want to reschedule your journey date");
				System.out.println("a.yes");
				System.out.println("b.no");
				String choiceofscheduling = sc.next();
				switch (choiceofscheduling) {
				case "a":
					System.out.println("Enter no of days to be reschedule");
					int noofdays = sc.nextInt();
					LocalDate plusDays = localDate.plusDays(noofdays);
					System.out.println("New date :" + plusDays);
					break;
				case "b":
					System.out.println("Go to Payment Process");
					break;
				default:
					System.out.println("Enter proper choice");
					break;
				}
				System.out.println("Enter UPI Method");
				String transcation = sc.next();// paid or unpaid
				if (transcation.equals("paid")) {
					System.out.println("Booking Confirmed");
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
		} catch (Exception e) {
			System.out.println("Exception raised");
		}

	}

	private static void SignInProcess(Scanner sc, Map<Integer, String> userMap) {
		System.out.println("****Welcome to ABC Travels****");
		System.out.println("Sign up process");
		try {
			System.out.println("Enter first name");
			String firstname = sc.next();
			System.out.println("Enter last name");
			String lastname = sc.next();
			System.out.println("Enter 10 digit Mobile number");
			String mobilenumber = sc.next();
			System.out.println("Enter your Gender");
			System.out.println("a.male");
			System.out.println("b.Female");
			String gender = sc.next();
			switch (gender) {
			case "a":
				System.out.println("Male");
				break;
			case "b":
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
			UserRegistration user = new UserRegistration(firstname, lastname, mobilenumber, gender, Emailid, password,
					0, password);
			user.failedCount = 0;
			System.out.println("Kindly login to your account");
			LogInProcess(sc, userMap);
		} catch (Exception e) {
			System.out.println("Exception is occuring");
		}
	}

	private static void LogInProcess(Scanner sc, Map<Integer, String> userMap) {
		int failedCount = 0;

		try {
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter your Emailid");
				String mailid = sc.next();
				System.out.println("Enter your Password");
				String password = sc.next();
				if (mailid.equals(userMap.get(1)) && password.equals(userMap.get(2))) {
					System.out.println("Login successful");
					break;
				} else {
					System.out.println("Invalid Credentials");
					failedCount++;
				}
				if (failedCount >= 3) {
					System.out.println("Account is locked due to Multiple Attempts");
				}
			}

		} catch (Exception e) {
			System.out.println("Enter proper credentials");
		}
	}
}
