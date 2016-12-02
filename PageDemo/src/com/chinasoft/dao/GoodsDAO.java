package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chinasoft.entity.Goods;

public class GoodsDAO extends BaseDAO {
	
	//��ҳ
	public ArrayList<Goods> getPage(int pageNum){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst =null;

		try {

			//���Ӷ���
			con = getCon();

			//SQL
			String sql = "select top 3 * from goods where gid not in(select top ((?-1)*3) gid from goods)";

			//����SQL���Ķ���
			pst =  con.prepareStatement(sql);
			
			pst.setInt(1, pageNum);

			//�����ѯSQL��� �õ����
			rst = pst.executeQuery();

			//��������
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rst.next()){

				Goods goods = new Goods(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getString(4));
				//��������뼯��
				list.add(goods);
			}

			return list;

		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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

			//���Ӷ���
			con = getCon();

			//SQL
			String sql = "select count(*) from goods";

			//����SQL���Ķ���
			pst =  con.prepareStatement(sql);

			//�����ѯSQL��� �õ����
			rst = pst.executeQuery();
			
			if(rst.next()){
				return rst.getInt(1);
			}


		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			closeAll(con, pst, rst);
		}

		return -1;
	}
	
}
