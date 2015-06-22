package DataHandling;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;

public class MySQLDataHandler implements StorageDataHandlerIF
{
    private Connection con; // dont close
    private PreparedStatement pst; //close after every query
    private ResultSet rs;
 

    
	public MySQLDataHandler()
	{
        String url = "";
        String user = "";
        String password = "";
        
        try
		{
			con = DriverManager.getConnection(url, user, password);
		} 
        catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	
	public void close()
	{
		try
		{
			con.close();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	public void writeAppointment(Appointment app)
	{	
		String query = "INSERT INTO appointment VALUES (?, ?, ?)";

	    try
		{
			pst = con.prepareStatement(query);
		
			pst.setString(1, app.getName());
	        pst.setDate(2, new Date(app.getDate().getTime()));
	        pst.setString(3, app.getNote());

			pst.executeUpdate();
			pst.close();
		} 
       catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	        try
			{
	        	pst.close();
			} 
	        catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	}


	public void writeAppointments(List<Appointment> app)
	{
		for(Appointment a : app)
		{
			writeAppointment(a);
		}
		
	}


	public List<Appointment> readAppointments()
	{
		String query = "SELECT * FROM appointment";
		LinkedList<Appointment> allAppointments = new LinkedList<Appointment>();

	    try
		{
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			
			if(rs != null)
			{				
				while(rs.next())
				{
					allAppointments.add(new Appointment(rs.getString("name"), new java.util.Date(rs.getDate("date").getTime()), rs.getString("note")));
				}	
			}
			pst.close();
			return allAppointments;
		} 
       catch (SQLException e)
		{
    	   e.printStackTrace();
		}
	    finally
	    {
	        try
			{
	        	pst.close();
			} 
	        catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		return allAppointments;
	}


	public void deleteAppointment(Appointment app)
	{
		String query = "DELETE FROM appointment WHERE name = ?";

	    try
		{
			pst = con.prepareStatement(query);
			pst.setString(1, app.getName());
			pst.executeUpdate();
			
			pst.close();
		} 
       catch (SQLException e)
		{
    	   e.printStackTrace();
		}
	    finally
	    {
	        try
			{
	        	pst.close();
			} 
	        catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	}


	public void deleteAppointment(int number)
	{
		String query = "DELETE FROM appointment WHERE name = (SELECT name FROM (SELECT name FROM appointment ORDER BY  name LIMIT ?,1) AS t)";

	    try
		{
			pst = con.prepareStatement(query);
			pst.setInt(1, number);
			pst.executeUpdate();
			
			pst.close();
		} 
       catch (SQLException e)
		{
    	   e.printStackTrace();
		}
	    finally
	    {
	        try
			{
	        	pst.close();
			} 
	        catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

}
