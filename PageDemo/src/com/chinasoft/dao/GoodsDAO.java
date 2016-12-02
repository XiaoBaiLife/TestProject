package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chinasoft.entity.Goods;

public class GoodsDAO extends BaseDAO {
	
	//分页
	public ArrayList<Goods> getPage(int pageNum){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst =null;

		try {

			//连接对象
			con = getCon();

			//SQL
			String sql = "select top 3 * from goods where gid not in(select top ((?-1)*3) gid from goods)";

			//处理SQL语句的对象
			pst =  con.prepareStatement(sql);
			
			pst.setInt(1, pageNum);

			//处理查询SQL语句 得到结果
			rst = pst.executeQuery();

			//创建集合
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rst.next()){

				Goods goods = new Goods(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getString(4));
				//将对象放入集合
				list.add(goods);
			}

			return list;

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(con, pst, rst);
		}

		return null;
	}
	
	public int getTotal(){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst =null;

		try {

			//连接对象
			con = getCon();

			//SQL
			String sql = "select count(*) from goods";

			//处理SQL语句的对象
			pst =  con.prepareStatement(sql);

			//处理查询SQL语句 得到结果
			rst = pst.executeQuery();
			
			if(rst.next()){
				return rst.getInt(1);
			}


		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeAll(con, pst, rst);
		}

		return -1;
	}
	
}
