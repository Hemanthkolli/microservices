package com.ecm.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	AddDeviceACSServiceImpl addDeviceACS;
	
   public AddDeviceACSServiceImpl getAddDeviceACS() {
		return addDeviceACS;
	}
   public void setAddDeviceACS(AddDeviceACSServiceImpl addDeviceACS) {
		this.addDeviceACS = addDeviceACS;
	}



	public String addDevice(Device device) {
		 Device  dev= new Device();
		/*for(Device addDevice:device){
	
			Gson gson = new Gson();
			String jsonString = gson.toJson(addDevice);
			getAddDeviceACS().addDeviceACS(jsonString);
			
			Device res = gson.fromJson(jsonString , Device.class);
			String serial= res.getSerial();
			Device resDsn=deviceRepository.findBySerial(serial);
			if(resDsn!=null){
				return "device is already exist";
			}*/
		    String serial=device.getSerial();
		    Device resDsn=deviceRepository.findBySerial(serial);
		    if(resDsn!=null){
		    	
				return serial +  "  device already registered";
			}
			 dev.setProductClass(device.getProductClass());
			 dev.setOui(device.getOui());
			 dev.setSerial(device.getSerial());
			dev.setDeviceId(device.getDeviceId());
			dev.setUserName(device.getUserName());
			
			 
			 deviceRepository.save(dev);
			
		
		return "registered";
	}

	@Override
	public Map<String,List<Device>> getAllDevices() {
		Map<String,List<Device>> map= new HashMap();
		List<Device> res=deviceRepository.findAll();
		map.put("Devices", res);
		return  map;
	}
	@Override
	public String addDevice(List<Device> device) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
