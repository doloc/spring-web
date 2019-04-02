package springmvcshopping.dao;

import springmvcshopping.entity.Product;
import springmvcshopping.model.PaginationResult;
import springmvcshopping.model.ProductInfo;

public interface ProductDAO {
	public Product findProduct(String code);

	public ProductInfo findProductInfo(String code);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

	public void save(ProductInfo productInfo);
}
