package app;

import java.util.List;

import dao.CategoryDAOImpl;
import entity.CategoryInfo;

public class Main {

	public static void main(String[] args) {
		System.out.println("--------------- start");
		List<CategoryInfo> rs = CategoryDAOImpl.instant.getAllCategory();
		System.out.println(rs);
		System.out.println("--------------- end");
	}

}
