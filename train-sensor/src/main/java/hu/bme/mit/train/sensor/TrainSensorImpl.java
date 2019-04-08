package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private boolean alarm = false;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {

		if (speedLimit < 0 || speedLimit > 500) {
			this.alarm = true;
			return;
		}else{
			this.alarm = false;
		}
		double temp = this.speedLimit*0.5;
		if(speedLimit > this.speedLimit+temp || speedLimit < this.speedLimit+temp){
			this.alarm = true;
			return;
		}else{
			this.alarm = false;
		}

		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	public boolean getAlarmState(){
		return this.alarm;
	}

	public void setAlarmState(boolean alarm) {
		this.alarm = alarm;
	}

}
