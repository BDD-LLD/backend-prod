/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldd.bdd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.ldd.bdd.DTO.ProductoMasSolicitadoDTO;
import com.ldd.bdd.DTO.TotalDeVentasDTO;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "Product")
@XmlRootElement

@NamedNativeQuery(name = "findProductMoreRequested", query = "SELECT TOP 1 SUM(T.lineTotal) as total_ventas, p.Name as nombre, p.ProductID as id_producto\r\n"
		+ "FROM productionaw.Production.Product p \r\n" + "	inner join(\r\n" + "		SELECT ProductID, lineTotal\r\n"
		+ "		FROM [salesaw].salesaw.Sales.SalesOrderDetail sod \r\n" + "		WHERE SalesOrderID in(\r\n"
		+ "			SELECT SalesOrderID\r\n" + "			FROM [salesaw].salesaw.Sales.SalesOrderHeader soh \r\n"
		+ "			WHERE TerritoryID in(\r\n" + "				SELECT TerritoryID \r\n"
		+ "				FROM [salesaw].salesaw.Sales.SalesTerritory st \r\n"
		+ "				WHERE [Group] = :p_Group\r\n" + "			)\r\n" + "		)\r\n" + "	) as T\r\n"
		+ "	on p.ProductID = T.ProductID\r\n" + "	GROUP BY p.Name, p.ProductID \r\n"
		+ "	ORDER  by total_ventas DESC " + "", resultSetMapping = "ProductoMasSolicitadoDTO")

@SqlResultSetMappings({ @SqlResultSetMapping(name = "ProductoMasSolicitadoDTO", classes = {
		@ConstructorResult(targetClass = ProductoMasSolicitadoDTO.class, columns = {
				@ColumnResult(name = "total_ventas", type = Double.class),
				@ColumnResult(name = "nombre", type = String.class),
				@ColumnResult(name = "id_producto", type = Integer.class) }) }) })

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ProductID")
	private Integer productID;
	@Basic(optional = false)
	@Column(name = "Name")
	private String name;
	@Basic(optional = false)
	@Column(name = "ProductNumber")
	private String productNumber;
	@Basic(optional = false)
	@Column(name = "MakeFlag")
	private boolean makeFlag;
	@Basic(optional = false)
	@Column(name = "FinishedGoodsFlag")
	private boolean finishedGoodsFlag;
	@Column(name = "Color")
	private String color;
	@Basic(optional = false)
	@Column(name = "SafetyStockLevel")
	private short safetyStockLevel;
	@Basic(optional = false)
	@Column(name = "ReorderPoint")
	private short reorderPoint;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "StandardCost")
	private BigDecimal standardCost;
	@Basic(optional = false)
	@Column(name = "ListPrice")
	private BigDecimal listPrice;
	@Column(name = "Size")
	private String size;
	@Column(name = "Weight")
	private BigDecimal weight;
	@Basic(optional = false)
	@Column(name = "DaysToManufacture")
	private int daysToManufacture;
	@Column(name = "ProductLine")
	private String productLine;
	@Column(name = "Class")
	private String class1;
	@Column(name = "Style")
	private String style;
	@Basic(optional = false)
	@Column(name = "SellStartDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sellStartDate;
	@Column(name = "SellEndDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sellEndDate;
	@Column(name = "DiscontinuedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date discontinuedDate;
	@Basic(optional = false)
	@Column(name = "rowguid")
	private String rowguid;
	@Basic(optional = false)
	@Column(name = "ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<ProductInventory> productInventoryList;
	@JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID")
	@ManyToOne
	private ProductModel productModelID;
	@JoinColumn(name = "ProductSubcategoryID", referencedColumnName = "ProductSubcategoryID")
	@ManyToOne
	private ProductSubcategory productSubcategoryID;
	@JoinColumn(name = "SizeUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
	@ManyToOne
	private UnitMeasure sizeUnitMeasureCode;
	@JoinColumn(name = "WeightUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
	@ManyToOne
	private UnitMeasure weightUnitMeasureCode;

	public Product() {
	}

	public Product(Integer productID) {
		this.productID = productID;
	}

	public Product(Integer productID, String name, String productNumber, boolean makeFlag, boolean finishedGoodsFlag,
			short safetyStockLevel, short reorderPoint, BigDecimal standardCost, BigDecimal listPrice,
			int daysToManufacture, Date sellStartDate, String rowguid, Date modifiedDate) {
		this.productID = productID;
		this.name = name;
		this.productNumber = productNumber;
		this.makeFlag = makeFlag;
		this.finishedGoodsFlag = finishedGoodsFlag;
		this.safetyStockLevel = safetyStockLevel;
		this.reorderPoint = reorderPoint;
		this.standardCost = standardCost;
		this.listPrice = listPrice;
		this.daysToManufacture = daysToManufacture;
		this.sellStartDate = sellStartDate;
		this.rowguid = rowguid;
		this.modifiedDate = modifiedDate;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public boolean getMakeFlag() {
		return makeFlag;
	}

	public void setMakeFlag(boolean makeFlag) {
		this.makeFlag = makeFlag;
	}

	public boolean getFinishedGoodsFlag() {
		return finishedGoodsFlag;
	}

	public void setFinishedGoodsFlag(boolean finishedGoodsFlag) {
		this.finishedGoodsFlag = finishedGoodsFlag;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public short getSafetyStockLevel() {
		return safetyStockLevel;
	}

	public void setSafetyStockLevel(short safetyStockLevel) {
		this.safetyStockLevel = safetyStockLevel;
	}

	public short getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(short reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public BigDecimal getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public int getDaysToManufacture() {
		return daysToManufacture;
	}

	public void setDaysToManufacture(int daysToManufacture) {
		this.daysToManufacture = daysToManufacture;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Date getSellStartDate() {
		return sellStartDate;
	}

	public void setSellStartDate(Date sellStartDate) {
		this.sellStartDate = sellStartDate;
	}

	public Date getSellEndDate() {
		return sellEndDate;
	}

	public void setSellEndDate(Date sellEndDate) {
		this.sellEndDate = sellEndDate;
	}

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public String getRowguid() {
		return rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@XmlTransient
	public List<ProductInventory> getProductInventoryList() {
		return productInventoryList;
	}

	public void setProductInventoryList(List<ProductInventory> productInventoryList) {
		this.productInventoryList = productInventoryList;
	}

	public ProductModel getProductModelID() {
		return productModelID;
	}

	public void setProductModelID(ProductModel productModelID) {
		this.productModelID = productModelID;
	}

	public ProductSubcategory getProductSubcategoryID() {
		return productSubcategoryID;
	}

	public void setProductSubcategoryID(ProductSubcategory productSubcategoryID) {
		this.productSubcategoryID = productSubcategoryID;
	}

	public UnitMeasure getSizeUnitMeasureCode() {
		return sizeUnitMeasureCode;
	}

	public void setSizeUnitMeasureCode(UnitMeasure sizeUnitMeasureCode) {
		this.sizeUnitMeasureCode = sizeUnitMeasureCode;
	}

	public UnitMeasure getWeightUnitMeasureCode() {
		return weightUnitMeasureCode;
	}

	public void setWeightUnitMeasureCode(UnitMeasure weightUnitMeasureCode) {
		this.weightUnitMeasureCode = weightUnitMeasureCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (productID != null ? productID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Product)) {
			return false;
		}
		Product other = (Product) object;
		if ((this.productID == null && other.productID != null)
				|| (this.productID != null && !this.productID.equals(other.productID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject1.Product[ productID=" + productID + " ]";
	}

}
