package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {}

	public static ProductDAO getInstance() {
		return instance;
	}

	public List<ProductVO> selectAllProducts() {
		
		String sql = "select * from product order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {	// 이동은 행 단위로
				ProductVO Vo = new ProductVO();
				Vo.setCode(rs.getInt("code"));
				Vo.setName(rs.getString("name"));
				Vo.setPrice(rs.getInt("price"));
				Vo.setPictureUrl(rs.getString("pictureurl"));
				Vo.setDescription(rs.getString("description"));
				list.add(Vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return list;
	}

	public void insertProduct(ProductVO vo) {
		String sql = "insert into product values(product_seq.nextval, ?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getPictureUrl());
			pstmt.setString(4, vo.getDescription());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
	}

	public int confirmID(String userid) {
		return 0;
	}

	public int userCheck(String userid, String pwd) {
		return 0;
	}

	public ProductVO selectProductByCode(int code) {
		
		String sql = "select * from product where code = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO vo = new ProductVO();
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getNString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPictureUrl(rs.getString("pictureurl"));
				vo.setDescription(rs.getString("description"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return vo;
	}

	public void updateProduct(ProductVO vo) {

	}
}
