package br.com.entities;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.entities.enums.OrderStatus;

public class Order {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus order;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus order, Client client) {
		
		this.moment = moment;
		this.order = order;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return order;
	}

	public void setOrder(OrderStatus order) {
		this.order = order;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double total = 0;
		for( OrderItem order : items) {
			total += order.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order moment: (");
		builder.append(sdf.format(moment));
		builder.append(")\nOrder Status: ");
		builder.append(order+"\n");
		builder.append(client+"\n");
		builder.append("Order items:\n");
		builder.append(items+"\n");
		builder.append("\nTotal price: $"+total());
		return builder.toString();
		
	}
	
}
