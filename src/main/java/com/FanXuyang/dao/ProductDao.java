package com.FanXuyang.dao;

import com.FanXuyang.model.Product;
import jdk.nashorn.internal.ir.SplitReturn;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {

            //for mysql
               pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        return n;
    }

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n = 0;
        String sql = "delete form product where productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        n = pt.executeUpdate();
        return n;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "update product set productName = ?, set ProductDescription = ?, set picture = ?, set price = ?, set category = ? where productId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {

            //for mysql
            pt.setBlob(3, instance.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        pt.setInt(6, instance.getProductId());
        n = pt.executeUpdate();
        return n;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        Product product = null;
        String sql = "select * from product where productId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        ResultSet rs = pt.executeQuery();
        if(rs.next()) {
            product = new Product(Integer.parseInt(rs.getString("productId")), Integer.parseInt(rs.getString("categoryId")),
                    rs.getString("productName"),
                    rs.getString("productDescription"),
                    new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)),
                    Double.parseDouble(rs.getString("price")));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from where categoryId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, categoryId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            productList.add(new Product(Integer.parseInt(rs.getString("productId")), Integer.parseInt(rs.getString("categoryId")),
                    rs.getString("productName"),
                    rs.getString("productDescription"), new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)),
                    Double.parseDouble(rs.getString("price"))));
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from where price >= ? and price <= ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setDouble(1, minPrice);
        pt.setDouble(2, maxPrice);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            productList.add(new Product(Integer.parseInt(rs.getString("productId")), Integer.parseInt(rs.getString("categoryId")),
                    rs.getString("productName"),
                    rs.getString("productDescription"), new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)),
                    Double.parseDouble(rs.getString("price"))));
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            productList.add(new Product(Integer.parseInt(rs.getString("productId")), Integer.parseInt(rs.getString("categoryId")),
                    rs.getString("productName"),
                    rs.getString("productDescription"), new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)),
                    Double.parseDouble(rs.getString("price"))));
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from where productName = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, productName);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            productList.add(new Product(Integer.parseInt(rs.getString("productId")), Integer.parseInt(rs.getString("categoryId")),
                    rs.getString("productName"),
                    rs.getString("productDescription"), new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)),
                    Double.parseDouble(rs.getString("price"))));
        }
        return productList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from where productId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            productList.add(new Product(Integer.parseInt(rs.getString("productId")), Integer.parseInt(rs.getString("categoryId")),
                    rs.getString("productName"),
                    rs.getString("productDescription"), new ByteArrayInputStream(rs.getString("picture").getBytes(StandardCharsets.UTF_8)),
                    Double.parseDouble(rs.getString("price"))));
        }
        return productList;
    }
}
