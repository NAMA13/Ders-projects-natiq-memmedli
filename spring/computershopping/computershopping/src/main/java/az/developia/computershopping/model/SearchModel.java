package az.developia.computershopping.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchModel {
	private String search;
	private Integer begin;
	private Integer length;
}