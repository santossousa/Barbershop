package one.digitalinnovationone.barbershop.repository.adapters.in;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import br.fabiosantos.barbershop.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class CustomerDB {

	@DynamoDBAttribute(attributeName = "Name")
	private String name;

	@DynamoDBAttribute(attributeName = "Email")
	private String email;

	@DynamoDBAttribute(attributeName = "Phone")
	private String phone;

	private CustomerDB(String name, String email, String phone) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public static CustomerDB from(Customer customer) {
		return CustomerDB.builder().name(customer.getName()).email(customer.getEmail()).phone(customer.getPhone())
				.build();
	}

	public static Customer to(CustomerDB customerDB) {
		return Customer.builder().name(customerDB.getName()).email(customerDB.getEmail()).phone(customerDB.getPhone())
				.build();
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	public static class Builder{
		@DynamoDBAttribute(attributeName = "Name")
		private String name;

		@DynamoDBAttribute(attributeName = "Email")
		private String email;

		@DynamoDBAttribute(attributeName = "Phone")
		private String phone;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public CustomerDB build() {
			return new CustomerDB(name, email, phone);
		}
		
	}
	public static Builder builder() {
		return new Builder();
	}

}
