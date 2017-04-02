
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

import dao.DeviceDAO;

public class RMIDeviceServer {
	public static void main (String[] argv) {
		
		try {
			System.setSecurityManager(new SecurityManager());

			RMIDevice d = new RMIDevice();			   		
			Registry reg = LocateRegistry.createRegistry(1111);
			Naming.rebind("RMIDevice", d);

			System.out.println("Device Server is ready.");
		}catch (Exception e) {
			System.out.println("Device Server failed: " + e);
		}
	}
}
