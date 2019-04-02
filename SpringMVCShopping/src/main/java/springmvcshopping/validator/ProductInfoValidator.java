package springmvcshopping.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springmvcshopping.dao.ProductDAO;
import springmvcshopping.entity.Product;
import springmvcshopping.model.ProductInfo;

//Khai báo là một @Component (Nghĩa là 1 Bean).
@Component
public class ProductInfoValidator implements Validator {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0 == ProductInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductInfo productInfo = (ProductInfo) target;

		// Kiểm tra các trường (field) của ProductInfo.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

		String code = productInfo.getCode();
		if (code != null && code.length() > 0) {
			if (code.matches("\\s+")) {
				errors.rejectValue("code", "Pattern.productForm.code");
			} else if (productInfo.isNewProduct()) {
				Product product = productDAO.findProduct(code);
				if (product != null) {
					errors.rejectValue("code", "Duplicate.productForm.code");
				}
			}
		}
	}

}
