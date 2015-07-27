package com.momo.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="products")
public class ProductDo implements Serializable{
        
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @Column(name="PRODUCT_NAME")
        private String productName;
        
        @Column(name="PRODUCT_DESCRIPTION")
        private String productDescription;
        
        @Column(name="STOCK_QTY")
        private Double stockQty;
        
        @Column(name="PRICE")
        private Double price;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public String getProductDescription() {
                return productDescription;
        }

        public void setProductDescription(String productDescription) {
                this.productDescription = productDescription;
        }

        public Double getStockQty() {
                return stockQty;
        }

        public void setStockQty(Double stockQty) {
                this.stockQty = stockQty;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }
        
        @Override
        public String toString() {
            return new StringBuffer(productName)
            .append(productDescription).toString();
        }

        

}