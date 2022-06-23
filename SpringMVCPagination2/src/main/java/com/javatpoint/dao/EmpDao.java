package com.javatpoint.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.javatpoint.beans.Emp;





public class EmpDao
{
	 @Autowired
	 private HibernateTemplate hibernatetemplte;
	 public void save(Emp p){  
		    String sql="insert into emp99(name,lastName,destination,password ,admin) values('"+p.getName()+"','"+p.getLastName()+"','"+p.getDestination()+"','"+p.getPassword()+"','"+p.getAdmin()+"')";  
		    this.hibernatetemplte.save(sql);  
		}  
	 public void update(Emp p){  
		    String sql="update emp99 set name='"+p.getName()+"',lastname='"+p.getLastName()+"',destination='"+p.getDestination()+"' where id="+p.getId()+"";  
		    this.hibernatetemplte.update(sql);  
		}  
		public void delete(int id){  
		    String sql="delete from emp99 where id="+id+"";  
		     this.hibernatetemplte.update(sql);
	     }
		public String loginUser(Emp emp ) {
			
			String sql = "select name from emp99 where name=? and password=? ";
			
			try {

				String userId = this.hibernatetemplte.queryForObject(sql, new Object[] {
						emp.getId(), emp.getPassword() }, String.class);

				return userId;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		  
		public Emp getEmpById(int id){  
		    String sql="select * from emp99 where id=?";  
		    this.hibernatetemplte.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
		}  
		public List<Emp> getEmployees(){  
		    this.hibernatetemplte.query("select * from emp99",new RowMapper<Emp>(){  
		        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
		            Emp e=new Emp();  
		            e.setId(rs.getInt(1));  
		            e.setName(rs.getString(2));  
		            e.setLastName(rs.getString(3));  
		            e.setDestination(rs.getString(4)); 
		            e.setPassword(rs.getString(5));
		            e.setAdmin(rs.getString(6));
		            return e;  
		        }    
		    }); 
		}
		public List<Emp> searchEmployees(String string) {
			System.out.println(string);
			this.hibernatetemplte.query("select * from emp99 where name like '" + string + "%'", new RowMapper<Emp>() {
				public Emp mapRow(ResultSet rs, int row) throws SQLException {
					Emp e=new Emp();  
		            e.setId(rs.getInt(1));  
		            e.setName(rs.getString(2));  
		            e.setLastName(rs.getString(3));  
		            e.setDestination(rs.getString(4)); 
		            e.setPassword(rs.getString(5));
		            e.setAdmin(rs.getString(6));
					return e;
				}
			});
	}
	public int admin(Emp emp) {
	String sql = "select admin from emp99 where name=? and password=? ";
		
		try {

		
			if(sql.equals("yes")) {
				return 1;
			}
			else {
				return 0;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 2;
		}
		
	}    
}   
	  


  