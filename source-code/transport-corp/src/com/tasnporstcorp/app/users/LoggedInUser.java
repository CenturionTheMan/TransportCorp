package com.tasnporstcorp.app.users;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.text.DateFormatter;

import com.tasnporstcorp.app.database.Filter;
public class LoggedInUser extends User {

	private ArrayList<String> filtersList;
	private ArrayList<String> sortingCriteria;

	/**
	 * 
	 * @param login
	 * @param role
	 * @param firstName
	 * @param lastName
	 */
	public LoggedInUser(String login, UserRole role, String firstName, String lastName) {
		super(login, firstName, lastName);
		filtersList = new ArrayList<>();
		sortingCriteria = new ArrayList<>();
	}

	public LoggedInUser(User user) {
		super(user.getLogin(), user.getFirstName(), user.getLastName());
		filtersList = new ArrayList<>();
		sortingCriteria = new ArrayList<>();
	}

	public void clearFiltersList() {
		filtersList.clear();		
	}

	/**
	 * 
	 * @param positionOnFiltersList
	 */
	public void removeFilter(int positionOnFiltersList) throws IllegalArgumentException{
		if(positionOnFiltersList < 0 || positionOnFiltersList >= filtersList.size())
			throw new IllegalArgumentException();

		filtersList.remove(positionOnFiltersList);
	}

	/**
	 * Dodaje do nowy filtr do listy filtrów użytkownika. Filtr składa się z: [atrybut];[typ warunku];[wartość] 
	 * @param attribute nazwa atrybutu, po którym odbywa się filtrowanie
	 * @param conditionType typ warunku, według którego odbywa się filtrowanie (najczęściej operator porówanania)
	 * @param conditionValue wartość używana w ramach sprawdzania warunku filtrowania
	 * 
	 * @throws IllegalArgumentException w wypadku, gdy podany zostanie nierozpoznawany przez system atrybut bądź typ
	 * warunku filtrowania (zdefiniowane w database.Filters)
	 */
	public void addFilter(String attribute, String conditionType, String conditionValue) throws IllegalArgumentException {
		// test poprawności atrybutu i wartości warunku
		switch (attribute) {
			case Filter.ORDER_NAME:
				break;
			case Filter.COMMODITY_VOLUME:
				try{
					Double.parseDouble(conditionValue);
				} catch (Exception e){
					throw new IllegalArgumentException("Niepoprawna objętość");
				}
				break;
			case Filter.ORDER_PRICE:
				try{
					Double.parseDouble(conditionValue);
				} catch (Exception e){
					throw new IllegalArgumentException("Niepoprawna cena");
				}
				break;
			case Filter.ORDER_DELIVERY_DATE:
				try{
					LocalDate.parse(conditionValue, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				} catch (Exception e){
					throw new IllegalArgumentException("Niepoprawna data dostarczenia");
				}
				break;
			default:
				throw new IllegalArgumentException("Niepoprawny atrybut filtrowania.");
		}

		// test poprawności typu warunku
		List<String> validConditionTypes = new ArrayList<>();
		validConditionTypes.add(Filter.EQUAL);
		validConditionTypes.add(Filter.GREATER);
		validConditionTypes.add(Filter.LESS);
		validConditionTypes.add(Filter.LESS_EQUAL);
		validConditionTypes.add(Filter.GREATER_EQUAL);
		if(!validConditionTypes.contains(conditionType))
			throw new IllegalArgumentException("Niepoprawny typ warunku");

		// dodanie filtra
		filtersList.add(attribute+";"+conditionType+";"+conditionValue);
	}

	public ArrayList<String> getFiltersList() {
		return this.filtersList;
	}

	/**
	 * 
	 * @param attribute
	 * @param ascending
	 */
	public void setSortingCriteria(String attribute, boolean ascending) {
		sortingCriteria.add(attribute);
		sortingCriteria.sort((x, y) -> x.compareTo(y));
	}

}