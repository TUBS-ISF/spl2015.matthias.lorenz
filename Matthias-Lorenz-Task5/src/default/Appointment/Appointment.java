package Appointment; 
import java.util.Date; 
import java.util.GregorianCalendar; 


public  class  Appointment  implements java.io.Serializable {
	
	public Appointment(String name, Date date, String note)
	{
		this.name = name;
		this.date = date;
		this.note = note;
	}

	
	
	public Appointment(String name, int year, int month, int day, String note)
	{
		this.name = name;
		GregorianCalendar cal = new  GregorianCalendar(year, month - 1, day);
		this.date = cal.getTime();
		this.note = note;
	}

	
	
	
	public void printAppointment()
	{
		System.out.println("Name:\t" + name);
		System.out.println("Date:\t" + date);
		System.out.println("Note:\t" + note);
	}

	
	
	
	public String getName() 
	{
		return name;
	}

	

	
	public void setName(String name) 
	{
		this.name = name;
	}

	

	
	public Date getDate() 
	{
		return date;
	}

	

	
	public void setDate(Date date) 
	{
		this.date = date;
	}

	

	
	public String getNote() 
	{
		return note;
	}

	

	
	public void setNote(String note) 
	{
		this.note = note;
	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if((o instanceof Appointment))
		{
			Appointment b = (Appointment) o;
			if(this.name.equals((b.getName())) && this.date.equals(b.getDate())
					&& this.note.equals(b.getNote()))
			{
				return true;
			}
		}
		
		return false;
	}

	
	

	
	private String name;

	
	private Date date;

	
	private String note;


}
