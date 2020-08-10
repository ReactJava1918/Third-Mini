package com.ssa.custom_generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSA_Id_Custom_generator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException  {
		// TODO Auto-generated method stub
		Integer seq_sufix=null;
		String  prefix="SSAUSA";
		Connection con=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		
		try {

			// ssa_id_sequence(ssa_id int);
		 con=session.connection();
		 stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery(" select max(ssa_id) from ssa_id_sequence");
		if(rs.next())
		{
			seq_sufix=	rs.getInt(1)+1;
			 pstmt=con.prepareStatement("insert into ssa_id_sequence  values(?)");
			 pstmt.setInt(1,seq_sufix);
			 pstmt.executeUpdate();
			
		}
		else
		{
			
			seq_sufix=1;
			 pstmt=con.prepareStatement("insert into ssa_id_sequence  values(?)");
			 pstmt.setInt(1,seq_sufix);
			 pstmt.executeUpdate();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prefix+seq_sufix;
	}

}
