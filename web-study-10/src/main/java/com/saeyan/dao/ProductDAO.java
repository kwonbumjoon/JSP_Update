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

	public ProductDAO getInstance() {
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

	void insertProduct(ProductVO vo) {

	}

	int confirmID(String userid) {
		return 0;
	}

	int userCheck(String userid, String pwd) {
		return 0;
	}

	ProductVO selectProductByCode(String code) {
		return null;
	}

	void updateProduct(ProductVO vo) {

	}
}
