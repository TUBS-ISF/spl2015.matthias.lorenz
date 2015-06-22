package Operations;

import java.util.List;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public interface OperationIF
{
	abstract String getName();
	abstract List<Appointment> doOperation(Coordinator c, Appointment a, int i);
}
